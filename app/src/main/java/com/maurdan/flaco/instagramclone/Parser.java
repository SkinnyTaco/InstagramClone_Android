package com.maurdan.flaco.instagramclone;

import com.parse.Parse;
import android.app.Application;


import com.parse.ParseACL;
import com.parse.ParseUser;

public class Parser extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

//        Parse.enableLocalDatastore(this);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("659cf036f5aad296ab1fd61010b43a1d3d3f5094")
                .clientKey("9d0d1a7f28bef10e05d1065b2570c8576c85e559")
                .server("http://13.58.186.216:80/parse")
                .build()
        );

//        ParseUser.enableAutomaticUser();
//
//        ParseACL defaultACL = new ParseACL();
//        defaultACL.setPublicReadAccess(true);
//        defaultACL.setPublicWriteAccess(true);
//        ParseACL.setDefaultACL(defaultACL, true);
    }
}
