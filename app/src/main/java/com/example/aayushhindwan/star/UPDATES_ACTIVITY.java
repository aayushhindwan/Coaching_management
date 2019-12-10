package com.example.aayushhindwan.star;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UPDATES_ACTIVITY extends AppCompatActivity {
EditText sg;
Button b;
String strr;
String idd;
    DatabaseReference databasedata;
sugg ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates__activity);
       sg= (EditText)findViewById(R.id.edt);
       b=(Button)findViewById(R.id.btt);
        databasedata=FirebaseDatabase.getInstance().getReference("Suggestions");
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               strr=sg.getText().toString();
               ss=new sugg(strr);
               idd =databasedata.push().getKey();
               databasedata.child(idd).setValue(ss);
           }
       });
    }
}
