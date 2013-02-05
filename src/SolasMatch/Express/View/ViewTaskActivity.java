package SolasMatch.Express.View;

import SolasMatch.Express.R;
import SolasMatch.Express.ViewModel.LoginViewModel;
import SolasMatch.Express.ViewModel.TaskDetailsViewModel;
import SolasMatch.Express.ViewModel.ViewModel;
import android.app.Activity;
import android.os.Bundle;
import gueei.binding.Binder;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 17/09/12
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class ViewTaskActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel vm = new TaskDetailsViewModel(this);
        Binder.init(this.getApplication());
        Binder.setAndBindContentView(this, R.layout.task, vm);
    }
}