package com.example.changewallpaper;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnChangeWallpaper;
    boolean running;
    int[] imagesArray=new int[]{R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,R.drawable.image4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeWallpaper=(Button)
                findViewById(R.id.btn_start_change_wallpaper);
        btnChangeWallpaper.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        if(!running)
        {
            new Timer().schedule
                    (new MyTimer(),30000,30000);
            running=true;
        }
    }
    class MyTimer extends TimerTask
    {
        public void run()
        {
            int aryLength = imagesArray.length;
            Random random = new Random();
            int rNum = random.nextInt(aryLength);
            try {
                WallpaperManager wallpaperManager =
                        WallpaperManager.getInstance(getBaseContext());
                wallpaperManager.setBitmap
                        (BitmapFactory.decodeResource(getResources(), imagesArray[rNum]));
            }
            catch(Exception e)
            {
            }
        }
    }
}