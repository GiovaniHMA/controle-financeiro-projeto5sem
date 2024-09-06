package com.fatec.controle_financeiro.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.controle_financeiro.entities.User;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    //http://localhost:<port>/api/usuario/register
    //POST 
    //Parametro @RequestBody = > enviar no corpo da requsicao (body)
    //@PostMapping => POST - CRIACAO / CONSULTAS COM PARAMETROS NO CORPO DA REQUISICAO
    //@GetMapping => GET - CONSULTAS
    //@PutMapping -> PUT - ALTERACAO
    //@DeleteMapping -> DELETE - DELETAR
    //@PatchMapping -> PATCH - ANEXAR/ALTERAR

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        if(user.getNome() == null || user.getNome().trim().isEmpty()){
            return ResponseEntity.badRequest().body("Usuário inválido!");
        }

        if(user.getIdade() <= 0){
            return ResponseEntity.badRequest().body("idade inválida!");
        }

        return ResponseEntity.ok("Olá, seja bem-vindo! " + user.getNome() + "Você tem " + user.getIdade() + " anos");
    }


}