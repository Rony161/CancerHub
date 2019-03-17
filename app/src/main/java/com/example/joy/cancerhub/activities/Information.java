package com.example.joy.cancerhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.joy.cancerhub.R;

public class Information extends AppCompatActivity implements View.OnClickListener {

    TextView textViewTOC, textCope, textViewNav, textViewAU, textViewCU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Toolbar toolbar = findViewById(R.id.toolbarInformation);
        toolbar.setTitle("Information");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Profile.class));
                finish();
            }
        });


        textViewTOC = findViewById(R.id.textViewTOC);
        textViewTOC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == textViewTOC) {
            startActivity(new Intent(Information.this, LungCancer.class));
            finish();
        }
    }

}
