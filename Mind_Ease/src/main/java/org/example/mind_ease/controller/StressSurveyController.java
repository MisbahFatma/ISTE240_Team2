package org.example.mind_ease.controller;

import org.example.mind_ease.model.StressSurvey;
import org.example.mind_ease.model.Student;
import org.example.mind_ease.model.Resource;
import org.example.mind_ease.repository.StressSurveyRepository;
import org.example.mind_ease.repository.StudentRepository;
import org.example.mind_ease.repository.ResourceRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "*")
public class StressSurveyController {

    private final StressSurveyRepository surveyRepo;
    private final StudentRepository studentRepo;
    private final ResourceRepository resourceRepo;

    public StressSurveyController(StressSurveyRepository surveyRepo,
                                  StudentRepository studentRepo,
                                  ResourceRepository resourceRepo) {
        this.surveyRepo = surveyRepo;
        this.studentRepo = studentRepo;
        this.resourceRepo = resourceRepo;
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

    // GET BY STUDENT
    @GetMapping("/student/{studentId}")
    public List<StressSurvey> getByStudent(@PathVariable Long studentId) {
        return surveyRepo.findByStudentId(studentId);
    }

    // CREATE + RETURN RESOURCES
    @PostMapping
    public List<Resource> create(@RequestParam Long studentId,
                                 @RequestParam int stressLevel) {

        Student student = studentRepo.findById(studentId).orElse(null);
        if (student == null) return null;

        StressSurvey survey = new StressSurvey(
                stressLevel,
                LocalDate.now(),
                student
        );

        surveyRepo.save(survey);

        String category = getStressCategory(stressLevel);

        return resourceRepo.findByStressLevel(category);
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

    // LOGIC
    private String getStressCategory(int level) {
        if (level <= 2) return "LOW";
        else if (level == 3) return "MEDIUM";
        else return "HIGH";
    }
}