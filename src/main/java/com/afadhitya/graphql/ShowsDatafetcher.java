package com.afadhitya.graphql;

import com.netflix.graphql.dgs.*;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDatafetcher {

    private final ShowsService showsService;

    public ShowsDatafetcher(ShowsService showsService) {
        this.showsService = showsService;
    }

    private final List<Actor> actors = List.of(
            new Actor("Fadhit"),
            new Actor("Johnny Depp")
    );

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {

        List<Show> shows = showsService.shows();

        if (titleFilter == null) {
            return shows;
        }

        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }

    @DgsData(parentType = "Show", field = "actors")
    public List<Actor> actors (DgsDataFetchingEnvironment dfe) {

        System.out.println("this actors method executed");

        Show show = dfe.getSource();

        return actors;
    }

    // sample with data loader

    @DgsData(parentType = "Show", field = "directors")
    public CompletableFuture<Director> director(DgsDataFetchingEnvironment dfe) {
        DataLoader<String, Director> dataLoader = dfe.getDataLoader("directors");
        Show show = dfe.getSource();

        System.out.println("this data loader method executed");

        return dataLoader.load(show.getId());
    }


    @DgsQuery
    public List<Actor> actors(@InputArgument String nameFilter) {
        if (nameFilter == null) {
            return actors;
        }

        return actors.stream().filter(a -> a.getName().contains(nameFilter)).collect(Collectors.toList());
    }
}
