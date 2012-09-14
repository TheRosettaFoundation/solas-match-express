package SolasMatch.Express.ViewModel;

import android.content.Context;
import android.content.ContextWrapper;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 14/09/12
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
public abstract class ViewModel  extends ContextWrapper{

    public ViewModel(Context base) {
        super(base);
    }
}
