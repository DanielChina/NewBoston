package school.zx.newboston.demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import school.zx.newboston.R;

public class OverflowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overflow);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout mainScreen=findViewById(R.id.main_screen_overflow);
        int id=item.getItemId();
        switch (id){
            case (R.id.setting_red):
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                mainScreen.setBackgroundColor(Color.RED);
                break;
            case (R.id.setting_green):
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                mainScreen.setBackgroundColor(Color.GREEN);
                break;
            case (R.id.setting_yellow):
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                mainScreen.setBackgroundColor(Color.YELLOW);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
