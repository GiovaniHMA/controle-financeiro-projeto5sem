package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/exercicio")
public class ExercicioController {
 
    @GetMapping()
    public String HelloWorld(){
        return "Hello";
    }
 
    @GetMapping("/hello1")
    public String HelloWorld1(){
        return "Hello1";
    }
 
    //PathVarible = anotacão para definir que a variavel nome que é o tipo String será recebida pelo parametro (nome)
    @GetMapping("/reverter-nome/{nome}")
    String reverterNome (@PathVariable String nome){
        return new StringBuilder(nome).reverse().toString();
    }
 
    @GetMapping("/par-ou-impar/{numero}")
    String verificarParImpar (@PathVariable Integer numero){
        if(numero % 2 == 0){
            return "Par";
        } else {
            return "Ímpar";
        }
    }


    /*Exercício número 1 sala de aula */
    @GetMapping("/contar-letras/{texto}")
    Integer verificarQuantidade(@PathVariable String texto){
        return texto.length();
    }

     /*Exercício número 2 sala de aula */
     @GetMapping("/idade/{idade}")
     String verificarIdade(@PathVariable Integer idade){
         if (idade >=1 && idade < 12){
            return "CRIANCA";
            }
            else if (idade >= 12 && idade <= 18){
                return "ADOLESCENTE";
            }

            else if (idade >= 18 && idade < 60){
                return "ADULTO";
            }

            else if (idade >= 60){
                return "IDOSO";
            }

        else {
            return "IDADE INVÁLIDA";
        }
     }


    @PostMapping("/create-user")
        public String createUser(@RequestBody User user) {
            return "Olá, " + user.getNome() + " você tem " + user.getIdade() + " anos";
    }

    public static class User {

        private String nome;
        private Integer idade;

        public User(){
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

}

    
