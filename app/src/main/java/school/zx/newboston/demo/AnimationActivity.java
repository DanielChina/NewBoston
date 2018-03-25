package school.zx.newboston.demo;

import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;

import school.zx.newboston.R;

public class AnimationActivity extends AppCompatActivity {
    private Button button;
    private ViewGroup viewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        button=findViewById(R.id.animation_button);
        viewGroup=findViewById(R.id.animation_layout);
        viewGroup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moveButton();
                return true;
            }
        });
    }
    void moveButton(){
        TransitionManager.beginDelayedTransition(viewGroup);

        // change the position of the button, make sure ALIGN_PARENT_BOTTOM not ALIGN_BOTTOM
        RelativeLayout.LayoutParams newPositionParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        newPositionParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        newPositionParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        button.setLayoutParams(newPositionParams);
        // change the size of the button
        ViewGroup.LayoutParams newSizeParams=button.getLayoutParams();
        newSizeParams.width=400;
        newSizeParams.height=200;
        button.setText("big");
        button.setLayoutParams(newSizeParams);
    }
}
