package SolasMatch.Express.ViewModel;

import SolasMatch.Express.Model.User;
import SolasMatch.Express.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import com.fasterxml.jackson.databind.JavaType;
import gueei.binding.Observable;
import gueei.binding.observables.IntegerObservable;
import gueei.binding.observables.StringObservable;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 16/09/12
 * Time: 12:32
 * To change this template use File | Settings | File Templates.
 */
public class ProfileViewModel extends ViewModel {
    public Observable<Bitmap> gravitar = new Observable<Bitmap>(Bitmap.class);
    public StringObservable displayName= new StringObservable();
    public IntegerObservable colour = new IntegerObservable(Color.DKGRAY);
    public ProfileViewModel(Activity base) {
        super(base);
       Thread thread = new Thread(new Runnable() {
           @Override
           public void run() {
               try{
                   User user=SharedViewModel.getInstance(getApplicationContext()).getCurrentUser();
                   displayName.set(user.getDisplayName()==null?user.getEmail():user.getDisplayName());
                   URL url = new URL(getString(R.string.gravatar_avatar_url)+"/"+ md5(user.getEmail().toLowerCase().trim()));
                   URLConnection conn=url.openConnection();
                   gravitar.set(BitmapFactory.decodeStream(conn.getInputStream()));
               } catch (Exception e ) {
                   Logger.getAnonymousLogger().warning("no gravitar image found");
               }
           }
       });
       thread.start();
    }
}
