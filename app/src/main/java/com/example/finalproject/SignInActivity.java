package com.example.finalproject;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button logInButton;
    Button signUpButton;
    SharedPreferences sharedPreferences;
    MyDatabase myDatabase;

    public final String SHARED_PREFERENCES = "SHARED_PREFERENCES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
        logInButton = findViewById(R.id.login_button_login);
        signUpButton = findViewById(R.id.signup_button_login);
        myDatabase = new MyDatabase(this);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                Boolean isUserExist = myDatabase.checkUser(userEmail, userPassword);
                if (isUserExist) {
                    saveUserData();
                    Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignInActivity.this, "user doesn't exist , please sign up", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void saveUserData() {
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email.getText().toString());
        editor.putString("firstName", myDatabase.getUserFirstName(email.getText().toString()));
        editor.putString("lastName", myDatabase.getUserLastName(email.getText().toString()));
        editor.apply();
        Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
    }
}