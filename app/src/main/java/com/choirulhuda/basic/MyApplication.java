package com.choirulhuda.basic;

import com.choirulhuda.basic.models.Session;

public class MyApplication extends android.app.Application {

    private static Session session;

    @Override
    public void onCreate() {
        super.onCreate();
        session = new Session(this);
    }

    public static Session getSession() {
        return session;
    }
}
