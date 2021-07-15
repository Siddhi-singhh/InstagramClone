package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void hello(View view){
        ParseObject boxer=new ParseObject("Boxer");
                boxer.put("punch_speed", 200);
        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    FancyToast.makeText(MainActivity.this,"Information added successfully!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                }
                else Toast.makeText(MainActivity.this, "Not Saved!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}