package com.afadhitya.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsMutation;
import graphql.schema.DataFetchingEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DgsComponent
public class RatingMutation {

    private static final Logger LOG = LoggerFactory.getLogger(RatingMutation.class);

    @DgsData(parentType = "Mutation", field = "addRating")
    public Rating addRating(DataFetchingEnvironment dfe) {
        int stars = dfe.getArgument("stars");

        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Start must be on range 1-5");
        }

        String title = dfe.getArgument("title");

        LOG.info("title : {} and rating : {}", title, stars);

        return new Rating(title, stars);
    }
}
