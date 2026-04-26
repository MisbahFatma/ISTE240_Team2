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
        return surveyRepo.findByStudentId(studentId);
    }

    // 🔥 FIXED CREATE (AUTO CREATES STUDENT)
    public StressSurvey saveSurvey(StressSurvey survey) {

        if (survey.getDate() == null) {
            survey.setDate(LocalDate.now());
        }

        if (survey.getStudent() != null && survey.getStudent().getId() != null) {

            Long id = survey.getStudent().getId();

            Student student = studentRepo.findById(id)
                    .orElseGet(() -> {
                        Student s = new Student();
                        s.setName("Student " + id);
                        s.setEmail("auto" + id + "@mail.com");
                        return studentRepo.save(s);
                    });

            survey.setStudent(student);
        }

        return surveyRepo.save(survey);
    }

    // UPDATE
    public StressSurvey updateSurvey(Long id, StressSurvey updated) {

        StressSurvey existing = surveyRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found"));

        existing.setStressLevel(updated.getStressLevel());
        existing.setDate(updated.getDate());

        if (updated.getStudent() != null && updated.getStudent().getId() != null) {

            Long sid = updated.getStudent().getId();

            Student student = studentRepo.findById(sid)
                    .orElseGet(() -> {
                        Student s = new Student();
                        s.setName("Student " + sid);
                        s.setEmail("auto" + sid + "@mail.com");
                        return studentRepo.save(s);
                    });

            existing.setStudent(student);
        }

        return surveyRepo.save(existing);
    }

    public void deleteSurvey(Long id) {
        surveyRepo.deleteById(id);
    }

    public List<StressSurvey> findByStressLevel(int stressLevel) {
        return surveyRepo.findByStressLevel(stressLevel);
    }
}