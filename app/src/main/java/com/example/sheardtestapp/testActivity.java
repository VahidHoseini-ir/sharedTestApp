package com.example.sheardtestapp;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class testActivity extends AppCompatActivity {

    private MediaPlayer medeiaplayer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        SeekBar seekBar = findViewById(R.id.seekBar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            try {
                medeiaplayer = new MediaPlayer(this);
                medeiaplayer.setDataSource("https://dls.musics-fa.com/song/alibz/dlswm/Morteza%20Akhlaghi%20-%20Khato%20Neshon%20(320).mp3");
                medeiaplayer.prepare();
                medeiaplayer.start();

                seekBar.setMax(medeiaplayer.getDuration());
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        if (fromUser) {
                            medeiaplayer.seekTo(progress);
                        }

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        seekBar.setProgress(medeiaplayer.getCurrentPosition());
                        handler.postDelayed(this, 1000);

                    }
                };
                handler.postDelayed(runnable, 1000);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
