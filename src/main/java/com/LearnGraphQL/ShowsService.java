package com.LearnGraphQL;

import java.util.List;

interface ShowsService {
    List<Show> getShows();
    List<Review> getReviewsForShow(int showId);
}