package SolasMatch.Express.ViewModel;

import SolasMatch.Express.Model.Login;
import SolasMatch.Express.Model.User;
import SolasMatch.Express.R;
import android.content.Context;
import android.graphics.Path;
import android.text.AndroidCharacter;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import gueei.binding.Command;
import gueei.binding.DependentObservable;
import gueei.binding.Observable;
import com.fasterxml.jackson.databind.ObjectMapper;
import gueei.binding.observables.StringObservable;

import java.io.File;
import java.io.IOException;
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

    public StringObservable email = new StringObservable("test1@example.com");
    public StringObservable password = new StringObservable("test");
    public LoginViewModel(Context base) {
        super(base);
    }

    public final Command login = new Command() {
        @Override
        public void Invoke(View view, Object... objects) {
            ObjectMapper mapper = new ObjectMapper();
            Login login =null;
            try {
                login=(mapper.readValue(new URL(getString(R.string.base_webservice_url)+"/v0/login/"), Login.class));
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            if(login!=null){
             login.setEmail(email.get());
             login.setPass(password.get());
            }else login= new Login();
            Toast toast =Toast.makeText(getApplicationContext(), login.getEmail(), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    };
    public final Command register = new Command() {
        @Override
        public void Invoke(View view, Object... objects) {
            Toast toast =Toast.makeText(getApplicationContext(), "register triggered", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    };


}
