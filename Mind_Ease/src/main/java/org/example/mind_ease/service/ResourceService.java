package org.example.mind_ease.service;

import org.example.mind_ease.model.Resource;
import org.example.mind_ease.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository repo;

    public ResourceService(ResourceRepository repo) {
        this.repo = repo;
    }

    public List<Resource> getAll() {
        return repo.findAll();
    }

    public Resource getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Resource> search(String stressLevel) {
        return repo.findByStressLevel(stressLevel);
    }

    public Resource save(Resource resource) {
        return repo.save(resource);
    }

    public Resource update(Long id, Resource updated) {
        return repo.findById(id).map(r -> {
            r.setTitle(updated.getTitle());
            r.setType(updated.getType());
            r.setDescription(updated.getDescription());
            r.setLink(updated.getLink());
            r.setStressLevel(updated.getStressLevel());
            return repo.save(r);
        }).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
