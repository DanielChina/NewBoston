package school.zx.newboston.demo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import school.zx.newboston.R;
import school.zx.newboston.demo.FragmentTestActivity;

/**
 * Created by THink on 2018/3/8.
 */

public class BottomFragment extends Fragment implements CheckBox.OnCheckedChangeListener {
    private CheckBox checkBox0,checkBox1;
    private FragmentTestActivity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.bottom_fragment_layout,container,false);
        checkBox0=view.findViewById(R.id.checkBox0);
        checkBox1=view.findViewById(R.id.checkBox1);
        activity=(FragmentTestActivity) BottomFragment.this.getActivity();
        checkBox0.setOnCheckedChangeListener(this);
        checkBox1.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String top="",bottom="";
        if(buttonView==checkBox0){
            if(isChecked)
                top=buttonView.getText().toString();
            if(checkBox1.isChecked())
                bottom=checkBox1.getText().toString();
        } else if(buttonView==checkBox1){
            if(isChecked)
                bottom=buttonView.getText().toString();
            if(checkBox0.isChecked())
                top=checkBox0.getText().toString();
        }
        activity.setDataChange(top,bottom);

    }

    //create a interface for the interaction between fragment and activity
    public interface DataChangeListener{
        void setDataChange(String top,String bottom);
    }


}