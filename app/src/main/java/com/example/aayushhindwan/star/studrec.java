package com.example.aayushhindwan.star;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class studrec extends AppCompatActivity {
    EditText name;EditText rollno;EditText clas; reco rr;
    DatabaseReference databasedata;


    Button submit;
    ListView list;
    ArrayList<String> data ;
    ArrayAdapter<String> adapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studrec);
        submit=findViewById(R.id.button);
        list =(ListView) findViewById(R.id.listt);
        name=findViewById(R.id.nam);
        clas=findViewById(R.id.cla);
        rollno=findViewById(R.id.roll);

        String items=new String();
        data = new ArrayList<String>(Arrays.asList(items));
        adapt=new ArrayAdapter<String>(this,R.layout.list_item1,R.id.txtitem,data);
        list.setAdapter(adapt);
        databasedata=FirebaseDatabase.getInstance().getReference("record");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data.add(String.valueOf(name.getText().toString()));
                data.add(String.valueOf(rollno.getText().toString()));
                data.add(String.valueOf(clas.getText().toString()));
                rr=new reco(name.getText().toString(),rollno.getText().toString(),clas.getText().toString());
                String idd =databasedata.push().getKey();
                Log.d("idd",idd);
                databasedata.child(idd).setValue(rr);
                adapt.notifyDataSetChanged();
            }
        });
    }
    }

