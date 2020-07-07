package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(LinkedList<String> mWordList, Context context) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }

    // The onCreateViewHolder() method is similar to the onCreate() method. Inflates the item
    // layout, and returns a ViewHolder with the layout and the adapter.
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                             int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }


    //method connects your data to the view holder.
    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;


        public WordViewHolder(@NonNull View itemView, WordListAdapter mAdapter) {
            super(itemView);
            this.wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //Get position of clicked item
            int mPosition = getLayoutPosition();
            //Use that to access the affected item list
            String element = mWordList.get(mPosition);
            //Change the word in the word list
            mWordList.set(mPosition, "Clicked " + element + "!");
            //Notify the adapter that that the data has been changed so that it can update the
            // RecyclerView and display the data
            mAdapter.notifyDataSetChanged();

        }
    }
}
