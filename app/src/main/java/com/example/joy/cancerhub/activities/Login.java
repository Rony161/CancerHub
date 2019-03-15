package com.example.joy.cancerhub.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.joy.cancerhub.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button btn_SignIn, btn_SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_SignIn = findViewById(R.id.butt_login);
        btn_SignUp = findViewById(R.id.butt_login2);

        btn_SignIn.setOnClickListener(this);
        btn_SignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==btn_SignIn){
            startActivity(new Intent(this, SignIn.class));
            finish();

        }
        if (view == btn_SignUp){
            startActivity(new Intent(this, SignUp.class));
            finish();

        }
    }
}
