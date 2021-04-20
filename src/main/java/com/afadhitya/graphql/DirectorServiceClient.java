package com.afadhitya.graphql;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DirectorServiceClient {

    private final static Logger LOG = LoggerFactory.getLogger(DirectorServiceClient.class);

    private final Map<String, List<Director>> directors = new ConcurrentHashMap<>();

    private final ShowsService showsService;

    public DirectorServiceClient(ShowsService showsService) {
        this.showsService = showsService;
    }

    @PostConstruct
    private void createDummyDirector() {
        Faker faker = new Faker();

        showsService.shows().forEach(show -> {
            List<Director> generatedDir = IntStream.range(0, faker.number().numberBetween(1, 10)).mapToObj(number -> {
               return new Director(faker.name().name(), faker.idNumber().valid());
            }).collect(Collectors.toList());

            directors.put(show.getId(), generatedDir);
        });
    }

    public Map<String, List<Director>> loadDirectors(Set<String> showIds) {
        LOG.debug("loadDirectors: this method only called once");
        return directors.entrySet().stream().filter(entry -> showIds.contains(entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
