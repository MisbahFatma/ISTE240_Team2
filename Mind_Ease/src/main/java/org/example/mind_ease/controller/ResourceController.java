package org.example.mind_ease.controller;

import org.example.mind_ease.model.Resource;
import org.example.mind_ease.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "*")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAll() {
        return ResponseEntity.ok(resourceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getById(@PathVariable Long id) {
        Resource resource = resourceService.getById(id);

        if (resource == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resource);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Resource>> search(@RequestParam String stressLevel) {
        return ResponseEntity.ok(resourceService.search(stressLevel));
    }

    @PostMapping
    public ResponseEntity<Resource> create(@RequestBody Resource resource) {
        return ResponseEntity.ok(resourceService.save(resource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource> update(@PathVariable Long id,
                                           @RequestBody Resource updated) {

        Resource resource = resourceService.update(id, updated);

        if (resource == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        resourceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}