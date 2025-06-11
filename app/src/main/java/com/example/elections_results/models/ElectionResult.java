package com.example.elections_results.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "election_results")
public class ElectionResult {
    @PrimaryKey
    private String id;
    private String districtId;
    private String electionType; // "legislative", "local"
    private int round;
    private String candidateId;
    private int votes;
    private double percentage;
    private long timestamp;
    private boolean isFinal;

    public int getCandidateName() {
        return 0;
    }

    public int getParty() {
        return 0;
    }

    public Object getPercentage() {
        return null;
    }

    // Constructors, getters and setters...
}
