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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList of numbers to store list of words
        ArrayList<Word>  words = new ArrayList<>();

        words.add(new Word("lutti","one"));
        words.add(new Word("otiiko","two"));
        words.add(new Word("tolookosu","three"));
        words.add(new Word("oyyisa","four"));
        words.add(new Word("massokka","five"));
        words.add(new Word("temmokka","six"));
        words.add(new Word("kenekaku","seven"));
        words.add(new Word("kawinta","eight"));
        words.add(new Word("wo’e","nine"));
        words.add(new Word("na’aacha","ten"));

        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.List);

        listView.setAdapter(itemsAdapter);

        //ArrayList<TextView> wordViews = new ArrayList<TextView>();
        //int counter=0;

        //while(counter < words.size())
        // for(int counter=0; counter< words.size(); counter++)
        /*{
            TextView wordView = new TextView(this);
            //wordViews.add(counter, new TextView(this));
            //wordViews.get(counter).setText(words.get(counter));
            wordView.setText(words.get(counter));
            rootView.addView(wordView);
            //.setText(words.get(counter));
            //rootView.addView(wordView);
            //counter++;
        }
        */
        //TextView wordView = new TextView(this);
        //wordView.setText(words.get(0));
        //rootView.addView(wordView);

        //for (int i=0; i < words.length; i++)
         //words[i]=i++;


    }
}
