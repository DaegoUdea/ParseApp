package gr2.cmovil.udea.edu.co.parseapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class LoginSignupActivity extends ActionBarActivity {
    Button loginButton;
    Button signupButton;
    EditText username;
    EditText password;
    String txtUsername;
    String txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        loginButton = (Button)findViewById(R.id.Login);
        signupButton = (Button)findViewById(R.id.SignUp);

        username = (EditText)findViewById(R.id.UserName);
        password = (EditText)findViewById(R.id.Password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsername = username.getText().toString();
                txtPassword = password.getText().toString();

                ParseUser.logInInBackground(txtUsername, txtPassword, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if(parseUser != null){
                            Intent intent = new Intent(LoginSignupActivity.this, Welcome.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(
                                    getApplicationContext(),
                                    "This user doesn't exist. Please signup",
                                    Toast.LENGTH_SHORT).
                                    show();
                        }
                    }
                });
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsername = username.getText().toString();
                txtPassword = password.getText().toString();

                if(txtUsername.equals("") && txtPassword.equals("")){
                    Toast.makeText(
                            getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_SHORT).
                            show();
                }
                else{
                    ParseUser user = new ParseUser();
                    user.setUsername(txtUsername);
                    user.setPassword(txtPassword);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e == null){
                            Toast.makeText(getApplicationContext(),
                                    "Succesfully Signed up!",
                                    Toast.LENGTH_SHORT).
                                    show();
                            }
                            else{

                            }
                                    Toast.makeText(getApplicationContext(),
                                    "Sign up error",
                                    Toast.LENGTH_SHORT).
                                    show();
                        }
                    });
                }
            }
        });
    }
}
