package org.efrei.start.services;

import java.util.List;
import org.efrei.start.dto.CreateDirector;
import org.efrei.start.models.Director;
import org.efrei.start.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    private final DirectorRepository repository;

    @Autowired
    public DirectorService(DirectorRepository repository) {
        this.repository = repository;
    }

    public List<Director> findAll() {
        return repository.findAll();
    }

    public Director findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void create(CreateDirector createDirector) {
        Director director = new Director();
        director.setFirstname(createDirector.getFirstname());
        director.setName(createDirector.getName());
        repository.save(director);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Director director) {
        Director updatedDirector = findById(id);
        updatedDirector.setFirstname(director.getFirstname());
        updatedDirector.setName(director.getName());
        repository.save(updatedDirector);
    }
}
