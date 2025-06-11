package com.example.elections_results.models;

import java.util.List;

public class District {
    private String id;
    private String name;
    private String type; // "national", "region", "department", "commune"
    private String parentId; // for hierarchy
    private List<ElectionResult> results;
    private double participationRate;
    private GeoBounds geoBounds;

    // Constructors, getters and setters...

    public static class GeoBounds {
        public double north;
        public double south;
        public double east;
        public double west;

        // Constructor and methods...
    }
}
