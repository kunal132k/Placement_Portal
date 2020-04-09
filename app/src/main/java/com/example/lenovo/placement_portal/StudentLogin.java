package com.example.lenovo.placement_portal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StudentLogin extends AppCompatActivity {
    EditText lemail,lpassword;
    Button loginbutton;
    TextView textt,forgetpass;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        lemail = findViewById(R.id.emaillogin);
        lpassword = findViewById(R.id.passwordlogin);
        loginbutton = findViewById(R.id.loginbtn);
        textt = findViewById(R.id.texxt);
        forgetpass=findViewById(R.id.forgetpass);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

    }

    public void loginbtn(View view) {
        validate(lemail.getText().toString(),lpassword.getText().toString());
    }

    private void validate(String email, String password) {

        progressDialog.setMessage("page is loading.....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Intent intent = new Intent(StudentLogin.this, StudentPage.class);
                    startActivity(intent);
                    Toast.makeText(StudentLogin.this,"Login successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(StudentLogin.this,"Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void texxt(View view) {
        Intent intent = new Intent(StudentLogin.this, StudentSignup.class);
        startActivity(intent);
    }

    public void forget(View view) {
        Intent intent = new Intent(StudentLogin.this, PasswordActivity.class);
        startActivity(intent);
    }
}
