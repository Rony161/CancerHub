package com.example.joy.cancerhub.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.joy.cancerhub.R;
import com.example.joy.cancerhub.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    FirebaseAuth mAuth;
    DatabaseReference dbRef;
    FirebaseUser fuser;

    private ProgressDialog progressDialog;
    public TextView textWelcomeMessage, emailprofile, profilefull;
    GridLayout gridLayout;
    CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mAuth = FirebaseAuth.getInstance();

        fuser = FirebaseAuth.getInstance().getCurrentUser();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        progressDialog = new ProgressDialog(this);

        gridLayout = findViewById(R.id.mainGrid);
        cardView1 = findViewById(R.id.card_view1);
        cardView2 = findViewById(R.id.card_view2);
        cardView3 = findViewById(R.id.card_view3);
        cardView4 = findViewById(R.id.card_view4);
        cardView5 = findViewById(R.id.card_view5);
        cardView6 = findViewById(R.id.card_view6);
        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
        cardView5.setOnClickListener(this);
        cardView6.setOnClickListener(this);

        textWelcomeMessage = findViewById(R.id.textWelcomeMessage);

        View navigationHeaderLayout = navigationView.getHeaderView(0);
        emailprofile = navigationHeaderLayout.findViewById(R.id.emailprofile);
        profilefull = navigationHeaderLayout.findViewById(R.id.profilefull);

    }

    @Override
    protected void onStart() {

        super.onStart();
        dbRef = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                textWelcomeMessage.setText("Welcome\t" + user.getUsername() + ",");
                profilefull.setText(user.getFullname());
                emailprofile.setText(user.getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Health) {
            startActivity(new Intent(this, MyHealth.class));

        } else if (id == R.id.nav_Infor) {
            startActivity(new Intent(this, Basic_Info.class));
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_logout) {

            progressDialog.setMessage("Logging out...");
            progressDialog.show();
            Runnable progressRunnable = new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                    mAuth.signOut();
                    startActivity(new Intent(getApplicationContext(), SignIn.class));
                }
            };
            Handler pdCanceller = new Handler();
            pdCanceller.postDelayed(progressRunnable, 3000);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == cardView1) {
            startActivity(new Intent(this, Basic_Info.class));
        }
        if (view == cardView3) {
            //finish();
            startActivity(new Intent(this, FindDoctor.class));
        }
        if (view == cardView4) {
            //finish();
            startActivity(new Intent(this, HealthRecords.class));
        }
        if (view == cardView5) {
            //finish();
            startActivity(new Intent(this, NewsMain.class));
        }
        if (view == cardView6) {
            //finish();
            startActivity(new Intent(this, Information.class));
        }

    }
}
