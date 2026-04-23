package org.example.mind_ease.service;

import org.example.mind_ease.model.Student;
import org.example.mind_ease.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Student> search(String name) {
        return repo.findByNameContaining(name);
    }

    public Student save(Student student) {
        return repo.save(student);
    }

    public Student update(Long id, Student updated) {
        return repo.findById(id).map(s -> {
            s.setName(updated.getName());
            s.setEmail(updated.getEmail());
            return repo.save(s);
        }).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}