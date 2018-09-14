package br.uniparTADS.HelpMeAutoAjudaWEB.controllers;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import br.uniparTADS.HelpMeAutoAjudaWEB.repositories.LoginRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;
    
    private String tmpMsg;

    //Página Login
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new Usuario());
        model.addAttribute("page", "loginCadastro/login");
        model.addAttribute("msgError", tmpMsg);
        tmpMsg = null;
        return "main";
    }
    
    //Select Banco de dados
    @PostMapping({"/login", "/login/{id_usuario}"})
    public String findLogin(@PathVariable("id_usuario") Optional<Long> codigo, Usuario usuario) {
        tmpMsg = loginRepository.findLogin(usuario);
                        
        return "redirect:/category";
    }

    //Página Cadastro
    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("cadastro", new Usuario());
        model.addAttribute("page", "loginCadastro/cadastro");
        model.addAttribute("msgError", tmpMsg);
        tmpMsg = null;
        return "main";
    }

    //Insert Banco de dados
    @PostMapping({"/cadastro", "/cadastro/{id_usuario}"})
    public String grava(@PathVariable("id_usuario") Optional<Long> codigo, Usuario usuario) {
        tmpMsg = loginRepository.save(usuario);

        if (!tmpMsg.equals("*Cadastro feito com sucesso!")) {
  
            return "redirect:/cadastro";
        }
        
        return "redirect:/login";
    }

}
