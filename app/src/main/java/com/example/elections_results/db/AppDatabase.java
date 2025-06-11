package com.example.elections_results.db;

import android.app.Application;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.elections_results.models.ElectionResult;

@Database(entities = {ElectionResult.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase getDatabase(Application application) {
        return null;
    }

    public abstract ElectionDao electionDao();
}
