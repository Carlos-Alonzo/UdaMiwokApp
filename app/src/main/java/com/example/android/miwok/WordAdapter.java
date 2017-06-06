package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by Carlos on 6/5/2017.
 */

public class WordAdapter extends ArrayAdapter<Word>
{
    public WordAdapter(@NonNull Context context, ArrayList<Word> words ) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View activeView = convertView;

        if(activeView == null) {
            activeView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word word = (Word) getItem(position);

        TextView miwokText = (TextView) activeView.findViewById(R.id.tv1);
        miwokText.setText(word.getMiwok());
        TextView defaultText = (TextView) activeView.findViewById(R.id.tv2);
        defaultText.setText(word.getEnglish());

        return activeView;


        // /return super.getView(position, convertView, parent);
    }
}
