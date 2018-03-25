package school.zx.newboston.demo.sharePreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import school.zx.newboston.R;

public class SharedPreferenceActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private TextView reminderText;
    LogHelper logHelper=new LogHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        reminderText=findViewById(R.id.reminder_text);
        //ini user info
        getData();
    }
    public void storeData(View view){
        String nm=username.getText().toString();
        String pw=password.getText().toString();
        //store the username and password in share preference
        logHelper.setLastLogin(this,nm,pw);
        if(nm.equals("") && pw.equals(""))
            emptyShow();
        else normalShow(nm,pw);
    }
    void getData(){
        String nm=logHelper.getLastLoginName(this);
        String pw=logHelper.getLastLoginPassword(this);
        if(nm.equals("") && pw.equals(""))
            emptyShow();
        else normalShow(nm,pw);
    }
    public void getStoredData(View view){
        getData();
    }
    public void clearStoredData(View view){
        logHelper.clearLastLogin(this);
        emptyShow();
    }
    public void emptyShow(){
        reminderText.setText("Empty User Info");
    }
    public void normalShow(String nm, String pw){
        reminderText.setText("username:"+nm+"\n"+"password:"+pw);
    }
}
