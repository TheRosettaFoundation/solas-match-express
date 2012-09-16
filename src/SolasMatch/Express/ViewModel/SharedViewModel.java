package SolasMatch.Express.ViewModel;

import SolasMatch.Express.Model.User;
import android.content.Context;
import gueei.binding.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 16/09/12
 * Time: 01:52
 * To change this template use File | Settings | File Templates.
 */
public class SharedViewModel extends ViewModel {
    private static SharedViewModel instance = null;
    private SharedViewModel(Context base) {
        super(base);
    }
    public static SharedViewModel getInstance(Context base){
        return instance==null?(instance=new SharedViewModel(base)):instance;
    }
    private Observable<User> currentUser = new Observable<User>(User.class);

    public Observable<User> getCurrentUser() {
        return currentUser;
    }

}
