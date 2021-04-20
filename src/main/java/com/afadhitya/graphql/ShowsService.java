package com.afadhitya.graphql;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShowsService {


    public List<Show> shows() {

        List<Actor> actors = List.of(
                new Actor("Fadhit"),
                new Actor("Johnny Depp")
        );

        return List.of(
                new Show("1", "Stranger Things", 2016, actors),
                new Show("2", "Ozark", 2017, actors),
                new Show("3", "The Crown", 2016, actors),
                new Show("4", "Dead to Me", 2019, actors),
                new Show("5", "Orange is the New Black", 2013, actors));
    }
}
