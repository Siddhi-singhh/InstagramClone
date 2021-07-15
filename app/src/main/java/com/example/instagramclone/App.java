package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("58hqQBrhjWyTvus9Sr7YuSWhNEKdXuUSb6nBDWYQ")
                // if defined
                .clientKey("DEmTtN7IVBDJEpWjlEhcNAUPyvMj0DXo1iHkK10A")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }


}
