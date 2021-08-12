package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtLoginEmail,edtLoginPassword;
    private Button btnLogin,btnSignupLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Log in");
        edtLoginEmail=findViewById(R.id.edtloginUserame);
        edtLoginPassword=findViewById(R.id.edtloginPassword);
        btnLogin=findViewById(R.id.btnLoginActivity);
        btnSignupLogin=findViewById(R.id.btnSignupLoginActivity);
        btnLogin.setOnClickListener(this);
        btnSignupLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoginActivity:
                if(edtLoginPassword.getText().toString().equals("") || edtLoginEmail.getText().toString().equals("")){
                    FancyToast.makeText(LoginActivity.this, "Please enter a valid username or email and password!", Toast.LENGTH_SHORT,
                            FancyToast.INFO,true).show();
                }
                else {
                    ParseUser.logInInBackground(edtLoginEmail.getText().toString(), edtLoginPassword.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user != null && e == null) {
                                FancyToast.makeText(LoginActivity.this, user.getUsername() + " is Logged in successfully", Toast.LENGTH_SHORT,
                                        FancyToast.SUCCESS, true).show();
                                transitionToSocialMediaActivity();
                            } else {
                                FancyToast.makeText(LoginActivity.this, "Please try again!", Toast.LENGTH_SHORT,
                                        FancyToast.ERROR, true).show();
                            }
                        }
                    });
                }
                break;
            case R.id.btnSignupLoginActivity:
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

                break;

        }
    }
    private void transitionToSocialMediaActivity(){
        Intent intent=new Intent(LoginActivity.this,SocialMediaActivity.class);
        startActivity(intent);
    }
}