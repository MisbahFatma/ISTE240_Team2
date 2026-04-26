package org.example.mind_ease.controller;

import org.example.mind_ease.model.StressSurvey;
import org.example.mind_ease.service.StressSurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "*")
public class StressSurveyController {

    private final StressSurveyService service;

    public StressSurveyController(StressSurveyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<StressSurvey>> getAll() {
        return ResponseEntity.ok(service.getAllSurveys());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StressSurvey> getById(@PathVariable Long id) {
        return service.getSurveyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StressSurvey> create(@RequestBody StressSurvey survey) {
        return ResponseEntity.ok(service.saveSurvey(survey));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StressSurvey> update(
            @PathVariable Long id,
            @RequestBody StressSurvey survey) {
        return ResponseEntity.ok(service.updateSurvey(id, survey));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteSurvey(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<StressSurvey>> search(@RequestParam int stressLevel) {
        return ResponseEntity.ok(service.findByStressLevel(stressLevel));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StressSurvey>> byStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getSurveysByStudent(studentId));
    }
}