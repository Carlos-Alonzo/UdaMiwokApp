/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private WordAdapter itemsAdapter;
    private MediaPlayer Media;
    private ListView listView;
    private ArrayList<Word> words;
    private AudioManager myAudioManager;
    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener AudFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                Media.pause();
                Media.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                Media.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList of numbers to store list of words
        words = new ArrayList<>();

        words.add(new Word("lutti","one",R.drawable.number_one, R.raw.number_one));
        words.add(new Word("otiiko","two",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("tolookosu","three",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("oyyisa","four",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("massokka","five",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("temmokka","six",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("kenekaku","seven",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("kawinta","eight",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("wo’e","nine",R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("na’aacha","ten",R.drawable.number_ten, R.raw.number_ten));

        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        listView = (ListView) findViewById(R.id.List);
        myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        //listView.setBackgroundColor(getResources().getColor(R.color.category_numbers,0));

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Word word = words.get(position);
                releaseMediaPlayer();
                int request_result = myAudioManager.requestAudioFocus(AudFocusChangeListener,AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(request_result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {

                    Media = MediaPlayer.create(NumbersActivity.this, word.getSoundRscID());
                    Media.start();
                    Media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            // Now that the sound file has finished playing, release the media player resources.
                            releaseMediaPlayer();
                        }

                    });
                }

            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
       // itemsAdapter.releaseMediaPlayer();

    }

    void releaseMediaPlayer()
    {
        // If the media player is not null, then it may be currently playing a sound.
        if (Media != null)
        {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            Media.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            Media = null;
            //myAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
