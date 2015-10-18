package com.example.santo.hello;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by santo on 08/10/2015.
 */
public class SimpleApplication extends Application
{
    @Override
    public void onCreate()
    {
        Parse.initialize(this,"cbLSSGTCyMQjTCdhuk6rTh9BZB1pCN2ehzZ5QrjI","hwzpfnsKqatDYisuGvmawW2BdrAFGJy5p4VVF02n");
    }

}
