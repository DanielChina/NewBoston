package school.zx.newboston.demo.Sqlite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import school.zx.newboston.R;

public class SqliteActivity extends AppCompatActivity {
    EditText myInput;
    TextView tableShown;
    DbHandle dbHandle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myInput=findViewById(R.id.edit_area);
        tableShown=findViewById(R.id.table_shown);
        dbHandle=new DbHandle(this,null,null,1);
        printDatabase();
    }
    void printDatabase(){
        String dbString=dbHandle.databaseToString();
        tableShown.setText(dbString);
        myInput.setText("");
    }
    public void addHandle(View view){
        String data;
        data=myInput.getText().toString();
        Products product=new Products(data);
        dbHandle.addProduct(product);
        printDatabase();
    }
    public void deleteHandle(View view){
        String inputText=myInput.getText().toString();
        dbHandle.deleteProduct(inputText);
        printDatabase();
    }
}
