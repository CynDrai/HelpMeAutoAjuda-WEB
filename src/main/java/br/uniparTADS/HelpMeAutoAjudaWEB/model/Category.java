package br.uniparTADS.HelpMeAutoAjudaWEB.model;

public class Category {

    private Integer id_category;
    private String nomeCategoria;
    
    //Atual Instância de Categoria
    private static Category category;

    public Category () {}
    
    public Category(Integer id_category, String nomeCategoria) {
        this.id_category = id_category;
        this.nomeCategoria = nomeCategoria;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    //Atual Instância de Categoria
    public static Category getCategory() {
        return category;
    }

    public static void setCategory(Category category) {
        Category.category = category;
    }
}
