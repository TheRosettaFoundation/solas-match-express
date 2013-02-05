package SolasMatch.Express.ViewModel;

import SolasMatch.Express.Model.Login;
import SolasMatch.Express.Model.Org;
import SolasMatch.Express.Model.Task;
import SolasMatch.Express.Model.User;
import SolasMatch.Express.R;
import SolasMatch.Express.View.MenuActivity;
import SolasMatch.Express.View.ViewTaskActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import com.fasterxml.jackson.databind.ObjectMapper;
import gueei.binding.Command;
import gueei.binding.Observable;
import gueei.binding.collections.ArrayListObservable;
import gueei.binding.observables.IntegerObservable;
import gueei.binding.observables.StringObservable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 17/09/12
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
public class TaskDetailsViewModel  extends ViewModel{

    public StringObservable targetLanguage= new StringObservable();
    public StringObservable sourceLanguage= new StringObservable();
    public StringObservable taskName= new StringObservable();
    public ArrayListObservable<String> tags = new ArrayListObservable<String>(String.class);
    public StringObservable impact = new StringObservable();
    public StringObservable created = new StringObservable();
    public StringObservable orgName = new StringObservable();
    public Task task=null;

    public TaskDetailsViewModel(Activity base) {
        super(base);

        Intent intent= ((Activity)getBaseContext()).getIntent();
        if(!intent.hasExtra("id")){
            Toast toast = new Toast(getBaseContext());
            toast.setGravity(Gravity.CENTER,0,0);
            toast.setText("no id was passed");
            toast.show();
            return;
        } else {
            int id =Integer.parseInt((String) intent.getExtras().get("id"));

            Org org =null;
            ObjectMapper mapper = new ObjectMapper();
            try {
                task = mapper.readValue(new URL(getString(R.string.taskUrl)+id+"/"),Task.class);
                org = mapper.readValue(new URL(getString(R.string.orgUrl)+task.getOrganisationID()+"/"),Org.class);
                taskName.set(task.getTitle().replaceAll("\n","").replaceAll("\r","").trim());
                sourceLanguage.set(task.getSourceLanguageID());
                targetLanguage.set(task.getTargetID());
                impact.set(task.getImpact());
                created.set(task.getCreatedTime());
                tags.addAll(task.getTags());
                orgName.set(org.getName());
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public TaskDetailsViewModel(Activity base,Task task) {
        super(base);
            this.task =task;
            Org org =null;
            ObjectMapper mapper = new ObjectMapper();
            try {
                org = mapper.readValue(new URL(getString(R.string.orgUrl)+task.getOrganisationID()+"/"),Org.class);
                taskName.set(task.getTitle().replaceAll("\n","").replaceAll("\r","").trim());
                sourceLanguage.set(task.getSourceLanguageID());
                targetLanguage.set(task.getTargetID());
                impact.set(task.getImpact());
                created.set(task.getCreatedTime());
                tags.addAll(task.getTags());
                orgName.set(org.getName());
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
    }

    public final Command claimTask= new Command() {

        @Override
        public void Invoke(View view, Object... objects) {
            if(!checkNetworkAvailable()){
                Toast toast =Toast.makeText(getApplicationContext(), "Please enable internet access", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }else{
                // move to AsyncTask
                ObjectMapper mapper = new ObjectMapper();
                try{
                    String id =SharedViewModel.getInstance(getApplicationContext()).getCurrentUser().getUserId();
                    URL url = new URL(getString(R.string.userUrl)+id+"/tasks/");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");//not needed but used for expliced meaning.
                    conn.setDoOutput(true);// also sets the connect to post by default.
                    mapper.writeValue(new OutputStreamWriter(new BufferedOutputStream(conn.getOutputStream())), task);
                    Toast toast =Toast.makeText(getApplicationContext(), getString(R.string.claimTaskSucess), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    ((Activity)getBaseContext()).finish();
                }catch (Exception e){
                    Toast toast =Toast.makeText(getApplicationContext(), getString(R.string.claimTaskFailure), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    Logger.getAnonymousLogger().warning("claim task Failed.\n"+e.getMessage());
                }

            }
        }
    };




}
