package com.example.android.miwok;


/**
 * Created by Carlos on 6/4/2017.
 */

public class Word {
    private String miwok, english;

    public Word() {
    }

    public Word(String mwok, String eng) {
        this.miwok = mwok;
        this.english = eng;

    }

    public String getMiwok() {
        return miwok ;
    }

    public String getEnglish() {
        return english;
    }

    @Override
    public String toString() {
        return 	miwok + " \n\r" + english;
    }
}