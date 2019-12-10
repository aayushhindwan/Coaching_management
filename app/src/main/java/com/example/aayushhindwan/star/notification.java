package com.example.aayushhindwan.star;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class notification extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        textView = (TextView) findViewById(R.id.notifi);
        String id = FirebaseInstanceId.getInstance().getToken();
        Log.d("mylog", "Token: " + id);
        Intent intent = getIntent();
        if(intent.hasExtra("message")){
            textView.setText(intent.getStringExtra("message"));
        }
    }
}
