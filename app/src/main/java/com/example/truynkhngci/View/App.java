package com.example.truynkhngci.View;

import android.app.Application;

public class App extends Application {
    private static  App Instance ;
        private Storage storage  ;
    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this ;
        storage = new Storage() ;

    }

    public Storage getStorage() {
        return storage;
    }

    public static App getInstance() {
        return Instance;
    }
}
