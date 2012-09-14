/**
 * Created with IntelliJ IDEA.
 * User: sean
 * Date: 14/09/12
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */

package SolasMatch.Express;

import SolasMatch.Express.Model.Task;
import SolasMatch.Express.Model.User;
import android.app.Activity;
import android.os.Bundle;
import SolasMatch.Express.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Vector;

public class Test extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        Vector<Task> tasklist=null;
        try {
            user = mapper.readValue(new URL("http://10.0.2.2:81/SOLAS-Match/api/v0/users/1/"), User.class);
            tasklist=mapper.readValue(new URL("http://10.0.2.2:81/SOLAS-Match/api/v0/tasks/"), new Vector<Task>().getClass());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        setContentView(R.layout.main);


    }
}