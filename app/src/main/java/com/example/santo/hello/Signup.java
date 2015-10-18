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

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;

import static android.text.TextUtils.isEmpty;

public class Signup extends Activity {

//    private   Button Signup;
     private EditText Username,Email, Password, City, Mobile_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        Email = (EditText) findViewById(R.id.Email);
        City = (EditText) findViewById(R.id.City);
        Mobile_no = (EditText) findViewById(R.id.Mobile_no);

        findViewById(R.id.Signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean validationError = false;
                StringBuilder validationErrorMessage = new StringBuilder("Please");
                if (isEmpty(Username)) {
                    validationError = true;
                    validationErrorMessage.append("Please Enter a UserName.");
                }
                if (isEmpty(Password)) {
                    validationError = true;
                    validationErrorMessage.append("Please Enter a Password.");
                }
                if (validationError) {
                    Toast.makeText(Signup.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                final ProgressDialog dlg = new ProgressDialog(Signup.this);
                dlg.setTitle("Please Wait");
                dlg.setMessage("Signing UP. Please Wait. ");
                dlg.show();

                ParseUser user = new ParseUser();
                user.setUsername(Username.getText().toString());
                user.setPassword(Password.getText().toString());
                user.setPassword(Email.getText().toString());
                user.setPassword(City.getText().toString());
                user.setPassword(Mobile_no.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {

                        dlg.dismiss();
                        if (e != null) {
                            Toast.makeText(Signup.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        } else {
                            Intent intent = new Intent(Signup.this, DispatchActivity.class);
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