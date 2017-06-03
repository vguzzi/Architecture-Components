package com.architecturecomponents;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public App getApp() {
        App app = (App) getApplication();
        if (app != null) {
            return app;
        }
        return null;
    }
}
