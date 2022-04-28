package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button signUpButton;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firstName = findViewById(R.id.first_name_signup);
        lastName = findViewById(R.id.last_name_signup);
        email = findViewById(R.id.email_signup);
        password = findViewById(R.id.password_signup);
        confirmPassword = findViewById(R.id.confirm_password_signup);
        signUpButton = findViewById(R.id.signup_button_login);
        myDatabase = new MyDatabase(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userFirstName = firstName.getText().toString();
                String userLastName = lastName.getText().toString();
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();

                boolean isUserExist = myDatabase.hasDuplicateUser(userEmail);
                if (isUserExist) {
                    Toast.makeText(SignUpActivity.this, "user already exists", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(userFirstName,userLastName, userEmail, userPassword);
                    boolean insertion = myDatabase.insertUser(user);
                    if (insertion) {
                        Toast.makeText(SignUpActivity.this, "successfully signed up", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignUpActivity.this, "something went wrong , try again later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }}