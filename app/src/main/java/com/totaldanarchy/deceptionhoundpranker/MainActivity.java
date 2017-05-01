package com.totaldanarchy.deceptionhoundpranker;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class MainActivity extends ActionBarActivity {

    //declare all the buttons we'll be using
    private Button startLie, startTruth,
            startIdiot, startGenius, startLieTruth , stopScan;
    //declare the mediaplayer
    private MediaPlayer play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //put advertising into the app
        AdView mAdView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Give an initial toast message
        Context context = getApplicationContext();
        CharSequence text = "Wave the phone as though you are swiping with a metal detector to enhance the effect.";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

        //play the lie file when button is pressed
        startLie = (Button) findViewById(R.id.startlie);
        startLie.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stopPlaying();
                play = MediaPlayer.create(MainActivity.this, R.raw.lie_detector);
                play.start();
            }
        });

        startLieTruth = (Button) findViewById(R.id.startLieTruth);
        startLieTruth.setOnClickListener(new View.OnClickListener() {
            //play a random between truth or lie
            final int[] sounds={R.raw.lie_detector, R.raw.truth_detector, R.raw.lie_detector, R.raw.truth_detector, R.raw.lie_detector, R.raw.truth_detector};
            Random r = new Random();
            final int rndm = r.nextInt(sounds.length);

            @Override
            public void onClick(View v) {
                stopPlaying();
                play = MediaPlayer.create(getApplicationContext(), sounds[rndm]);
                play.start();
            }
        });

        //stop the audio file when pressed
        stopScan = (Button) findViewById(R.id.stopScan);
        stopScan.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    play.stop();
                }

                ;
            });


        //play the truth file when button is pressed
        startTruth = (Button) findViewById(R.id.starttruth);
        startTruth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stopPlaying();
                play = MediaPlayer.create(MainActivity.this, R.raw.truth_detector);
                play.start();
            }
        });

        //play the idiot file when button is pressed
        startIdiot = (Button) findViewById(R.id.startidiot);
        startIdiot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stopPlaying();
                play = MediaPlayer.create(MainActivity.this, R.raw.idiot_detector);
                play.start();
            }
        });

        //play the genius file when button is pressed
        startGenius = (Button) findViewById(R.id.startgenius);
        startGenius.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stopPlaying();
                play = MediaPlayer.create(MainActivity.this, R.raw.genius_detector);
                play.start();
            }
        });

    }

    //method used to stop playing a previous file if another button is pressed
    private void stopPlaying() {
        if (play != null) {
            play.stop();
            play.release();
            play = null;
        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
