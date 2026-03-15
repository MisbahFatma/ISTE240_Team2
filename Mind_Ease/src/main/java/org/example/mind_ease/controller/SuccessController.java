/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SuccessController {

    @GetMapping("/add/success/{entity}")
    public String showSuccess(@PathVariable String entity, Model model) {
        model.addAttribute("entity", entity);
        return "success";
    }
}