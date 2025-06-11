package com.example.elections_results.models;

public class Candidate {
    private String id;
    private String name;
    private String party;
    private String biography;
    private String photoUrl;
    private double votePercentage;

    // Constructors, getters and setters
    public Candidate() {}

    public Candidate(String id, String name, String party, String biography, String photoUrl, double votePercentage) {
        this.id = id;
        this.name = name;
        this.party = party;
        this.biography = biography;
        this.photoUrl = photoUrl;
        this.votePercentage = votePercentage;
    }

    // Getters and setters...
}

