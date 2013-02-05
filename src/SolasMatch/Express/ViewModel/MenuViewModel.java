package SolasMatch.Express.ViewModel;

import SolasMatch.Express.Model.Task;
import SolasMatch.Express.View.MenuActivity;
import SolasMatch.Express.View.ProfileActivity;
import SolasMatch.Express.View.ViewTaskActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import gueei.binding.Command;
import gueei.binding.observables.IntegerObservable;
import gueei.binding.observables.StringObservable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 16/09/12
 * Time: 05:36
 * To change this template use File | Settings | File Templates.
 */
public class MenuViewModel extends ViewModel {
    private Task task = null;
    public IntegerObservable colour = new IntegerObservable(Color.DKGRAY);
    public StringObservable feturedTask = new StringObservable("Task info");



    public MenuViewModel(Activity activity) {
        super(activity);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    String id= SharedViewModel.getInstance(getApplicationContext()).getCurrentUser().getUserId();
                    List<Task> tasks=   (mapper.readValue(new URL("http://193.1.97.45/SOLAS-Match/api/v0/users"+"/"+id+"/top_tasks/ "), new TypeReference<ArrayList<Task>>() { }));
                    task = tasks.get(0);
                    StringBuilder sb = new StringBuilder();
                    sb.append(task.getTitle().replaceAll("\n","").replaceAll("\r","").trim());
                    sb.append("\nTags: ");
                    for(String s : task.getTags()) sb.append(s.trim()+", \t");
                    sb.delete(sb.length() - 1, sb.length());
                    sb.append("\n");
                    sb.append("From:"+task.getSourceLanguageID()+" To:"+task.getTargetID());
                    sb.append("\n");
                    feturedTask.set(sb.toString());
                } catch (Exception e) {
                    Logger.getAnonymousLogger().warning("task load failed"+e.getMessage());
                }
            }
        });
        thread.start();
    }


    public final Command viewFeturedTask = new Command(){
        @Override
        public void Invoke(View view, Object... objects) {

            if(task!=null){
                Intent intent = new Intent(getBaseContext(), ViewTaskActivity.class);
                intent.putExtra("id",task.getId());
                getBaseContext().startActivity(intent);
            }else {
                Toast toast =Toast.makeText(getApplicationContext(), "displays selected task", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        }
    };
    public final Command searchForTasks = new Command(){

        @Override
        public void Invoke(View view, Object... objects) {
            Toast toast =Toast.makeText(getApplicationContext(), "searches for task", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    };
    public final Command searchForOrgs = new Command(){

        @Override
        public void Invoke(View view, Object... objects) {
            Toast toast =Toast.makeText(getApplicationContext(), "searches for an organisation" , Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    };
    public final Command viewProfile = new Command(){

        @Override
        public void Invoke(View view, Object... objects) {
            getBaseContext().startActivity(new Intent(getBaseContext(), ProfileActivity.class));
        }
    };
    public final Command about = new Command(){

        @Override
        public void Invoke(View view, Object... objects) {
            Toast toast =Toast.makeText(getApplicationContext(), "displays infomation about the app", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    };
}
