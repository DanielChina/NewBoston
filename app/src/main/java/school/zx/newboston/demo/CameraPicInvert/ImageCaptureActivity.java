package school.zx.newboston.demo.CameraPicInvert;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import school.zx.newboston.R;

public class ImageCaptureActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE=1;
    private boolean isCaptureSuccess=false;
    ImageView picture;
    Button takePic;
    Bitmap photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture);
        picture=findViewById(R.id.pic_shown);
        takePic =findViewById(R.id.take_pic);
        if(!hasCamera()){
            takePic.setEnabled(false);
        }
        photo=PicInvert.drawableToBitmap(getResources().getDrawable(R.drawable.android_robot));
        picture.setImageBitmap(photo);
    }
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }
    //if button is clicked, take a pic
    public void launchCamera(View view){
        if(!isCaptureSuccess){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //there will be a result return after the lauched activity finishes
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        } else {
            photo=PicInvert.invertPic(photo);
            picture.setImageBitmap(photo);
            takePic.setText("Capture");
            isCaptureSuccess = false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            photo = (Bitmap) extras.get("data");
            //the photo is set on img view
            if(photo!=null){
                picture.setImageBitmap(photo);
                isCaptureSuccess = true;
                takePic.setText("Invert");
            } else
                isCaptureSuccess=false;
        }
    }
    public void layerDrawableHandle(View view){
        Drawable[] layer=new Drawable[2];
        layer[0]=getResources().getDrawable(R.drawable.ic_action_accounts);
        layer[1]=getResources().getDrawable(R.drawable.ic_action_person);
        LayerDrawable drawable=new LayerDrawable(layer);
        if(photo!=null)
            picture.setImageDrawable(drawable);
    }
}
