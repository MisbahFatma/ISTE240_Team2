/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.example.mind_ease.model.StressSurvey;
import org.example.mind_ease.model.Student;
import org.example.mind_ease.repository.StressSurveyRepository;
import org.example.mind_ease.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "*")
public class StressSurveyController {

    private final StressSurveyRepository surveyRepo;
    private final StudentRepository studentRepo;

    public StressSurveyController(StressSurveyRepository surveyRepo,
                                  StudentRepository studentRepo) {
        this.surveyRepo = surveyRepo;
        this.studentRepo = studentRepo;
    }

    // GET ALL
    @GetMapping
    public List<StressSurvey> getAll() {
        return surveyRepo.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public StressSurvey getById(@PathVariable Long id) {
        return surveyRepo.findById(id).orElse(null);
    }

    // SEARCH BY STUDENT
    @GetMapping("/student/{studentId}")
    public List<StressSurvey> getByStudent(@PathVariable Long studentId) {
        return surveyRepo.findByStudentId(studentId);
    }

    // CREATE
    @PostMapping
    public StressSurvey create(@RequestParam Long studentId,
                               @RequestParam int stressLevel) {

        Student student = studentRepo.findById(studentId).orElse(null);
        if (student == null) return null;

        StressSurvey survey = new StressSurvey(
                stressLevel,
                LocalDate.now().toString(),
                student
        );

        return surveyRepo.save(survey);
    }

    // UPDATE
    @PutMapping("/{id}")
    public StressSurvey update(@PathVariable Long id,
                               @RequestParam int stressLevel) {

        return surveyRepo.findById(id).map(s -> {
            s.setStressLevel(stressLevel);
            return surveyRepo.save(s);
        }).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        surveyRepo.deleteById(id);
    }
}