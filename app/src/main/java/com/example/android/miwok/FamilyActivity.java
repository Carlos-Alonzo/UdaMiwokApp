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

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList of numbers to store list of words
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("әpә","father"));
        words.add(new Word("әṭa","mother"));
        words.add(new Word("angsi","son"));
        words.add(new Word("tune","daughter"));
        words.add(new Word("taachi","older brother"));
        words.add(new Word("chalitti","younger brother"));
        words.add(new Word("tete","older sister"));
        words.add(new Word("kolliti","younger sister"));
        words.add(new Word("ama","grandmother"));
        words.add(new Word("paapa","grandfather"));

        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.List);

        listView.setAdapter(itemsAdapter);
    }
}
