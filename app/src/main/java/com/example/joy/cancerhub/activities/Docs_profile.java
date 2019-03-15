package com.example.joy.cancerhub.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.joy.cancerhub.R;
import com.example.joy.cancerhub.models.Doctor;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Docs_profile extends AppCompatActivity {

    EditText name1, description, location;
    Button send;
    ImageView imageV;

    private List<Doctor> profile_List = new ArrayList<>();
    FirebaseDatabase database;
    DatabaseReference ref;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docs_profile);

        Toolbar toolbar = findViewById(R.id.toolbarDocsP);
        toolbar.setTitle("Doctors Profile");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Information.class));
                finish();

            }
        });

        name1 = findViewById(R.id.editTextName);
        description = findViewById(R.id.editTextDescrip);
        location = findViewById(R.id.editTextLocation);
        send = findViewById(R.id.AddDocsProfile);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("user_prognosis");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String name = name.getText().toString();

                //calling the method addArtist()  
                //the method is defined below  
                //this method is actually performing the write operation  
               // addDoctor();
            }
        });
    }

//    private void addDoctor() {
//
//        String docter = name1.getText().toString().trim();
//        String descrp = description.getText().toString().trim();
//        String locat = location.getText().toString().trim();
//
//
//        //checking if the value is provided
//        if (!TextUtils.isEmpty(docter)) {
//
//            //getting a unique id using push().getKey() method
//            //it will create a unique id and we will use it as the Primary Key for our Artist
//            String id = ref.push().getKey();
//            //creat new doctor object
//            Doctor doctor = new Doctor(docter, descrp, locat,picture);
//            //Saving the Artist
//            ref.child(id).setValue(doctor);
//
//            name1.setText("");
//            description.setText("");
//            location.setText("");
//            //displaying a success toast
//            Toast.makeText(this, "Doctor added", Toast.LENGTH_LONG).show();
//        } else {
//            //if the value is not given displaying a toast
//            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
//
//
//        }
//    }
}