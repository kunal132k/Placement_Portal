package com.example.lenovo.placement_portal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button studentpage,companypage;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentpage=findViewById(R.id.studentpagebtn);
        companypage=findViewById(R.id.companypagebtn);
        firebaseAuth = FirebaseAuth.getInstance();
        getSupportActionBar().hide();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null) {
            finish();
            Intent intent = new Intent(MainActivity.this, StudentPage.class);
            startActivity(intent);
        }
    }

    public void studentpage(View view) {
        Intent intent = new Intent(MainActivity.this, StudentLogin.class);
        startActivity(intent);
    }

    public void companypage(View view) {
        Intent intent = new Intent(MainActivity.this, CompanyPage.class);
        startActivity(intent);
    }
}
