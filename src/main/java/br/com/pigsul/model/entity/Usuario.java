package br.com.pigsul.model.entity;

public class Usuario {

    private String email;
    private String nome;
    private String senha;
    private Integer idUsuario;

    public Usuario(String email, String nome, String senha, Integer idUsuario) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.idUsuario = idUsuario;
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
