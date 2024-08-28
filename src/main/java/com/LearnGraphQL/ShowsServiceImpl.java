package com.LearnGraphQL;

import java.util.List;

public class ShowsServiceImpl implements ShowsService {
    private final List<Show> shows = List.of(
            new Show(1, "Stranger Things",
                    List.of(new Review(5), new Review(4))),
            new Show(2, "Ozark",
                    List.of(new Review(3), new Review(4)))
    );

    @Override
    public List<Show> getShows() {
        return shows;
    }

    @Override
    public List<Review> getReviewsForShow(int showId) {
        for (Show show: shows) {
            if (show.showId() == showId) return show.reviews();
        }
        return null;
    }
}
