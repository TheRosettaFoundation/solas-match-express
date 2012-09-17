package SolasMatch.Express.View;

import SolasMatch.Express.R;
import SolasMatch.Express.ViewModel.LoginViewModel;
import SolasMatch.Express.ViewModel.ProfileViewModel;
import SolasMatch.Express.ViewModel.ViewModel;
import android.app.Activity;
import android.os.Bundle;
import gueei.binding.Binder;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 16/09/12
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
public class ProfileActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel vm = new ProfileViewModel(this);
        Binder.init(this.getApplication());
        Binder.setAndBindContentView(this, R.layout.profile, vm);
    }
}