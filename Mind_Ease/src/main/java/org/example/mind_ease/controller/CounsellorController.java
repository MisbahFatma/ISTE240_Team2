/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.example.mind_ease.model.Counsellor;
import org.example.mind_ease.service.MindEaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CounsellorController {

    private final MindEaseService service;

    public CounsellorController(MindEaseService service) {
        this.service = service;
    }

    // Display all counsellors
    @GetMapping("/counsellors")
    public String showCounsellors(Model model) {
        model.addAttribute("counsellors", service.getCounsellors());
        return "counsellors";
    }

    // Show form to add a new counsellor
    @GetMapping("/counsellors/add")
    public String showAddCounsellorForm() {
        return "add-counsellor";
    }

    // Handle POST request to add counsellor
    @PostMapping("/counsellors/add")
    public String addCounsellor(@RequestParam Long id,
                                @RequestParam String name,
                                @RequestParam String specialization,
                                @RequestParam String email,
                                @RequestParam String availability) {

        Counsellor counsellor = new Counsellor(id, name, specialization, email, availability);
        service.getCounsellors().add(counsellor);

        return "redirect:/add/success/counsellor";
    }
}