package com.example.aayushhindwan.star;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homepage extends AppCompatActivity {
    LinearLayout b1;
    LinearLayout b2;
    LinearLayout b3;
    LinearLayout b4;
    LinearLayout b5;
    LinearLayout b6;
    LinearLayout b7;
    LinearLayout b8;
private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        b1=(LinearLayout) findViewById(R.id.bb1);
        b2=(LinearLayout) findViewById(R.id.bb2);
        b3=(LinearLayout) findViewById(R.id.bb3);
        b4=(LinearLayout) findViewById(R.id.bb4);
        b5=(LinearLayout) findViewById(R.id.bb5);
        b6=(LinearLayout) findViewById(R.id.bb6);
        b7=(LinearLayout) findViewById(R.id.bb7);
        b8=(LinearLayout) findViewById(R.id.bb8);
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(this,"EMAIL OR PASSWORD CANT BE LEFT EMPTY",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(homepage.this,passwordfinal.class);
                startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(homepage.this,stuattten.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(homepage.this,notification.class);
               startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(homepage.this,studrec.class);
                startActivity(intent);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(homepage.this,UPDATES_ACTIVITY.class);
                    startActivity(intent);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(homepage.this,table.class);
                startActivity(intent);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(homepage.this,UPDATES_ACTIVITY.class);
                startActivity(intent);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
