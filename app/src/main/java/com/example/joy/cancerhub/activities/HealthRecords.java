package com.example.joy.cancerhub.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.joy.cancerhub.R;
import com.example.joy.cancerhub.adapters.RecordsAdapter;
import com.example.joy.cancerhub.models.Prognosis;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HealthRecords extends AppCompatActivity {

    FirebaseUser fuser;
    FirebaseFirestore dbFirestore;

    TextView dateOfRecord, txtRiskRecord, txtCancerRecord, txtRecommendRecord, txtRecommendRecord2;


    private List<Prognosis> addRecord;
    private RecyclerView recyclerR;
    private RecordsAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_records);

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        dbFirestore = FirebaseFirestore.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbarH_Records);
        toolbar.setTitle("Risk Assessment Records");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
                finish();

            }
        });


        dateOfRecord = findViewById(R.id.dateOfRecord);
        txtRiskRecord = findViewById(R.id.txtRiskRecord);
        txtCancerRecord = findViewById(R.id.txtCancerRecord);
        txtRecommendRecord = findViewById(R.id.txtRecommendRecord);
        txtRecommendRecord2 = findViewById(R.id.txtRecommendRecord2);

        recyclerR = findViewById(R.id.recyclerViewR);
        recyclerR.setLayoutManager(new LinearLayoutManager(HealthRecords.this));
        recyclerR.setItemAnimator(new DefaultItemAnimator());
        addRecord = new ArrayList<>();
        rAdapter = new RecordsAdapter(getApplicationContext(), addRecord);
        recyclerR.setAdapter(rAdapter);

        viewHealthRecords();


    }

    private void viewHealthRecords() {

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading diseases");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        dbFirestore.collection("user_prognosis")
                .whereEqualTo("user", fuser.getUid())
                .orderBy("timestamp", Query.Direction.ASCENDING)
                .get()
                .addOnCompleteListener(HealthRecords.this, new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {


                                //addRecord.add(document.toObject(Prognosis.class));
                                Prognosis record = document.toObject(Prognosis.class);

                                addRecord.add(record);
                                rAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }
}
