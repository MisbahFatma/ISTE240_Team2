/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.example.mind_ease.model.Resource;
import org.example.mind_ease.service.MindEaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResourceController {

    private final MindEaseService service;

    public ResourceController(MindEaseService service) {
        this.service = service;
    }

    @GetMapping("/resources")
    public String showResources(Model model) {
        model.addAttribute("resources", service.getResources());
        return "resources";
    }

    @GetMapping("/resources/add")
    public String showAddResourceForm() {
        return "add-resource";
    }

    @PostMapping("/resources/add")
    public String addResource(@RequestParam int id,
                              @RequestParam String title,
                              @RequestParam String type,
                              @RequestParam String description,
                              @RequestParam String link,
                              @RequestParam String stressLevel) {
        Resource resource = new Resource(id, title, type, description, link, stressLevel);
        service.getResources().add(resource);
        return "redirect:/add/success/resource";
    }
}