package com.example.mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button play_pause, btn_repetir, btn_stop;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;
    SeekBar sk;
    MediaPlayer vectormp[] = new MediaPlayer[6];

    Thread actualizarseekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_pause = (Button) findViewById(R.id.btn_play);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        iv = (ImageView) findViewById(R.id.imageView2);
        sk = (SeekBar) findViewById(R.id.barra);

        vectormp[0] = MediaPlayer.create(this, R.raw.more);
        vectormp[1] = MediaPlayer.create(this, R.raw.dancing);
        vectormp[2] = MediaPlayer.create(this, R.raw.nunu);
        vectormp[3] = MediaPlayer.create(this, R.raw.rush);
        vectormp[4] = MediaPlayer.create(this, R.raw.breze);
        vectormp[5] = MediaPlayer.create(this, R.raw.bna);



    }



    public void PlayPause(View view) {
        if (vectormp[posicion].isPlaying()) {
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.mipmap.play);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();

        } else {

            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.mipmap.pausa);
            Toast.makeText(this, "Reproducir", Toast.LENGTH_SHORT).show();
        }
    }


    public void stop(View view) {

        if (vectormp[posicion] != null) {

            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.more);
            vectormp[1] = MediaPlayer.create(this, R.raw.dancing);
            vectormp[2] = MediaPlayer.create(this, R.raw.nunu);
            vectormp[3] = MediaPlayer.create(this, R.raw.rush);
            vectormp[4] = MediaPlayer.create(this, R.raw.breze);
            vectormp[5] = MediaPlayer.create(this, R.raw.bna);
            posicion = 0;
            Toast.makeText(this, "Reiniciando PlayList", Toast.LENGTH_SHORT).show();
            iv.setImageResource(R.mipmap.more);
        }
    }


    public void repetir(View view) {

        if (repetir == 1) {
            Toast.makeText(this, "No se repetira", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            Toast.makeText(this, "La cancion se repetira", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;

        }
    }


    public void siguiente(View view) {
        if (posicion < vectormp.length - 1) {

            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if (posicion ==0 ){
                    iv.setImageResource(R.mipmap.more);

                }else if (posicion ==1 ){
                    iv.setImageResource(R.mipmap.cancion4);
                }else if (posicion ==2 ){
                    iv.setImageResource(R.mipmap.cancion2);
                }else if (posicion ==3 ){
                    iv.setImageResource(R.mipmap.cancion5);
                }else if (posicion ==4 ){
                    iv.setImageResource(R.mipmap.cancion6);
                }else if (posicion ==5 ){
                    iv.setImageResource(R.mipmap.cancion3);
                }

            }
            else{
               posicion++;


                if (posicion ==0 ){
                    iv.setImageResource(R.mipmap.more);

                }else if (posicion ==1 ){
                    iv.setImageResource(R.mipmap.cancion4);
                }else if (posicion ==2 ){
                    iv.setImageResource(R.mipmap.cancion2);
                }else if (posicion ==3 ){
                    iv.setImageResource(R.mipmap.cancion5);
                }else if (posicion ==4 ){
                    iv.setImageResource(R.mipmap.cancion6);
                }else if (posicion ==5 ){
                    iv.setImageResource(R.mipmap.cancion3);
                }
            }
        } else {
            Toast.makeText(this, "Ya no hay mas canciones", Toast.LENGTH_SHORT).show();

        }
    }

    public void atras (View view){

        if (posicion > 1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();

                vectormp[0] = MediaPlayer.create(this, R.raw.more);
                vectormp[1] = MediaPlayer.create(this, R.raw.dancing);
                vectormp[2] = MediaPlayer.create(this, R.raw.nunu);
                vectormp[3] = MediaPlayer.create(this, R.raw.rush);
                vectormp[4] = MediaPlayer.create(this, R.raw.breze);
                vectormp[5] = MediaPlayer.create(this, R.raw.bna);
                posicion--;



                if (posicion ==0 ){
                    iv.setImageResource(R.mipmap.more);

                }else if (posicion ==1 ){
                    iv.setImageResource(R.mipmap.cancion4);
                }else if (posicion ==2 ){
                    iv.setImageResource(R.mipmap.cancion2);
                }else if (posicion ==3 ){
                    iv.setImageResource(R.mipmap.cancion5);
                }else if (posicion ==4 ){
                    iv.setImageResource(R.mipmap.cancion6);
                }else if (posicion ==5 ){
                    iv.setImageResource(R.mipmap.cancion3);
                }

            }else{
         posicion--;


                if (posicion ==0 ){
                    iv.setImageResource(R.mipmap.more);

                }else if (posicion ==1 ){
                    iv.setImageResource(R.mipmap.cancion4);
                }else if (posicion ==2 ){
                    iv.setImageResource(R.mipmap.cancion2);
                }else if (posicion ==3 ){
                    iv.setImageResource(R.mipmap.cancion5);
                }else if (posicion ==4 ){
                    iv.setImageResource(R.mipmap.cancion6);
                }else if (posicion ==5 ){
                    iv.setImageResource(R.mipmap.cancion3);
                }
            }

        }else{
            Toast.makeText(this, "Ya no puede retroceder", Toast.LENGTH_SHORT).show();
        }
    }
}