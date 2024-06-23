package com.marcello.gerencia_clientes_produtos.Controller;

import com.marcello.gerencia_clientes_produtos.Model.Cliente;
import com.marcello.gerencia_clientes_produtos.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping//Lista todos os clientes
    public ResponseEntity<List<Cliente>> listClients() {
        return ResponseEntity.ok(clienteService.listClients());
    }

    @GetMapping("/{id}") //Acha um cliente pelo id
    public ResponseEntity<?> getClientById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(clienteService.getClientById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Cliente não encontrado");
        }
    }

    @DeleteMapping("/{id}") //Deleta um cliente pelo id
    public ResponseEntity<?> deleteClient(@PathVariable long id) {
        try {
            clienteService.deleteClient(id);
            return ResponseEntity.ok("Cliente deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Cliente não encontrado");
        }
    }

    @PostMapping //Cria um novo cliente
    public ResponseEntity<?> createClient(@RequestBody Cliente cliente) {
        try {
            clienteService.createClient(cliente);
            return ResponseEntity.ok("Cliente criado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao criar cliente");
        }
    }

    @PutMapping("/{id}") //Atualiza um cliente pelo id
    public ResponseEntity<?> updateClient(@PathVariable long id, @RequestBody Cliente cliente) {
        try {
            clienteService.updateClient(id, cliente);
            return ResponseEntity.ok("Cliente atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Cliente não encontrado");
        }
    }

}
