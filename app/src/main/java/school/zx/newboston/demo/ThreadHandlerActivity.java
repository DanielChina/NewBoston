package school.zx.newboston.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import school.zx.newboston.R;

public class ThreadHandlerActivity extends AppCompatActivity{
    Handler handler;
    private TextView leftTime,headline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_handler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        leftTime=findViewById(R.id.left_seconds);
        headline=findViewById(R.id.headline_time);
        //this handler is used to connect between ui and thread
        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if((int)msg.obj==0){
                    leftTime.setText("");
                    headline.setText("You Are Really Patient");
                } else {
                    leftTime.setText((int)msg.obj+"s");
                }
                return false;
            }
        });
        launchTask();
    }
    void launchTask(){
        //do not forget start()
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++) {
                    SystemClock.sleep(1000);
                    //need a new msg each time
                    Message msg=new Message();
                    msg.obj=10-i;
                    handler.sendMessage(msg);
                }
            }
        }).start();
    }
}
