package school.zx.newboston.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import school.zx.newboston.R;

public class ListenerTestActivity extends AppCompatActivity {
    private Button button0,button1;
    private Button btClear;
    private TextView textView0,textView1;
    private int c0ShortClick,c0LongClick,c1ShortClick,c1LongClick;
    private String iniString0="Counter0(Return False):\n";
    private String iniString1="Counter1(Return True):\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener_test);
        button0=findViewById(R.id.listener_first);
        button1=findViewById(R.id.listener_second);
        btClear=findViewById(R.id.reset_button);
        textView0=findViewById(R.id.text_first_button);
        textView1=findViewById(R.id.text_second_button);
        resetCount();
        //set detect
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c0ShortClick++;
                textView0.setText(iniString0+"short:"+c0ShortClick+",long:"+c0LongClick);
            }
        });
        button0.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                c0LongClick++;
                textView0.setText(iniString0+"short:"+c0ShortClick+",long:"+c0LongClick);
                return false;
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1ShortClick++;
                textView1.setText(iniString1+"short:"+c1ShortClick+",long:"+c1LongClick);
            }
        });
        button1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                c1LongClick++;
                textView1.setText(iniString1+"short:"+c1ShortClick+",long:"+c1LongClick);
                return true;
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCount();
            }
        });
    }
    void resetCount(){
        c0ShortClick=0;
        c0LongClick=0;
        c1ShortClick=0;
        c1LongClick=0;
        textView0.setText(iniString0+"short:0"+",long:0");
        textView1.setText(iniString1+"short:0"+",long:0");
    }
}
