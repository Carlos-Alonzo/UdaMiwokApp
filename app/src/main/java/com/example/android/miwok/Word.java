package com.example.android.miwok;


/**
 * Created by Carlos on 6/4/2017.
 */

public class Word {
    private String miwok, english;

    public int getImageID() {
        return imageID;
    }

    private int imageID;

    public Word() {
    }

    public Word(String mwok, String eng) {
        this.miwok = mwok;
        this.english = eng;
        imageID=-1;
    }
    public Word(String mwok, String eng, int id) {
        this.miwok = mwok;
        this.english = eng;
        imageID=id;

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

    public boolean hasImg()
    {
        boolean stateofpic = false;
        if(imageID > -1 )
            stateofpic = true;

        return stateofpic;

    }
}