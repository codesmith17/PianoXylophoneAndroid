package com.example.pianofinal;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pianofinal.R;

public class xylophone extends AppCompatActivity {

    // Helpful Constants
    private final int sim_sound = 7;
    private final float lft_vol = 1.0f;
    private final float rgt_vol = 1.0f;
    private final int loop = 0;
    private final int prty = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    // Add member variables here
    private SoundPool mSoundPool;
    private int mCSoundId1;
    private int mDSoundId2;
    private int mESoundId3;
    private int mFSoundId4;
    private int mGSoundId5;
    private int mASoundId6;
    private int mBSoundId7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xylophone);

        // Create a new SoundPool
        mSoundPool = new SoundPool(sim_sound, AudioManager.STREAM_MUSIC, 0);

        // Load and get the IDs to identify the sounds
        mCSoundId1 = mSoundPool.load(getApplicationContext(), R.raw.notea, 1);
        mDSoundId2 = mSoundPool.load(getApplicationContext(), R.raw.noteb, 1);
        mESoundId3 = mSoundPool.load(getApplicationContext(), R.raw.notec, 1);
        mFSoundId4 = mSoundPool.load(getApplicationContext(), R.raw.noted, 1);
        mGSoundId5 = mSoundPool.load(getApplicationContext(), R.raw.notee, 1);
        mASoundId6 = mSoundPool.load(getApplicationContext(), R.raw.notef, 1);
        mBSoundId7 = mSoundPool.load(getApplicationContext(), R.raw.noteg, 1);


    }

    // Add the play methods triggered by the buttons
    public void c(View v) {
        mSoundPool.play(mCSoundId1, lft_vol, rgt_vol, prty, loop, NORMAL_PLAY_RATE);
    }

    public void d(View v) {
        mSoundPool.play(mDSoundId2, lft_vol, rgt_vol, prty, loop, NORMAL_PLAY_RATE);
    }

    // Add the play methods triggered by the buttons
    public void e(View v) {
        mSoundPool.play(mESoundId3, lft_vol, rgt_vol, prty, loop, NORMAL_PLAY_RATE);
    }

    public void f(View v) {
        mSoundPool.play(mFSoundId4, lft_vol, rgt_vol, prty, loop, NORMAL_PLAY_RATE);
    }

    public void g(View v) {
        mSoundPool.play(mGSoundId5, lft_vol, rgt_vol, prty, loop, NORMAL_PLAY_RATE);
    }

    public void a(View v) {
        mSoundPool.play(mASoundId6, lft_vol, rgt_vol, prty, loop, NORMAL_PLAY_RATE);
    }

    public void b(View v) {
        mSoundPool.play(mBSoundId7, lft_vol, rgt_vol, prty, loop, NORMAL_PLAY_RATE);
    }

}
