package com.example.santo.hello;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import static android.text.TextUtils.isEmpty;

public class Login extends Activity  {

    private EditText Username,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);

        findViewById(R.id.Login).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                boolean validationError = false;
                StringBuilder validationErrorMessage = new StringBuilder("Please");
                if (isEmpty((Username))) {
                    validationError = true;
                    validationErrorMessage.append("Please Enter a UserName.");
                }
                if (isEmpty((Password))) {
                    if (validationError) {
                        validationErrorMessage.append(", and ");
                    }
                    validationError = true;
                    validationErrorMessage.append("Please Enter a Password.");
                }

                validationErrorMessage.append(".");
                if (validationError) {
                    Toast.makeText(Login.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                final ProgressDialog dlg = new ProgressDialog(Login.this);
                dlg.setTitle("Please Wait");
                dlg.setMessage("Signing UP. Please Wait. ");
                dlg.show();

                ParseUser.logInInBackground(Username.getText().toString(), Password.getText()
                        .toString(), new LogInCallback(){
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        dlg.dismiss();
                        if (e != null) {
                            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        } else {
                            Intent intent = new Intent(Login.this, DispatchActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }

                    }
                });
            }
            });
        }

            private boolean isEmpty(EditText etText) {
                if (etText.getText().toString().trim().length() > 0) {
                    return false;
                } else {
                    return true;
                }
            }

}

