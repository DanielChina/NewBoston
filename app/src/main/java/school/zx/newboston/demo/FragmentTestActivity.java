package school.zx.newboston.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import school.zx.newboston.R;
import school.zx.newboston.demo.fragment.BottomFragment;
import school.zx.newboston.demo.fragment.TopFragment;

public class FragmentTestActivity extends AppCompatActivity implements BottomFragment.DataChangeListener {
    TopFragment topFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        topFragment=(TopFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_top);
    }
    //override the method of setDataChange.
    @Override
    public void setDataChange(String top,String bottom) {
        //activity can operate the fragment directly
        ((TextView)topFragment.getView().findViewById(R.id.top_text)).setText(top);
        ((TextView)topFragment.getView().findViewById(R.id.bottom_text)).setText(bottom);
    }
}
