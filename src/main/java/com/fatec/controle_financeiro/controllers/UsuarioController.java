package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.controle_financeiro.controllers.ExercicioController.User;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @PostMapping("/register")
    public String createUser(@RequestBody User user) {
        return "Olá, " + user.getNome() + " você tem " + user.getIdade() + " anos";
    }


}