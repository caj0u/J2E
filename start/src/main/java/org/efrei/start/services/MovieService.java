package org.efrei.start.services;

import java.util.List;
import org.efrei.start.dto.CreateMovie;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Director;
import org.efrei.start.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository repository;
    private final DirectorService directorService;

    @Autowired
    public MovieService(MovieRepository repository, DirectorService directorService) {
        this.repository = repository;
        this.directorService = directorService;
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Movie findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void create(CreateMovie createMovie) {
        Movie movie = new Movie();
        movie.setTitle(createMovie.getTitle());
        movie.setCategory(createMovie.getCategory());

        Director director = directorService.findById(createMovie.getDirectorId());
        movie.setDirector(director);

        repository.save(movie);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Movie movie) {
        Movie updatedMovie = findById(id);
        updatedMovie.setTitle(movie.getTitle());
        updatedMovie.setCategory(movie.getCategory());
        updatedMovie.setDirector(movie.getDirector());
        repository.save(updatedMovie);
    }
}
