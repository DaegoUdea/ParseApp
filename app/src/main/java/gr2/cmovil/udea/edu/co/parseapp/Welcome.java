package gr2.cmovil.udea.edu.co.parseapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;


public class Welcome extends ActionBarActivity {
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        logout = (Button) findViewById(R.id.Logout);
        ParseUser currentUser = ParseUser.getCurrentUser();
        String struser = currentUser.getUsername().toString();

        TextView txtUser = (TextView)findViewById(R.id.TxtUser);
        txtUser.setText("You are logged in as " + struser);

        logout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ParseUser.logOut();
                finish();
            }
        });
    }
}
