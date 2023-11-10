package com.example.locksmith_guydujovne_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button btLogin;
    private EditText ptEmail1;
    private EditText ptPassword1;
    private String email,password;
    private Button btMain2Register;
    private FirebaseHandler fbh = new FirebaseHandler(FirebaseAuth.getInstance(),MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin = findViewById(R.id.btLogin);
        ptEmail1 = findViewById(R.id.ptEmail1);
        ptPassword1 = findViewById(R.id.ptPassword1);
        btMain2Register = findViewById(R.id.btMain2Register);


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = ptEmail1.getText().toString();
                password = ptPassword1.getText().toString();

                fbh.signIn(email,password);

            }
        });


    }
}