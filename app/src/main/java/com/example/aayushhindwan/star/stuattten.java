package com.example.aayushhindwan.star;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class stuattten extends AppCompatActivity implements View.OnClickListener {
    private int s;
    ArrayList<String> data ;
    ArrayAdapter<String> adapt;
    Button pr;
    DatabaseReference databasedata;
    Button ab;
    TextView txt;att abb;
    ListView list;
    String cl;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuattten);
        databasedata=FirebaseDatabase.getInstance().getReference("StudentAttendence");
        txt = (TextView) findViewById(R.id.tx);
        pr = (Button) findViewById(R.id.present);
        ab = (Button) findViewById(R.id.absent);
        list =(ListView) findViewById(R.id.listt);
        et=(EditText) findViewById(R.id.cls);
        String items=new String();
        data = new ArrayList<>(Arrays.asList(items));
        adapt=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,data);
        list.setAdapter(adapt);
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s++;

                txt.setText(String.valueOf(s));
                data.add(String.valueOf(s));
                adapt.notifyDataSetChanged();
                abb=new att(s);
                cl=et.getText().toString();
                databasedata.child(cl).setValue(abb);
            }
        });
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s++;
                txt.setText(String.valueOf(s));



            }
        });

    }


    @Override
    public void onClick(View v) {

    }
    }

