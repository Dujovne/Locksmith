package com.example.locksmith_guydujovne_finalproject;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseHandler {

    private FirebaseAuth auth;

    private Context context;


    public FirebaseHandler(FirebaseAuth auth, Context context)
    {
        this.auth = auth;
        this.context=context;
    }


    public void signIn(String email, String password)
    {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(context.getApplicationContext(), StoreActivity.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "sign in succesfully", Toast.LENGTH_SHORT).show();
                }
               else
                    Toast.makeText(context, "sign in details were incorrect", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context, e.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void register(String email, String password)
    {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                Intent intent = new Intent(context.getApplicationContext(),StoreActivity.class);
                context.startActivity(intent);
                Toast.makeText(context, "registered succesfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context, e.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public FirebaseAuth getAuth(){return auth;}

    public void setAuth(FirebaseAuth auth){this.auth=auth;}
}
