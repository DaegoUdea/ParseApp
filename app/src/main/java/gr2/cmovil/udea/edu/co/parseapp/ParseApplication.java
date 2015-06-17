package gr2.cmovil.udea.edu.co.parseapp;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Daego on 16/06/2015.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Parse.initialize(this,
                "yfNsRxpSqZ0xCxfd3mojKdGcFWF5SPhnfqjx78qm",
                "vnN8QNW0LW71hfxgTZSYNgpl4zDPW31JaX6K8zYm");

        ParseUser.enableAutomaticUser();
        ParseACL defaultAcl = new ParseACL();
        defaultAcl.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultAcl,true);
    }
}
