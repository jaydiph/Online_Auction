package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp_new extends AppCompatActivity {

    public Button button;
    public EditText name,email,password,phoneno,address;
    boolean isAllFieldsChecked = false;
    public CheckBox terms;
    public TextView termss;
    public RadioButton seller,buyer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_new);

        termss =(TextView) findViewById(R.id.tc);
        button = (Button) findViewById(R.id.button11);
        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.TextPassword);
        phoneno = (EditText) findViewById(R.id.editTextNumber);
        address = (EditText) findViewById(R.id.Address);
        terms = (CheckBox) findViewById(R.id.checkBox);
        seller = (RadioButton) findViewById(R.id.radiosellerreg);
        buyer = (RadioButton) findViewById(R.id.radiobuyerreg);

        termss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), terms_and_condition.class);
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
                else if(!seller.isChecked()) {
                    seller.setError("Select Type Of user");
                    seller.requestFocus();
                }
                else if(!buyer.isChecked()){
                    buyer.setError("Select Type Of user");
                    buyer.requestFocus();
                }
            }
        });



    }


    private boolean CheckAllFields() {
        if (name.length() == 0) {
            name.setError("This field is required");
            name.requestFocus();
            return false;
        }


        if (email.length() == 0) {
            email.setError("Email is required");
            email.requestFocus();
            return false;
        }

        if (address.length() == 0) {
            address.setError("This field is required");
            address.requestFocus();
            return false;
        }

        if (phoneno.length() == 0) {
            phoneno.setError("Phone no is required");
            phoneno.requestFocus();
            return false;
        } else if (password.length() > 10) {
            password.setError("Phone must be maximum 10 digits");
            phoneno.requestFocus();
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
        if (!terms.isChecked()) {
            address.setError("*");
            address.requestFocus();
            return false;
        }


        // after all validation return true.
        return true;
    }
}