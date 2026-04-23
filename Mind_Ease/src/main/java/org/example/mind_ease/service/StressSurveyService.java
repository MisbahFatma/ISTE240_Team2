package org.example.mind_ease.service;

import org.example.mind_ease.model.Resource;
import org.example.mind_ease.model.StressSurvey;
import org.example.mind_ease.model.Student;
import org.example.mind_ease.repository.ResourceRepository;
import org.example.mind_ease.repository.StressSurveyRepository;
import org.example.mind_ease.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StressSurveyService {

    private final StressSurveyRepository surveyRepo;
    private final StudentRepository studentRepo;
    private final ResourceRepository resourceRepo;

    public StressSurveyService(StressSurveyRepository surveyRepo,
                               StudentRepository studentRepo,
                               ResourceRepository resourceRepo) {
        this.surveyRepo = surveyRepo;
        this.studentRepo = studentRepo;
        this.resourceRepo = resourceRepo;
    }

    public List<StressSurvey> getAllSurveys() {
        return surveyRepo.findAll();
    }

    public Optional<StressSurvey> getSurveyById(Long id) {
        return surveyRepo.findById(id);
    }

    public List<StressSurvey> getSurveysByStudent(Long studentId) {
        return surveyRepo.findByStudent_Id(studentId);
    }

    // FIXED: now clean + explicit return usage
    public List<Resource> createSurveyAndGetResources(Long studentId, int stressLevel) {

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        StressSurvey survey = new StressSurvey();
        survey.setStudent(student);
        survey.setStressLevel(stressLevel);
        survey.setDate(LocalDate.now());

        surveyRepo.save(survey);

        String category = getStressCategory(stressLevel);
        return resourceRepo.findByStressLevel(category);
    }

    public StressSurvey updateSurvey(Long id, int stressLevel) {
        return surveyRepo.findById(id)
                .map(survey -> {
                    survey.setStressLevel(stressLevel);
                    return surveyRepo.save(survey);
                })
                .orElseThrow(() -> new RuntimeException("Survey not found"));
    }

    public void deleteSurvey(Long id) {
        surveyRepo.deleteById(id);
    }

    private String getStressCategory(int level) {
        if (level <= 2) return "LOW";
        else if (level == 3) return "MEDIUM";
        else return "HIGH";
    }
}