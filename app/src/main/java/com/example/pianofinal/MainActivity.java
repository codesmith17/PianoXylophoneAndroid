package com.example.pianofinal;

import android.annotation.SuppressLint;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;

import android.os.Build;
import android.os.CountDownTimer;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import android.Manifest;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Button d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12;
    private MediaPlayer mp;
    AppCompatButton t1, t2, t3, t4, t5, t6, t7, t8, t9;

    ImageButton b1, b2;

    String[] country = {"Playlist", "Happy Birthday", "Old MacDonald", "Twinkle Twinkle", "Ode to joy", "Let it Snow"};

    Switch AdsSwitch;
    ImageButton record, stop, play;
    ImageButton Appsetting, appExit;

    private MediaPlayer mediaPlayer;

    Button buttonStart, buttonStop, buttonPlayLastRecordAudio;


    private MediaRecorder mediaRecorder;


    private MediaPlayer mPlayer;


    private static String mFileName = null;


    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isMicrophonePresent()) {
            getMicrophonePermission();
        }

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setPrompt("Playlist");


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
//                if (!value.equals("Playlist"))
//                    Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//                String selectedSong = parent.getItemAtPosition(position).toString();


                switch (position) {

                    case 1: {

                        stopPlaying();
                        b1.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mp = MediaPlayer.create(MainActivity.this, R.raw.happy);
                                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                                mp.start();



                            }

                        });


                        break;

                    }

                    case 2: {
                        stopPlaying();
                        b1.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mp = MediaPlayer.create(MainActivity.this, R.raw.let);
                                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                                mp.start();


                            }

                        });


                        break;

                    }

                    case 3: {
                        stopPlaying();
                        b1.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mp = MediaPlayer.create(MainActivity.this, R.raw.ode);
                                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                                mp.start();


                            }

                        });


                        break;

                    }

                    case 4: {
                        stopPlaying();
                        b1.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mp = MediaPlayer.create(MainActivity.this, R.raw.old);
                                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                                mp.start();


                            }

                        });


                        break;
                    }

                    case 5: {
                        stopPlaying();
                        b1.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mp = MediaPlayer.create(MainActivity.this, R.raw.twinkle);
                                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                                mp.start();


                            }

                        });


                        break;

                    }


                }

                b2.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       pausePlaying();


                    }

                });


            }

            private void stopPlaying() {
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
            }
            private void pausePlaying() {
                if (mp != null) {
                    mp.pause();
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mediaPlayer = new MediaPlayer();


        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);
        d6 = findViewById(R.id.d6);
        d7 = findViewById(R.id.d7);
        d8 = findViewById(R.id.d8);
        d9 = findViewById(R.id.d9);
        d10 = findViewById(R.id.d10);
        d11 = findViewById(R.id.d11);
        d12 = findViewById(R.id.d12);

        b1 = findViewById(R.id.playButton);
        b2 = findViewById(R.id.pauseButton);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t9 = findViewById(R.id.t9);


        AdsSwitch = findViewById(R.id.adsSwitch);
        record = findViewById(R.id.Btnrecord);
        stop = findViewById(R.id.BtnStop);
        play = findViewById(R.id.BtnPlay);
        Appsetting = findViewById(R.id.BtnSetting);
        appExit = findViewById(R.id.BtnAppExit);


        d1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d1);
                MyMedia();


            }

        });
        d2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d2);
                MyMedia();
            }
        });
        d3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d3);
                MyMedia();
            }
        });
        d4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d4);
                MyMedia();
            }
        });
        d5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d5);
                MyMedia();
            }
        });
        d6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d6);
                MyMedia();
            }
        });
        d7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d7);
                MyMedia();
            }
        });
        d8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d8);
                MyMedia();
            }
        });
        d9.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d9);
                MyMedia();
            }
        });
        d10.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d10);
                MyMedia();
            }
        });
        d11.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d11);
                MyMedia();
            }
        });
        d12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d12);
                MyMedia();
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t1);
                MyMedia();
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t2);
                MyMedia();
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t3);
                MyMedia();
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t4);
                MyMedia();
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t5);
                MyMedia();
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t6);
                MyMedia();
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t7);
                MyMedia();
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t8);
                MyMedia();
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t9);
                MyMedia();
            }
        });


        appExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                finish();
            }

            private void stopPlaying() {
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
            }
        });


    }


    private static int MICROPHONE_PERMISSION_CODE = 200;

    public void btnRecordPressed(View v) {

        try {

            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(getRecordingFilePath());
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();
            mediaRecorder.start();

            Toast.makeText(this, "Recording is started", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void btnStopPressed(View v) {

        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;

        Toast.makeText(this, "Recording is stopped", Toast.LENGTH_LONG).show();


    }

    public void btnPlayPressed(View v) {

        try {
            mPlayer = new MediaPlayer();
            Toast.makeText(this, "Recording is playing", Toast.LENGTH_LONG).show();
            mPlayer.setDataSource(getRecordingFilePath());
            mPlayer.prepare();
            mPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean isMicrophonePresent() {
        return this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
    }

    private void getMicrophonePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, MICROPHONE_PERMISSION_CODE);

        }
    }

    private String getRecordingFilePath() {
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File MusicDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(MusicDirectory, "testRecordingFile" + ".mp3");
        return file.getPath();
    }

    public void onBackPressed() {
        stopPlaying();
        finish();
    }


    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }


    public void play(View view) {

    }


    private void MyMedia() {
        mediaPlayer.start();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}