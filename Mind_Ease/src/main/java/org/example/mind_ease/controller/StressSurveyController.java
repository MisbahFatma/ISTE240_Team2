/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.example.mind_ease.model.StressSurvey;
import org.example.mind_ease.model.Student;
import org.example.mind_ease.service.MindEaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StressSurveyController {

    private final MindEaseService service;

    public StressSurveyController(MindEaseService service) {
        this.service = service;
    }

    // ==============================
    // Display all surveys
    // ==============================
    @GetMapping("/surveys")
    public String showSurveys(Model model) {
        model.addAttribute("surveys", service.getSurveys());
        return "surveys";
    }

    // ==============================
    // Show form to add survey manually (admin use)
    // ==============================
    @GetMapping("/surveys/add")
    public String showAddSurveyForm(Model model) {
        model.addAttribute("students", service.getStudents());
        return "add-survey";
    }

    @PostMapping("/surveys/add")
    public String addSurvey(@RequestParam Long studentId,
                            @RequestParam int stressLevel,
                            @RequestParam String date) {

        Student student = service.getStudents().stream()
                .filter(s -> s.getId().equals(studentId))
                .findFirst().orElse(null);

        if(student != null) {
            Long id = (long) (service.getSurveys().size() + 1);
            StressSurvey survey = new StressSurvey(id, student, stressLevel, date);
            service.addSurvey(survey);
            student.getSurveys().add(survey);
        }

        return "redirect:/add/success/survey";
    }

    // ==============================
    // Take survey (user-facing flow)
    // ==============================
    @GetMapping("/survey")
    public String showSurveyQuestions(Model model) {
        model.addAttribute("students", service.getStudents());
        return "survey-questions"; // mustache template for user survey form
    }

    @PostMapping("/survey/submit")
    public String submitSurvey(@RequestParam Long studentId,
                               @RequestParam int stressLevel) {

        Student student = service.getStudents().stream()
                .filter(s -> s.getId().equals(studentId))
                .findFirst().orElse(null);

        if (student != null) {
            Long id = (long) (service.getSurveys().size() + 1);
            StressSurvey survey = new StressSurvey(id, student, stressLevel, java.time.LocalDate.now().toString());
            service.addSurvey(survey);
            student.getSurveys().add(survey);
        }

        // Redirect user to resources based on stress level
        if (stressLevel <= 3) {
            return "redirect:/resources?level=low";
        } else if (stressLevel <= 7) {
            return "redirect:/resources?level=medium";
        } else {
            return "redirect:/resources?level=high";
        }
    }
}