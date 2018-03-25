package school.zx.newboston;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import school.zx.newboston.demo.AnimationActivity;
import school.zx.newboston.demo.CodingUiActivity;
import school.zx.newboston.demo.FragmentTestActivity;
import school.zx.newboston.demo.GestureActivity;
import school.zx.newboston.demo.GridLayoutActivity;
import school.zx.newboston.demo.IntentTest.FirstActivity;
import school.zx.newboston.demo.LifeCycleActivity;
import school.zx.newboston.demo.ListenerTestActivity;
import school.zx.newboston.demo.MasterDetail.ItemListActivity;
import school.zx.newboston.demo.OverflowActivity;
import school.zx.newboston.demo.UIActivity;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class BasicItemActivity extends AppCompatActivity {
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_item);
        position=getIntent().getIntExtra("position",0);
        TextView textView=findViewById(R.id.text_introduction_detail);
        textView.setText(Constant.INTRODUCTION_DETAIL[position]);
        Button button=findViewById(R.id.start_demo);
        if(Constant.SUB_TITLE[position].equals("With Demo"))
            button.setEnabled(true);
        else {
            button.setEnabled(false);
            button.setText(Constant.SUB_TITLE[position]);
        }
        setTitle(Constant.TITLE[position]);
        if(button.isEnabled()){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Object[] activity = Constant.ACTIVITY_NAME;
                    startActivity(new Intent(BasicItemActivity.this, (Class) activity[position]));
                }
            });
        }
    }
}
