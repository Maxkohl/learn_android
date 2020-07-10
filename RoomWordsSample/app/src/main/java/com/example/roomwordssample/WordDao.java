package com.example.roomwordssample;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    List<Word> getAllWords();
}
