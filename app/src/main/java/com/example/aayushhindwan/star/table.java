package com.example.aayushhindwan.star;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class table extends AppCompatActivity {
    dayyy d1;
    dayyy d2;
    dayyy d3;
    dayyy d4;
    dayyy d5;
    EditText t;
    Button btn;
    String teacher;
    DatabaseReference databasedata;

    EditText r1c1;EditText r1c2;
    EditText r1c3;EditText r1c4;

    EditText r2c1;EditText r2c2;
    EditText r2c3;EditText r2c4;

    EditText r3c1;EditText r3c2;
    EditText r3c3;EditText r3c4;

    EditText r4c1;EditText r4c2;
    EditText r4c3;EditText r4c4;

    EditText r5c1;EditText r5c2;
    EditText r5c3;EditText r5c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        databasedata=FirebaseDatabase.getInstance().getReference("Time-Table");
r1c1=(EditText)findViewById(R.id.textView1);
        r1c2=(EditText)findViewById(R.id.textView2);
        r1c3=(EditText)findViewById(R.id.textView3);
        r1c4=(EditText)findViewById(R.id.textView4);

        r2c1=(EditText)findViewById(R.id.textView21);
        r2c2=(EditText)findViewById(R.id.textView22);
        r2c3=(EditText)findViewById(R.id.textView23);
        r2c4=(EditText)findViewById(R.id.textView24);

        r3c1=(EditText)findViewById(R.id.textView31);
        r3c2=(EditText)findViewById(R.id.textView32);
        r3c3=(EditText)findViewById(R.id.textView33);
        r3c4=(EditText)findViewById(R.id.textView34);


        r4c1=(EditText)findViewById(R.id.textView41);
        r4c2=(EditText)findViewById(R.id.textView42);
        r4c3=(EditText)findViewById(R.id.textView43);
        r4c4=(EditText)findViewById(R.id.textView44);

        r5c1=(EditText)findViewById(R.id.textView51);
        r5c2=(EditText)findViewById(R.id.textView52);
        r5c3=(EditText)findViewById(R.id.textView53);
        r5c4=(EditText)findViewById(R.id.textView54);

        btn=(Button)findViewById(R.id.button2);
        t=(EditText)findViewById(R.id.ttt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher=t.getText().toString();
                String s11=r1c1.getText().toString();;
                String s12=r1c2.getText().toString();
                String s13=r1c3.getText().toString();
                String s14=r1c4.getText().toString();

                String s21=r2c1.getText().toString();
                String s22=r2c2.getText().toString();
                String s23=r2c3.getText().toString();
                String s24=r2c4.getText().toString();

                String s31=r3c1.getText().toString();
                String s32=r3c2.getText().toString();
                String s33=r3c3.getText().toString();
                String s34=r3c4.getText().toString();

                String s41=r4c1.getText().toString();
                String s42=r4c2.getText().toString();
                String s43=r4c3.getText().toString();
                String s44=r4c4.getText().toString();

                String s51=r5c1.getText().toString();
                String s52=r5c2.getText().toString();
                String s53=r5c3.getText().toString();
                String s54=r5c4.getText().toString();
                d1=new dayyy(s11,s12,s13,s14);
                d2=new dayyy(s21,s22,s23,s24);
                d3=new dayyy(s31,s32,s33,s34);
                d4=new dayyy(s41,s42,s43,s44);
                d5=new dayyy(s51,s52,s53,s54);

                //databasedata=FirebaseDatabase.getInstance().getReference(teacher);
                databasedata.child(teacher).child("monday").setValue(d1);
                databasedata.child(teacher).child("tuesday").setValue(d2);
                databasedata.child(teacher).child("wednesday").setValue(d3);
                databasedata.child(teacher).child("thrusday").setValue(d4);
                databasedata.child(teacher).child("friday").setValue(d5);
            }
        });

    }
}
