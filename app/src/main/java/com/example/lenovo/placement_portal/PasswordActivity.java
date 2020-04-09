package com.example.lenovo.placement_portal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordActivity extends AppCompatActivity {
    EditText emailforgot;
    Button resetbtn;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        emailforgot=findViewById(R.id.emailforgot);
        resetbtn=findViewById(R.id.resetbtn);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void resetbtn(View view) {
        String useremail = emailforgot.getText().toString().trim();

        if(useremail.equals("")) {
            Toast.makeText(PasswordActivity.this,"Please Enter Your Registered Email ID", Toast.LENGTH_SHORT).show();
        }
        else {
            firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(PasswordActivity.this,"Password Reset Email Sent", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(PasswordActivity.this,StudentLogin.class));
                    }
                    else {
                        Toast.makeText(PasswordActivity.this,"Error in sending password reset email", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
