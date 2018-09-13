package br.uniparTADS.HelpMeAutoAjudaWEB.model;

public class Usuario{
    
    private Long id_usuario;    
    private String email;
    private String nameUsr;
    private String nameFan;
    private String refSenha;
    
    //Instância do atual Usuário
    private static Usuario usuario;
    
    public Usuario() {}


    public Usuario(Long id_usuario, String email, String nameUsr, String nameFan, String refSenha) {
        this.id_usuario = id_usuario;
        this.email = email;
        this.nameUsr = nameUsr;
        this.nameFan = nameFan;
        this.refSenha = refSenha;
    }
    
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameUsr() {
        return nameUsr;
    }

    public void setNameUsr(String nameUsr) {
        this.nameUsr = nameUsr;
    }

    public String getNameFan() {
        return nameFan;
    }

    public void setNameFan(String nameFan) {
        this.nameFan = nameFan;
    }

    public String getRefSenha() {
        return refSenha;
    }

    public void setRefSenha(String refSenha) {
        this.refSenha = refSenha;
    } 

    //Instância do Usuário atual
    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Usuario.usuario = usuario;
    }
}
