package school.zx.newboston;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView=findViewById(R.id.my_list_view);
        SimpleAdapter adapter=new SimpleAdapter(this,getData(),
                R.layout.item_layout,
                new String[]{"Pic","BigText","SmallText"},
                new int[]{R.id.image_in_item,R.id.text_in_item,R.id.small_text_in_item});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,BasicItemActivity.class);
                intent.putExtra("position",position);
                    startActivity(intent);
            }
        });
    }
    public List<Map<String,Object>> getData(){
        Object[] pic=Constant.IMG_NAME;
        String[] title=Constant.TITLE;
        String[] subTitle=Constant.SUB_TITLE;
        int num=title.length;
        List<Map<String,Object>> listData=new ArrayList<>();
        for(int i=0;i<num;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("Pic", pic[i]);
            map.put("BigText", title[i]);
            map.put("SmallText", subTitle[i]);
            listData.add(map);
        }
        return listData;
    }
}
