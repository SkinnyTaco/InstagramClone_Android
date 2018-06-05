package com.maurdan.flaco.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Boolean signUpModeActive = true;
    TextView loginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTextView = findViewById(R.id.loginTextView);
        loginTextView.setOnClickListener(this);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.loginTextView) {

            Button signUpButton = findViewById(R.id.signUpButton);

            if (signUpModeActive) {
                signUpModeActive = false;
                signUpButton.setText("Login");
                loginTextView.setText("Signup");
            } else {
                signUpModeActive = true;
                signUpButton.setText("Signup");
                loginTextView.setText("Login");
            }

        }
    }

    public void signUpClicked(View view) {
        EditText userNameEditText = findViewById(R.id.userNameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        if (userNameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {
            Toast.makeText(this, "A username and a password are required", Toast.LENGTH_SHORT).show();
        } else {
            ParseUser user = new ParseUser();
            user.setUsername(userNameEditText.getText().toString());
            user.setPassword(passwordEditText.getText().toString());

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Log.i("Signup", "Success");
                    } else {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
