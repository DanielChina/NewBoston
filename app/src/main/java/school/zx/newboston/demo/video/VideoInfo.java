package school.zx.newboston.demo.video;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THink on 2018/3/24.
 */

public class VideoInfo {
    public static String getPath(){
        return Environment.getExternalStorageDirectory()+"/DCIM/Camera/aaa.mp4";
    }
}
