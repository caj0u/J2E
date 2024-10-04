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
    private final DirectorService directorService; // Ajoutez cette ligne

    @Autowired
    public MovieService(MovieRepository repository, DirectorService directorService) {
        this.repository = repository;
        this.directorService = directorService; // Initialisez le service du directeur
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

        // Associez le directeur
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
        updatedMovie.setCategory(movie.getCategory()); // Assurez-vous de mettre à jour la catégorie
        updatedMovie.setDirector(movie.getDirector()); // Mettez à jour le directeur si nécessaire
        repository.save(updatedMovie);
    }
}
