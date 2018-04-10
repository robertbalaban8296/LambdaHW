package com.ibm.streams.tutorial.exercise5.musicplayer;

public interface UserRatedMusicLibrary extends MusicLibrary {

    StarRating userRatingOf(Song song);

    @Override
    default Rating ratingOf(Song song) {
    	StarRating s = userRatingOf(song);
    	StarRatingConverter us = new StarRatingConverter();
    	return us.convert(s);
    }
    
    static class StarRatingConverter {
        public Rating convert(StarRating starRating) {
            return new Rating(starRating.numberOfStars * 20);
        }
    }
}
