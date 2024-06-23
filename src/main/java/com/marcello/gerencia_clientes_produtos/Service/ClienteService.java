package com.marcello.gerencia_clientes_produtos.Service;

import com.marcello.gerencia_clientes_produtos.Model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> listClients() {
        return clientes;
    }

    public Cliente getClientById(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        throw new RuntimeException("Cliente não encontrado");
    }

    public void deleteClient(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                return;
            }
        }
        throw new RuntimeException("Cliente não encontrado");
    }

    public void createClient(Cliente cliente) {
        clientes.add(cliente);
    }

    public void updateClient(long id, Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                c.setNome(cliente.getNome());
                c.setEmail(cliente.getEmail());
                c.setCpf(cliente.getCpf());
                c.setDataNascimento(cliente.getDataNascimento());
                c.setTelefone(cliente.getTelefone());
                return;
            }
        }
        throw new RuntimeException("Cliente não encontrado");
    }

}