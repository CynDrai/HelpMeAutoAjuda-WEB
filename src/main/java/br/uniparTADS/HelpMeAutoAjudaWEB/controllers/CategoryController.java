package br.uniparTADS.HelpMeAutoAjudaWEB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    
    @RequestMapping("/category")
    public String categoria(Model model) {
        model.addAttribute("page", "categories/selectCategory");
        
        return "main";
    }
    
}