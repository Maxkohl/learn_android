package com.example.roomwordssample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private LiveData<List<Word>> mWordList;


    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mWordList = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mWordList;
    }

    public void insert (Word word) {
        mRepository.insert(word);
    }
}
