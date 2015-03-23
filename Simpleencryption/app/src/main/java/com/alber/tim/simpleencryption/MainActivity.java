package com.alber.tim.simpleencryption;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendEncry (View v) {
        startActivity(new Intent(MainActivity.this,Encryption_activity.class));
    }
    public void sendDecry (View v) {
        startActivity(new Intent(MainActivity.this,Decryption_activity.class));
    }
    public void sendCrackDecry (View v) {
        startActivity(new Intent(MainActivity.this,Crack_Decryption_activity.class));
    }
}
