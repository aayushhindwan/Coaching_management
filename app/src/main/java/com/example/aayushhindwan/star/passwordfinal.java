package com.example.aayushhindwan.star;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class passwordfinal extends AppCompatActivity {
    String text3="0";hour gg;String content="0";
    int m,d,i;int e;int k;int a=0;int s;int g;
    TextView txt;
    EditText pass;hour h;hour o;
    EditText id;
    Button submit;
    DatabaseReference databasedata;
    int hours; @Override
    protected void onStart()
    {
        super.onStart();


        databasedata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dayyy : dataSnapshot.getChildren())
                {
                    String hour = String.valueOf(dayyy.getValue());
                    hours = Integer.parseInt(hour);
                }
                Log.e("hours getted", ""+hours );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordfinal);
        databasedata=FirebaseDatabase.getInstance().getReference("time:hour");
        txt =(TextView) findViewById(R.id.tx);
        pass =(EditText) findViewById(R.id.editText);
        final Spinner dropdown1 = findViewById(R.id.spinner1);
        final Spinner  dropdown2= findViewById(R.id.spinner2);
        submit=(Button)findViewById(R.id.button);
        id =(EditText) findViewById(R.id.plain_text_input);
        List<String> categories = new ArrayList<String>();
        categories.add("1");
        categories.add("2");
        categories.add("3");
        categories.add("4");
        categories.add("5");
        categories.add("6");
        categories.add("7");
        categories.add("8");
        categories.add("9");
        categories.add("10");
        categories.add("11");
        categories.add("12");
        List<String> categori = new ArrayList<String>();
        categori.add("1");
        categori.add("2");
        categori.add("3");
        categori.add("4");
        categori.add("5");
        categori.add("6");
        categori.add("7");
        categori.add("8");
        categori.add("9");
        categori.add("10");
        categori.add("11");
        categori.add("12");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(dataAdapter);
        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text1 = (String)parent.getItemAtPosition(position).toString();

                m=Integer.valueOf(text1, 10);
                txt.setText(String.valueOf(m));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> dataAdapterr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categori);
        dataAdapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown2.setAdapter(dataAdapter);
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text2 = (String)parent.getItemAtPosition(position).toString();

                d=Integer.valueOf(text2, 10);
                txt.setText(String.valueOf(d));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


      //  final String text3 = (String)id.getText().toString();
        //  i= Integer.valueOf(text3,10);
     //   final String content = pass.getText().toString();
        //   k=Integer.valueOf(content,10);
        //    txt.setText(content);

     //   txt.setText(String.valueOf(e));
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text3 = (String)id.getText().toString();
                if(text3!=null)
                    i= Integer.valueOf(text3,10);
                content = pass.getText().toString();
                if(content!=null)
                    k=Integer.valueOf(content,10);
                e=m*12+d*4+i*20;
                if(e==k)
                {
                    txt.setText("successful");
                   // txt.setText(String.valueOf(m));
                    a=hours+1;

                    h=new hour(a);
                    databasedata.setValue(h);

                }
                else
                    txt.setText("wrong passcode");

            }
        });


    }


}


