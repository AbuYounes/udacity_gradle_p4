package com.example.android.jokeslibraryandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class JokesAndroidActivity extends AppCompatActivity {
    public static final String EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_android);
    }
}
