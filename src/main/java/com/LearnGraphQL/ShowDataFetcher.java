package com.LearnGraphQL;

import com.netflix.graphql.dgs.*;

import java.util.List;

@DgsComponent
public class ShowDataFetcher {
    ShowsServiceImpl showsService = new ShowsServiceImpl();

    @DgsData(parentType = "Query", field = "shows")
    List<Show> shows() {
        return showsService.getShows();
    }

    @DgsData(parentType = "Show", field = "reviews")
    List<Review> reviews(DgsDataFetchingEnvironment dfe) {
        Show show = dfe.getSource();
        return showsService.getReviewsForShow(show.showId());
    }
}

record Show(int showId, String title, List<Review> reviews) {}

record Review(int starRating) {}