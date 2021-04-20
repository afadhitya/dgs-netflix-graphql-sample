package com.afadhitya.graphql;

import java.util.List;

public class Show {
    private final String id;
    private final String title;
    private final Integer releaseYear;
    private final List<Actor> actors;
    private List<Director> directors;

    public Show(String id, String title, Integer releaseYear, List<Actor> actors) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.actors = actors;
    }

    public String getId() {
        return id;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public String getTitle() {
        return title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public List<Actor> getActors() {
        return actors;
    }
}
