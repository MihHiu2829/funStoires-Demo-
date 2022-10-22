package com.example.app_truyen_cuoi;

import android.app.Application;

public class App extends Application {
    private static App instance ;
    private  Storagee storage ;

    public void onCreate() {
        super.onCreate();
        storage = new Storagee() ;
        instance = this ;
    }


    public  Storagee getStoragee() {
        storage = new Storagee(); ;
        return storage;
    }



    public static App getInstance()
        {
            return instance ;
        }
}
