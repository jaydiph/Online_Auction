package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class
MainActivity extends AppCompatActivity {


    public Button button;
    public TextView textView,fpass;
    public EditText email, password;
    public RadioButton seller,buyer;
    boolean isAllFieldsChecked = false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fpass=(TextView) findViewById(R.id.forgotpassword);
        button = (Button) findViewById(R.id.btnlogin);
        textView = (TextView) findViewById(R.id.txt);
        email = (EditText) findViewById(R.id.etemail);
        password = (EditText) findViewById(R.id.mypass);
        seller = (RadioButton) findViewById(R.id.radioSeller);
        buyer = (RadioButton) findViewById(R.id.radioBuyer);

        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Forgot_Password.class);
                startActivity(i);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {
                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);
                }

                if (seller.isChecked()){
                    Intent i = new Intent(getApplicationContext(), sellerhome.class);
                    startActivity(i);
                }
                else if(!seller.isChecked()){
                    seller.setError("Select Type Of user");
                    seller.requestFocus();
                }
                else if(!buyer.isChecked()){
                    buyer.setError("Select Type Of user");
                    buyer.requestFocus();
                }

            }

        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp_new.class);
                startActivity(intent);

            }
        });


    }

    private boolean CheckAllFields() {

        if (email.length() == 0) {
            email.setError("Email is required");
            email.requestFocus();
            return false;
        }


        if (password.length() == 0) {
            password.setError("Password is required");
            password.requestFocus();
            return false;
        } else if (password.length() < 8) {
            password.setError("Password must be minimum 8 characters");
            password.requestFocus();
            return false;
        }




        // after all validation return true.
        return true;
    }
}



















