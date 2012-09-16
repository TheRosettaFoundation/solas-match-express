package SolasMatch.Express.ViewModel;

import SolasMatch.Express.Model.Login;
import SolasMatch.Express.Model.User;
import SolasMatch.Express.R;
import SolasMatch.Express.View.MenuActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import com.fasterxml.jackson.databind.ObjectMapper;
import gueei.binding.Command;
import gueei.binding.Observable;
import gueei.binding.observables.StringObservable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 14/09/12
 * Time: 11:47
 * To change this template use File | Settings | File Templates.
 */
public class LoginViewModel extends ViewModel {
    private Observable<User>    user = new Observable<User>(User.class);

    public Observable<User> getUser() {
        return user;
    }

    public void setUser(Observable<User> user) {
        this.user = user;
    }
    public void setUser(User user) {
        this.user.set(user);
    }

    public Observable<Bitmap> logo = new Observable<Bitmap>(Bitmap.class);
    public StringObservable email = new StringObservable("test1@example.com");
    public StringObservable password = new StringObservable("test");

    public LoginViewModel(Activity base) {
        super(base);
        try {
            logo.set(BitmapFactory.decodeStream(getAssets().open("logo.png")));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

        }
    }

    public final Command login = new Command() {

        @Override
        public void Invoke(View view, Object... objects) {
            if(!checkNetworkAvailable()){
                Toast toast =Toast.makeText(getApplicationContext(), "Please enable internet access", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }else{
                // move to AsyncTask
                ObjectMapper mapper = new ObjectMapper();
                Login login =new Login();
                login.setEmail(email.get());
                login.setPass(password.get());
                try{

                    URL url = new URL(getString(R.string.base_webservice_url)+"/v0/login/");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");//not needed but used for expliced meaning.
                    conn.setDoOutput(true);// also sets the connect to post by default.
                    mapper.writeValue(new OutputStreamWriter(new BufferedOutputStream(conn.getOutputStream())), login);
                    user.set(mapper.readValue(new BufferedInputStream(conn.getInputStream()), User.class));
                }catch (Exception e){}

                String message = getString(R.string.login_success);
                if(user.isNull()) message = getString(R.string.login_failure);

                Toast toast =Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                if(!user.isNull()){
                    ((Activity)getBaseContext()).finish();
                    getBaseContext().startActivity(new Intent(getBaseContext(), MenuActivity.class));
                }
            }
        }
    };

    public final Command register = new Command() {
        @Override
        public void Invoke(View view, Object... objects) {
            if(!checkNetworkAvailable()){
                Toast toast =Toast.makeText(getApplicationContext(), "Please enable internet access", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }else{
                // move to AsyncTask
                ObjectMapper mapper = new ObjectMapper();
                Login login = new Login();
                login.setEmail(email.get());
                login.setPass(password.get());
                try{
                    URL url = new URL(getString(R.string.base_webservice_url)+"/v0/register/");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");//not needed but used for expliced meaning.
                    conn.setDoOutput(true);// also sets the connect to post by default.
                    mapper.writeValue(new OutputStreamWriter(new BufferedOutputStream(conn.getOutputStream())), login);
                    user.set(mapper.readValue(new BufferedInputStream(conn.getInputStream()), User.class));
                }catch (Exception e){}
                String message = getString(R.string.register_success);
                if(user.isNull()) message = getString(R.string.register_failure);
                Toast toast =Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                if(!user.isNull()){
                    SharedViewModel.getInstance(getApplicationContext()).getCurrentUser().set(user.get());
                    ((Activity)getBaseContext()).finish();
                    getBaseContext().startActivity(new Intent(getBaseContext(), MenuActivity.class));
                }
            }

        }
    };


}
