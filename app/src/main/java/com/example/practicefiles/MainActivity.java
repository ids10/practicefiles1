package com.example.practicefiles;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;
    private TextView userRegistration;

    private final String Username = "Admin";
    private final String Password = "12345678";

    boolean isValid = false;
    private int counter =5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnIsha);
        eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);
        userRegistration = (TextView) findViewById(R.id.tvRegister);

        setContentView(R.layout.activity_main);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all details correctly", Toast.LENGTH_SHORT).show();

                }
                else {
                    isValid = validate(inputName, inputPassword);

                    if (!isValid) {
                        counter--;
                        Toast.makeText(MainActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();

                        eAttemptsInfo.setText("Number of Attempts Left: " + counter);

                        if (counter == 0) {
                            eLogin.setEnabled(false);
                        }


                    } else {
                        Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                        //Add code to go to new activity

                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);

                    }

                }

            }
        });



        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

    }
    private boolean validate(String name, String name1){
        if(name.equals(Username) && name1.equals(Password)){
            return true;
        }
        return false;

    }




    }




