package com.example.roomwordssample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public WordDao wordDao;

    private static WordRoomDatabase INSTANCE;

    //Method makes the WordRoomDatabase a singleton. Makes it so you can't have multiple
    // instances of room database.
    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    //create Database with database builder
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }


}
