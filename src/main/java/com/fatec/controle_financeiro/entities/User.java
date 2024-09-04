package com.fatec.controle_financeiro.entities;

public class User {

    private String nome;
    private Integer idade;

    // Construtor padrão
    public User() {
    }

    public User(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
