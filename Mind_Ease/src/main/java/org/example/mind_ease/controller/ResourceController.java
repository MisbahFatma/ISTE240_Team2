/** Assignment 3: Team Members
 * Misbah Fatma Begum : 418008089
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.example.mind_ease.model.Resource;
import org.example.mind_ease.repository.ResourceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "*")
public class ResourceController {

    private final ResourceRepository repo;

    public ResourceController(ResourceRepository repo) {
        this.repo = repo;
    }

    // GET ALL
    @GetMapping
    public List<Resource> getAll() {
        return repo.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Resource getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // SEARCH BY STRESS LEVEL
    @GetMapping("/search")
    public List<Resource> search(@RequestParam String stressLevel) {
        return repo.findByStressLevel(stressLevel);
    }

    // CREATE
    @PostMapping
    public Resource create(@RequestBody Resource resource) {
        return repo.save(resource);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Resource update(@PathVariable Long id, @RequestBody Resource updated) {
        return repo.findById(id).map(r -> {
            r.setTitle(updated.getTitle());
            r.setType(updated.getType());
            r.setDescription(updated.getDescription());
            r.setLink(updated.getLink());
            r.setStressLevel(updated.getStressLevel());
            return repo.save(r);
        }).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}