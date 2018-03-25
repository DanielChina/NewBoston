package school.zx.newboston.demo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import school.zx.newboston.MainActivity;
import school.zx.newboston.R;

public class NotificationActivity extends AppCompatActivity {
    Notification.Builder notification;
    private static final int uniqueID= 18112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        notification=new Notification.Builder(this);
        notification.setAutoCancel(true);
    }
    //create a notification right now
    public void createNotification4(View view){
        setNotification();
        buildIssue(uniqueID+4);
    }
    public void createNotification1(View view){
        setNotification();
        buildIssue(uniqueID+1);
    }
    public void createNotification2(View view){
        setNotification();
        buildIssue(uniqueID+2);
    }
    public void createNotification3(View view){
        setNotification();
        buildIssue(uniqueID+3);
    }
    void setNotification(){
        notification.setSmallIcon(R.drawable.indicator);
        notification.setTicker("Money Rain");
        notification.setWhen(SystemClock.currentThreadTimeMillis());
        notification.setContentTitle("Please Wake Up");
        notification.setContentText("Money rain is a big dream");

        //After clicking the notification,what activity will be activated
        Intent intent=new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,
                intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);
    }
    void buildIssue(int requestId){
        //build and issue this notification
        NotificationManager manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(requestId,notification.build());
    }
}
