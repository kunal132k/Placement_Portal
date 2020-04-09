package com.example.lenovo.placement_portal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;



public class StudentPage extends AppCompatActivity {

FirebaseAuth firebaseAuth;
FirebaseDatabase firebaseDatabase;
   FirebaseFirestore firebaseFirestore;
RecyclerView recyclerView;
RecyclerViewAdapter recyclerViewAdapter;
RecyclerView.LayoutManager layoutManager;
public  List<Model> mm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);
        mm=new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        recyclerView=findViewById(R.id.recycle111);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerViewAdapter=new RecyclerViewAdapter(mm);
        recyclerView.setAdapter(recyclerViewAdapter);

       firebaseFirestore=FirebaseFirestore.getInstance();


       /* firebaseFirestore.collection("cardview").document("n5vLsRZZUbFbfnPhBht8").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                String card11=task.getResult().getString("card1");
                String card12=task.getResult().getString("card2");
                Toast.makeText(StudentPage.this, ""+card11, Toast.LENGTH_SHORT).show();
                recyclerViewAdapter=new RecyclerViewAdapter(card11,card12);
                recyclerView.setAdapter(recyclerViewAdapter);


            }
        });*/

        Query firstquery = firebaseFirestore.collection("cardview").orderBy("timestamp", Query.Direction.DESCENDING);
        firstquery.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                    if (doc.getType() == DocumentChange.Type.ADDED) {
                                              Model mm2 = doc.getDocument().toObject(Model.class);
                        Toast.makeText(StudentPage.this, ""+doc.getDocument().getString("card1"), Toast.LENGTH_SHORT).show();
                       mm.add(mm2);
                      recyclerViewAdapter.notifyDataSetChanged();

                    }
                }
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.logoutmenu: {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(StudentPage.this,StudentLogin.class));
            }
            case R.id.profilemenu: {
                startActivity(new Intent(StudentPage.this,ProfileActivity.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
