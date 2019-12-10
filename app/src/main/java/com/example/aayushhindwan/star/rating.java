package com.example.aayushhindwan.star;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class rating extends AppCompatActivity {
    RatingBar mBar;

    int noofstars;DatabaseReference databasedata;
    float getrating;
    TextView tView;
    Button btn;
    dataa dat;
    EditText sna;
    EditText tna;
    EditText rna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);


rna=(EditText)findViewById(R.id.rln);tna=(EditText)findViewById(R.id.teach);
        sna=(EditText)findViewById(R.id.sname);
            btn=(Button) findViewById(R.id.button);
            tView=(TextView) findViewById(R.id.tt);
            databasedata=FirebaseDatabase.getInstance().getReference("Rating");
            mBar= (RatingBar) findViewById(R.id.ratingBar);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    noofstars = mBar.getNumStars();
                    getrating = mBar.getRating();
                    String r1=rna.getText().toString();
                    String st1=sna.getText().toString();
                    String tn1=tna.getText().toString();
                    tView.setText("Rating: "+getrating+"/"+noofstars);
                    dat=new dataa(getrating,r1,tn1,st1);

                    databasedata.child(tn1).setValue(dat);
                }
            });


        }
    }

