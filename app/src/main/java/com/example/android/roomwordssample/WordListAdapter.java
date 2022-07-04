package com.example.android.roomwordssample;

/*
 * Copyright (C) 2017 Google Inc.
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


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private OnClick itemClicked;
    private Context context;
    //private final LayoutInflater mInflater;
    private List<Word> mWords = Collections.emptyList();

    WordListAdapter(OnClick itemClicked){
        this.itemClicked = itemClicked;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        TextView wordItemView;

        public WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
            //wordItemView.setOnClickListener()
        }


    }

    public interface OnClick {
        void update(Word word);
    }

    /*WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }*/





    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new WordListAdapter.WordViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item,null));
        //View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        //return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        final Word current = mWords.get(position);
        holder.wordItemView.setText(current.getWord());
        holder.wordItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClicked.update(current);
            }
        });
    }

    void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    public Word getWordAt(int position) {
        return mWords.get(position);
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }


}


