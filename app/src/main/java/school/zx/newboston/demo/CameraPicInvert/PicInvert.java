package school.zx.newboston.demo.CameraPicInvert;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import school.zx.newboston.R;

/**
 * Created by THink on 2018/3/24.
 */

public class PicInvert {
    static Bitmap invertPic(Bitmap pic){
        Bitmap finalImg=Bitmap.createBitmap(pic.getWidth(),pic.getHeight(),pic.getConfig());
        int A,R,G,B;
        int pixelColor;
        int height=pic.getHeight();
        int width=pic.getWidth();
        for(int y=0;y<height;y++){
            for (int x=0;x<width;x++){
                pixelColor=pic.getPixel(x,y);
                A= Color.alpha(pixelColor);
                R=255-Color.red(pixelColor);
                G=255-Color.green(pixelColor);
                B=255-Color.blue(pixelColor);
                finalImg.setPixel(x,y,
                        Color.argb(A,R,G,B));
            }
        }
        return finalImg;
    }
    //format drawable to bitmap
    static Bitmap drawableToBitmap(Drawable pic){
        return ((BitmapDrawable) pic).getBitmap();
    }
}
