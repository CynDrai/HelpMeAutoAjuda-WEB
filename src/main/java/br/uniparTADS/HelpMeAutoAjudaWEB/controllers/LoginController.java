package br.uniparTADS.HelpMeAutoAjudaWEB.controllers;

import br.uniparTADS.HelpMeAutoAjudaWEB.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    @Autowired
    private LoginRepository loginRepository;
    
    @RequestMapping("/login")
    public String login() {
        return "loginCadastro/login";
    }
   
}
