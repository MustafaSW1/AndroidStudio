package com.example.roomwordsample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private final LiveData<List<Word>> mAllWords;
    private WordRepository mRepository;
    public WordViewModel(@NonNull Application application) {
        super(application);

        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }
    LiveData<List<Word>>getAllWords(){
        return mAllWords;
    }

    void insert(Word word){
        mRepository.insert(word);
    }

    void deleteOne(Word word){

        mRepository.deleteOne(word);
    }

    void updateWord(Word word){
        mRepository.updateWord(word);
    }
}
