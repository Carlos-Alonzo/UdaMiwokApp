package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    private WordAdapter itemsAdapter;
    private MediaPlayer Media;
    private ListView listView;
    private ArrayList<Word> words;
    private AudioManager myAudioManager;

    public PhrasesFragment() {
        // Required empty public constructor
    }

    private AudioManager.OnAudioFocusChangeListener AudFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if ((focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) && Media != null) {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        //ArrayList of numbers to store list of words
        words = new ArrayList<>();

        words.add(new Word("minto wuksus","Where are you going?",-1, R.raw.phrase_where_are_you_going));
        words.add(new Word("tinnә oyaase'nә","What is your name?", -1, R.raw.phrase_what_is_your_name));
        words.add(new Word("oyaaset...","My name is...", -1, R.raw.phrase_my_name_is));
        words.add(new Word("michәksәs?","How are you feeling?", -1, R.raw.phrase_how_are_you_feeling));
        words.add(new Word("kuchi achit","I'm feeling good", -1, R.raw.phrase_im_feeling_good));
        words.add(new Word("әәnәs'aa?","Are you coming?", -1, R.raw.phrase_are_you_coming));
        words.add(new Word("hәә’ әәnәm","Yes, I'm coming", -1, R.raw.phrase_yes_im_coming));
        words.add(new Word("әәnәm","I'm coming", -1, R.raw.phrase_im_coming));
        words.add(new Word("yoowutis","let's go", -1, R.raw.phrase_lets_go));
        words.add(new Word("әnni'nem","Come here", -1, R.raw.phrase_come_here));

        itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_phrases);
        listView = (ListView) rootView.findViewById(R.id.List);
        myAudioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);
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

                    Media = MediaPlayer.create(getActivity(), word.getSoundRscID());
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


        return rootView;
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

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }
}
