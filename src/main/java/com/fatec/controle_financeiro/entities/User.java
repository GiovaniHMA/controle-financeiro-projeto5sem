package com.fatec.controle_financeiro.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class User {

    private String nome;
    private Integer idade;

    // Construtor padrão
    public User() {

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;
 
    @NotNull(message = "A idade é obrigatória.")
    @Min(value = 0, message = "A idade não pode ser negativa.")
    private int idade;
    }

    /*public User(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }*/

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
