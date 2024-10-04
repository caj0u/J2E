package org.efrei.start.services;

import java.util.List;

import org.efrei.start.dto.CreateReview;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Review;
import org.efrei.start.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository repository;
    private final MovieService movieService;

    @Autowired
    public ReviewService(ReviewRepository repository, MovieService movieService) {
        this.repository = repository;
        this.movieService = movieService;
    }

    public List<Review> findAll() {
        return repository.findAll();
    }

    public Review findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void create(CreateReview createReview) {
        Review review = new Review();
        review.setTitle(createReview.getTitle());
        review.setDescription(createReview.getDescription());
        review.setRating(createReview.getRating());

        Movie movie = movieService.findById(createReview.getMovieId());
        review.setMovie(movie);

        repository.save(review);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Review review) {
        Review updatedReview = findById(id);
        updatedReview.setTitle(review.getTitle());
        updatedReview.setDescription(review.getDescription());
        updatedReview.setRating(review.getRating());
        repository.save(updatedReview);
    }
}
