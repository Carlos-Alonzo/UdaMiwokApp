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

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //ArrayList of numbers to store list of words
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("minto wuksus","Where are you going?"));
        words.add(new Word("tinnә oyaase'nә","What is your name?"));
        words.add(new Word("oyaaset...","My name is..."));
        words.add(new Word("michәksәs?","How are you feeling?"));
        words.add(new Word("kuchi achit","I'm feeling good"));
        words.add(new Word("әәnәs'aa?","Are you coming?"));
        words.add(new Word("hәә’ әәnәm","Yes, I'm coming"));
        words.add(new Word("әәnәm","I'm coming"));
        words.add(new Word("yoowutis","let's go"));
        words.add(new Word("әnni'nem","Come here"));

        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.List);
        //listView.setBackgroundColor(R.color.category_phrases);

        listView.setAdapter(itemsAdapter);
    }
}
