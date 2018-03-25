package school.zx.newboston.demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import school.zx.newboston.R;

import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class CodingUiActivity extends AppCompatActivity {
    private boolean addFlag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //new a relative layout and a button
        final RelativeLayout relativeLayout=new RelativeLayout(this);
        final Button button=new Button(this);
        //set background color for the layout
        relativeLayout.setBackgroundColor(Color.GREEN);
        //set background color and text
        button.setBackgroundColor(Color.RED);
        button.setText("Add EditView");
        //set button size and position
        RelativeLayout.LayoutParams buttonParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        //add this button to layout,do not forget the param of buttonParams
        relativeLayout.addView(button,buttonParams);
        setContentView(relativeLayout);
        //detect the button event
        button.setOnClickListener(new View.OnClickListener() {
            EditText editText=null;
            @Override
            public void onClick(View v) {
                //based on the flag, whether editView has been created can be told.
                if(!addFlag){
                    addFlag = true;
                    button.setText("Delete EditView");
                    editText=new EditText(CodingUiActivity.this);
                    editText.setHint("Add Successfully");
                    editText.setBackgroundColor(Color.RED);
                    RelativeLayout.LayoutParams editTextParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    //set editText position
                    editTextParams.addRule(RelativeLayout.ABOVE,button.getId());
                    editTextParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    editTextParams.setMargins(0,500,0,50);
                    //set the width of  editText
                    editText.setWidth(dpToPx(200));
                    relativeLayout.addView(editText,editTextParams);
                } else {
                    addFlag = false;
                    button.setText("Add EditView");
                    if(editText!=null)
                        relativeLayout.removeView(editText);
                }
            }
        });
    }
    //convert dp value to px value
    private int dpToPx(int dpVal){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal,getResources().getDisplayMetrics());
    }
    //convert sp value to px value
    private int spToPx(int spVal){
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,spVal,
                getResources().getDisplayMetrics());
    }
}
