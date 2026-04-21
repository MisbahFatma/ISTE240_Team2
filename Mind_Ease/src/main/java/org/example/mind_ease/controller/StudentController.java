/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.example.mind_ease.model.Student;
import org.example.mind_ease.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // GET ALL
    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // SEARCH (required in rubric)
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return repo.findByNameContaining(name);
    }

    // CREATE
    @PostMapping
    public Student create(@RequestBody Student student) {
        return repo.save(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student updated) {

        return repo.findById(id).map(s -> {
            s.setName(updated.getName());
            s.setEmail(updated.getEmail());
            return repo.save(s);
        }).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}