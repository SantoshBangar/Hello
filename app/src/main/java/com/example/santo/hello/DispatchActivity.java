package com.example.santo.hello;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseUser;

public class DispatchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(ParseUser.getCurrentUser()!= null){

            startActivity(new Intent(this,MainActivity.class));
        }else
        {
            startActivity(new Intent(this,Signup_Or_Login.class));
        }
    }
}
