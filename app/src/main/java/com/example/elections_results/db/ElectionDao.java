package com.example.elections_results.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.elections_results.models.ElectionResult;

import java.util.List;

@Dao
public interface ElectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertResults(List<ElectionResult> results);

    @Query("SELECT * FROM election_results WHERE districtId = :districtId AND electionType = :electionType AND round = :round ORDER BY percentage DESC")
    LiveData<List<ElectionResult>> getResultsByDistrict(String districtId, String electionType, int round);

    @Query("SELECT * FROM election_results WHERE districtId = :districtId AND electionType = :electionType ORDER BY round DESC, timestamp DESC")
    LiveData<List<ElectionResult>> getHistoricalResults(String districtId, String electionType);

    @Query("DELETE FROM election_results WHERE timestamp < :threshold")
    void cleanupOldResults(long threshold);
}