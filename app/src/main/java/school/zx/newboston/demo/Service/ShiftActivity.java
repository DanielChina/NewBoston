package school.zx.newboston.demo.Service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;

import school.zx.newboston.R;

public class ShiftActivity extends AppCompatActivity {
    private TextView textView;
    private TimeService timeService;
    private boolean isBound=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView=findViewById(R.id.text_show_time);
        Button button=findViewById(R.id.back_button);
        Button timeButton=findViewById(R.id.bind_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShiftActivity.this,ServiceActivity.class));
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTime();

            }
        });
        //bind a service
        Intent i=new Intent(this, TimeService.class);
        bindService(i,myConnection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection myConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TimeService.MyLocalBinder binder=(TimeService.MyLocalBinder) service;
            timeService=binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };
    void showTime(){
        if(isBound==true)
            textView.setText(timeService.getCurrentTime());
        else
            textView.setText("Current service is disconnected");
    }

}
