package school.zx.newboston.demo.IntentTest;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.drm.DrmStore;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import school.zx.newboston.Constant;
import school.zx.newboston.R;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        textView=findViewById(R.id.first_activity_info);
        data=intent.getStringExtra("editInfo");
        textView.setText(data);
        Button button=findViewById(R.id.broadcast_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent broadcastIntent=new Intent();
                broadcastIntent.putExtra("editInfo",data);
                broadcastIntent.setAction(Constant.ACTION_INTENT_RECEIVER);
                sendBroadcast(broadcastIntent);
            }
        });

    }
}
