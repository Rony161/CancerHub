package com.example.joy.cancerhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.joy.cancerhub.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class LungCancer extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseReference DBRef;
    FirebaseFirestore db;

    private Spinner spinner;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lung_cancer);

        Toolbar toolbar = findViewById(R.id.toolbarLungCancer);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), cancer_types.class));
                finish();
            }
        });

        webView = findViewById(R.id.webViewLung);
        webView.getSettings().setJavaScriptEnabled(true);

        //textView.setMovementMethod(new ScrollingMovementMethod());
        spinner = findViewById(R.id.spinnerLungCancer);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this,          // Create an ArrayAdapter using the string array and a default spinner layout
                R.array.cancer_properties, android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);             // Specify the layout to use when the list of choices appears
        spinner.setAdapter(adapt);
        DBRef = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        switch (pos) {
            case 0:
                DBRef.child("liver_cancer/overview").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String liver = dataSnapshot.getValue(String.class);
                       // textView.setText(Html.fromHtml(liver));
                        webView.loadData(liver, "text/html", "UTF-8");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
                break;
            case 1:
                DBRef.child("liver_cancer/medical_illustrations").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String liver = dataSnapshot.getValue(String.class);
                        webView.loadData(liver, "text/html", "UTF-8");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
                break;
            case 2:
                DBRef.child("liver_cancer/risk_factors").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String liver = dataSnapshot.getValue(String.class);
                        webView.loadData(liver, "text/html", "UTF-8");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
                break;
            case 3:
                DBRef.child("liver_cancer/signs_symptoms").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String liver = dataSnapshot.getValue(String.class);
                        webView.loadData(liver, "text/html", "UTF-8");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
                break;
            case 4:
                DBRef.child("liver_cancer/diagnosis").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String liver = dataSnapshot.getValue(String.class);
                        webView.loadData(liver, "text/html", "UTF-8");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_settings1:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


}
