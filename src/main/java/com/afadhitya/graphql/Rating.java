package com.afadhitya.graphql;

public class Rating {
    private String title;
    private Integer stars;

    public Rating(String title, Integer stars) {
        this.title = title;
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
