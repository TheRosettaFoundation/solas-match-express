package SolasMatch.Express.ViewModel;

import SolasMatch.Express.Model.Task;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import gueei.binding.Command;
import gueei.binding.observables.StringObservable;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 16/09/12
 * Time: 05:36
 * To change this template use File | Settings | File Templates.
 */
public class MenuViewModel extends ViewModel {

    public MenuViewModel(Activity activity) {
        super(activity);
    }
    private Task task = null;
    public StringObservable feturedTask = new StringObservable("Task info");
    public final Command viewTask = new Command(){

        @Override
        public void Invoke(View view, Object... objects) {
            Toast toast =Toast.makeText(getApplicationContext(), "displays selected task", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    };
    public final Command searchForTask = new Command(){

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
            Toast toast =Toast.makeText(getApplicationContext(), "View User Profile", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
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
