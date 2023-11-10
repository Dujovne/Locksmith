package com.example.locksmith_guydujovne_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private Button btRegister;
    private EditText ptEmail2;
    private EditText ptPassword2;
    private String email,password;
    private Button btRegister2Login;
    private FirebaseHandler fbh = new FirebaseHandler(FirebaseAuth.getInstance(),RegisterActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btRegister = findViewById(R.id.btRegister);
        ptEmail2 = findViewById(R.id.ptEmail2);
        ptPassword2 = findViewById(R.id.ptPassword2);
        btRegister2Login = findViewById(R.id.btRegister2Login);


        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = ptEmail2.getText().toString();
                password = ptPassword2.getText().toString();

                fbh.register(email,password);
            }
        });

        btRegister2Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}