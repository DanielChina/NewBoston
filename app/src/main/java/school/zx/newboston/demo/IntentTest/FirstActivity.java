package school.zx.newboston.demo.IntentTest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import school.zx.newboston.Constant;
import school.zx.newboston.R;

public class FirstActivity extends AppCompatActivity {
    EditText editText;
    Intent intent;
    private MessageReceiver mMessageReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button=findViewById(R.id.confirm_button);
        editText=findViewById(R.id.edit_info);
        intent=new Intent(FirstActivity.this, SecondActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make sure toString()
                String data=editText.getText().toString();
                intent.putExtra("editInfo",data);
                startActivity(intent);
            }
        });
   //     registerMessageReceiver();
    }
    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constant.ACTION_INTENT_RECEIVER);
        registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            if (intent.getAction().equals(Constant.ACTION_INTENT_RECEIVER)) {
                String data=intent.getStringExtra("editInfo");
                Toast.makeText(context,data,Toast.LENGTH_LONG).show();
            }
        }

    }
}
