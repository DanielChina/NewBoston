package school.zx.newboston.demo.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG="Daniel";
    public MyService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        launchTask();
        // even if service is killed,service will restart
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"my service onDestroy");
    }
    void launchTask(){
        //do not forget start()
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    SystemClock.sleep(3000);
                    Log.i(TAG,"MyService is running");
                }
            }
        }).start();
    }
}
