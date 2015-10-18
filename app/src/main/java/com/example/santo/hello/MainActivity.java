package com.example.santo.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Logout;
    EditText Username,Password,City,Mobile_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "cbLSSGTCyMQjTCdhuk6rTh9BZB1pCN2ehzZ5QrjI", "hwzpfnsKqatDYisuGvmawW2BdrAFGJy5p4VVF02n");
//        ParseObject Registeration = new ParseObject("Registeration");
//        Registeration.put("Santosh", "Hello..!!! ");
//        Registeration.saveInBackground();

        ParseUser.getCurrentUser().saveInBackground();

        Username =(EditText) findViewById(R.id.Username);
        City =(EditText) findViewById(R.id.City);
        Mobile_no =(EditText) findViewById(R.id.Mobile_no);
        Logout =(Button) findViewById(R.id.Logout);

        Logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.Logout:
            startActivity(new Intent(this,Signup.class));
                break;

        }
    }
}
