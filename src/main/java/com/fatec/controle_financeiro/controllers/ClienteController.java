package com.fatec.controle_financeiro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.controle_financeiro.entities.Cliente;


    //RestController: Indica que a classe é um controlador que retornará dados diretamente no corpo da resposta.
    @RestController
    //RequestMapping: Define a URL base que o controlador irá atender e pode especificar o método.
    @RequestMapping("/api/cliente")
    public class ClienteController {
    
        private List<Cliente> clientes = new ArrayList<>();
        private int proximoId = 1;

        @PostMapping()
        //ResponseEntity: Representar a resposta HTTP, incluindo corpo, status e cabeçalhos.
        public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
            cliente.setId(proximoId++);
            clientes.add(cliente);

            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        }

        @GetMapping()
        public ResponseEntity<List<Cliente>> getAllCliente() {

            return new ResponseEntity<>(clientes, HttpStatus.OK);
            
        }

        @GetMapping("/{id}")
        //PathVariable: Permite capturar valores de variáveis na URL da requisição.
        public ResponseEntity<Cliente> getById(@PathVariable int id) {
             
            for (Cliente cliente: clientes){
                if(cliente.getId() == id){
                
                    return new ResponseEntity<>(cliente, HttpStatus.OK);
                }   
            }
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente entity) {
           
            for (Cliente cliente: clientes){
                if(cliente.getId() == id){
                    
                    cliente.setName(entity.getName());
            

                    return new ResponseEntity<>(cliente, HttpStatus.OK);
                }   
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
           
            for (Cliente cliente: clientes){
                if(cliente.getId() == id){
                    
                    clientes.remove(cliente);

                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }   
            }
            
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}


