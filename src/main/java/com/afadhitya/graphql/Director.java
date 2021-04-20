package com.afadhitya.graphql;

public class Director {
    private final String name;
    private final String directorId;

    public Director(String name, String directorId) {
        this.name = name;
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public String getDirectorId() {
        return directorId;
    }
}
