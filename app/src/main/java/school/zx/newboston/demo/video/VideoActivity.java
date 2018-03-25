package school.zx.newboston.demo.video;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.List;

import school.zx.newboston.Constant;
import school.zx.newboston.R;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView=findViewById(R.id.video_view);
        videoView.setVideoPath(Constant.VIDEO_URL);
        //set Player controller
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }
}
