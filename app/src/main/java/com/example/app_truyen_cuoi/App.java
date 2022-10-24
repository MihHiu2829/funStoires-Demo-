package com.example.app_truyen_cuoi;

import android.app.Application;

public class App extends Application {
    private static App instance ;
    private  Storagee storage ;

    public void onCreate() {
        super.onCreate();
        instance = this ;
        storage = new Storagee() ;
    }


    public  Storagee getStoragee() {
        return storage;
    }



    public static App getInstance()
        {
            return instance ;
        }
}
