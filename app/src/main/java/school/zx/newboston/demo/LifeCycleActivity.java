package school.zx.newboston.demo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import school.zx.newboston.R;

public class LifeCycleActivity extends AppCompatActivity {
    private static final String TAG_PRINT="Daniel";
    private TextView textView;
    private String logInfo="Pleas focus on the printing info on Android Studio After each clicking";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG_PRINT,"create");
        setContentView(R.layout.activity_life_cycle);
        textView=findViewById(R.id.log_info);
        textView.setText(logInfo);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG_PRINT,"start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG_PRINT,"resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG_PRINT,"pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG_PRINT,"stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG_PRINT,"destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG_PRINT,"restart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG_PRINT,"saveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG_PRINT,"restoreInstanceState");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Log.d(TAG_PRINT,"KEYCODE_BACK");
        } else if(keyCode==KeyEvent.KEYCODE_HOME){
            Log.d(TAG_PRINT,"KEYCODE_HOME");
        } else if(keyCode==KeyEvent.KEYCODE_MENU){
            Log.d(TAG_PRINT,"KEYCODE_MENU");
        }
        return super.onKeyDown(keyCode, event);
    }
}
