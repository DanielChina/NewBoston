package school.zx.newboston.demo.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeService extends Service {
    private final IBinder myBinder=new MyLocalBinder();
    public TimeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
    public class MyLocalBinder extends Binder {
        TimeService getService(){
            return TimeService.this;
        }
    }
    public String getCurrentTime(){
        SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        return (df.format(new Date()));
    }
}
