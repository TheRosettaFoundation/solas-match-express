package SolasMatch.Express.View;

import SolasMatch.Express.R;
import SolasMatch.Express.ViewModel.MenuViewModel;
import SolasMatch.Express.ViewModel.ViewModel;
import android.app.Activity;
import android.os.Bundle;
import gueei.binding.Binder;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 16/09/12
 * Time: 00:58
 * To change this template use File | Settings | File Templates.
 */
public class MenuActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel vm = new MenuViewModel(this);
        Binder.init(this.getApplication());
        Binder.setAndBindContentView(this, R.layout.menu, vm);
    }
}