package com.afadhitya.graphql;

import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.BatchLoader;
import org.dataloader.MappedBatchLoader;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name = "directors")
public class DirectorDataLoader implements MappedBatchLoader<String, List<Director>> {

    private final DirectorServiceClient directorServiceClient;

    public DirectorDataLoader(DirectorServiceClient directorServiceClient) {
        this.directorServiceClient = directorServiceClient;
    }

    @Override
    public CompletionStage<Map<String, List<Director>>> load(Set<String> keys) {
        return CompletableFuture.supplyAsync(() -> directorServiceClient.loadDirectors(keys));
    }
}
