/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.example.mind_ease.model.Student;
import org.example.mind_ease.service.MindEaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final MindEaseService service;

    // Constructor injection
    public StudentController(MindEaseService service) {
        this.service = service;
    }

    // Display list of students
    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("students", service.getStudents());
        return "students";
    }

    // Show form to add student
    @GetMapping("/students/add")
    public String showAddStudentForm() {
        return "add-student";
    }

    // Handle form submission
    @PostMapping("/students/add")
    public String addStudent(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam String email) {

        Student student = new Student(id, name, email);
        service.addStudent(student);

        return "redirect:/add/success/student";
    }
}