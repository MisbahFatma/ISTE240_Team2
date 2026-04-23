package org.example.mind_ease.service;

import org.example.mind_ease.model.StressSurvey;
import org.example.mind_ease.model.Student;
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

    public StressSurveyService(StressSurveyRepository surveyRepo,
                               StudentRepository studentRepo) {
        this.surveyRepo = surveyRepo;
        this.studentRepo = studentRepo;
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

    // FIXED CREATE METHOD (NO CRASH)
    public StressSurvey createSurvey(Long studentId, int stressLevel) {

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        StressSurvey survey = new StressSurvey();
        survey.setStudent(student);
        survey.setStressLevel(stressLevel);
        survey.setDate(LocalDate.now());

        return surveyRepo.save(survey);
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
}