package br.uniparTADS.HelpMeAutoAjudaWEB.controllers;

import br.uniparTADS.HelpMeAutoAjudaWEB.repositories.CategoryRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    //Página de Seleção de Categoria
    @GetMapping("/category")
    public String category(Model model) {
        //Lista de Categorias adicionadas na página
        model.addAttribute("categorias", categoryRepository.listCategories());
        model.addAttribute("page", "categories/selectCategory");

        return "main";
    }

    //Código de Categoria Especifíca Selecionada
    @GetMapping("/category/{id_category}")
    public String rediCategory(
            @PathVariable("id_category") Optional<Integer> idCategory) {
        
        if(idCategory.isPresent()) System.out.println("Código da Categoria -> " + idCategory.get());

        //Redirect Temporário
        return "redirect:/category";
    }
}
