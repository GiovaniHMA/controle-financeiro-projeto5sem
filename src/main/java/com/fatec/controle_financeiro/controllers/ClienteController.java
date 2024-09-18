package com.fatec.controle_financeiro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.controle_financeiro.entities.Cliente;



    @RestController
    @RequestMapping("/api/cliente")
    public class ClienteController {
    
        private List<Cliente> clientes = new ArrayList<>();
        private int proximoId = 1;

        @PostMapping()
        public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
            cliente.setId(proximoId++);
            clientes.add(cliente);

            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        }
        

}


