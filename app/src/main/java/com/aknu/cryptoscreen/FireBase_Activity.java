package com.aknu.cryptoscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class FireBase_Activity extends AppCompatActivity {
    //Instantiating variables necessary
    private EditText mEmailField;
    private EditText mPasswordField;
    private Button mLoginBtn;
    //Here we instantiate the necessary Authorization variables from Firebase. We have an Auth varia
    //ble, and a listener for the auth
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base_);

        mAuth = FirebaseAuth.getInstance();

        if(!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }

        //Here, we are creating the email and password fields
        mEmailField = (EditText) findViewById(R.id.emailField);
        mPasswordField = (EditText) findViewById(R.id.passwordField);

        mLoginBtn = (Button) findViewById(R.id.loginButton);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });

        //
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(FireBase_Activity.this, AccountActivity.class));
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthStateListener);
    }

    private void startSignIn() {
        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();

        //An error toast will pop up letting the user know that the login isn't successful. We
        //have 2 types of error toasts.
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(FireBase_Activity.this, "Sign In Problem", Toast.LENGTH_LONG).show();
        }

        else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()) {
                        Toast.makeText(FireBase_Activity.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    }
}