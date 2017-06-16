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

    public int getSoundRscID() {
        return soundRscID;
    }

    private int soundRscID;

    public Word() {
    }

    public Word(String mwok, String eng) {
        this.miwok = mwok;
        this.english = eng;
        imageID=-1;
        soundRscID=0;
    }
    public Word(String mwok, String eng, int id, int audioID) {
        this.miwok = mwok;
        this.english = eng;
        this.imageID=id;
        this.soundRscID=audioID;

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