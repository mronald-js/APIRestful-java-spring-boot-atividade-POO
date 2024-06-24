# Documentação da API RESTful - Gerenciamento de Clientes e Produtos

## Visão Geral

Este projeto é uma API RESTful desenvolvida com Spring Boot em Java. A API permite o gerenciamento de clientes e produtos, incluindo operações de CRUD (Create, Read, Update, Delete).

## Índice

- [Visão Geral](#visão-geral)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação](#instalação)
- [Endpoints](#endpoints)
  - [Clientes](#clientes)
  - [Produtos](#produtos)
- [Código Fonte](#codigo)
  - [Models](#models)
  - [Services](#services)
  - [Controllers](#controllers)
- [Testes](#testes)
- [Exemplos do uso](#exemplos)

## Tecnologias Utilizadas

- Java 22
- Spring Boot 3.3.1
- Maven

## Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/seu-repositorio.git
    cd seu-repositorio
    ```

2. Compile e execute o projeto:
    ```sh
    ./mvnw spring-boot:run
    ```

3. Acesse a API em `http://localhost:8080`.
   
## Endpoints

### Clientes

#### Criar Cliente
- **Endpoint**: `POST /clientes`
- **Descrição**: Cria um novo cliente.
- **Corpo da Requisição**:
    ```json
    {
      "nome": "Nome do Cliente",
      "email": "email@cliente.com",
      "cpf": "123.456.789-99",
      "dataNascimento": "00-00-0000",
      "telefone": "123456789",
      "
    }
    ```
- **Resposta de Sucesso**:
    - **Código**: `201 Created`
    - **Corpo**: Detalhes do cliente criado.

#### Listar Clientes
- **Endpoint**: `GET /clientes`
- **Descrição**: Retorna uma lista de todos os clientes.
- **Resposta de Sucesso**:
    - **Código**: `200 OK`
    - **Corpo**: Lista de clientes.

#### Atualizar Cliente
- **Endpoint**: `PUT /clientes/{id}`
- **Descrição**: Atualiza as informações de um cliente existente.
- **Parâmetros**: 
    - `id` (path) - ID do cliente a ser atualizado.
- **Corpo da Requisição**:
    ```json
    {
      "nome": "Nome atualizado",
      "email": "email@atualizado.com",
      "cpf": "123.456.789-99",
      "dataNascimento": "00-00-0000",
      "telefone": "987654321",
    }
    ```
- **Resposta de Sucesso**:
    - **Código**: `200 OK`
    - **Corpo**: Detalhes do cliente atualizado.

#### Deletar Cliente
- **Endpoint**: `DELETE /clientes/{id}`
- **Descrição**: Deleta um cliente existente.
- **Parâmetros**: 
    - `id` (path) - ID do cliente a ser deletado.
- **Resposta de Sucesso**:
    - **Código**: `204 No Content`

### Produtos

#### Criar Produto
- **Endpoint**: `POST /produtos`
- **Descrição**: Cria um novo produto.
- **Corpo da Requisição**:
    ```json
    {
      "nome": "Nome do Produto",
      "descricao": "Descrição do Produto",
      "preco": 100.0
    }
    ```
- **Resposta de Sucesso**:
    - **Código**: `201 Created`
    - **Corpo**: Detalhes do produto criado.

#### Listar Produtos
- **Endpoint**: `GET /produtos`
- **Descrição**: Retorna uma lista de todos os produtos.
- **Resposta de Sucesso**:
    - **Código**: `200 OK`
    - **Corpo**: Lista de produtos.

#### Atualizar Produto
- **Endpoint**: `PUT /produtos/{id}`
- **Descrição**: Atualiza as informações de um produto existente.
- **Parâmetros**: 
    - `id` (path) - ID do produto a ser atualizado.
- **Corpo da Requisição**:
    ```json
    {
      "nome": "Nome Atualizado",
      "descricao": "Descrição Atualizada",
      "preco": 150.0
    }
    ```
- **Resposta de Sucesso**:
    - **Código**: `200 OK`
    - **Corpo**: Detalhes do produto atualizado.

#### Deletar Produto
- **Endpoint**: `DELETE /produtos/{id}`
- **Descrição**: Deleta um produto existente.
- **Parâmetros**: 
    - `id` (path) - ID do produto a ser deletado.
- **Resposta de Sucesso**:
    - **Código**: `204 No Content`

# codigo
## Models
- **Cliente**
```
package com.marcello.gerencia_clientes_produtos.Model;

public class Cliente {
    private long id;
    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public Cliente(long id, String nome, String email, String cpf, String dataNascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }
}
```
- **Produto**
```
package com.marcello.gerencia_clientes_produtos.Model;

public class Produto {
    private long id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(long id, String nome, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
```
## Services
- **Cliente**
```
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
```
Descrição: O ClienteService é um serviço responsável por gerenciar as operações relacionadas aos clientes. Ele mantém uma lista de clientes em memória e fornece métodos para realizar operações CRUD (Create, Read, Update, Delete). A seguir, uma descrição detalhada dos métodos disponíveis:

Métodos
listClients

Descrição: Retorna a lista de todos os clientes.
Retorno: List<Cliente> - uma lista de objetos Cliente.
getClientById

Descrição: Retorna um cliente específico com base no ID fornecido.
Parâmetros:
id (long): ID do cliente a ser buscado.
Retorno: Cliente - o cliente correspondente ao ID.
Exceção: Lança RuntimeException se o cliente não for encontrado.<br>
deleteClient

Descrição: Remove um cliente da lista com base no ID fornecido.
Parâmetros:
id (long): ID do cliente a ser removido.
Comportamento: Remove o cliente da lista se encontrado.
Exceção: Lança RuntimeException se o cliente não for encontrado.<br>
createClient

Descrição: Adiciona um novo cliente à lista.
Parâmetros:
cliente (Cliente): O objeto Cliente a ser adicionado.
Comportamento: Adiciona o cliente à lista de clientes.<br>
updateClient

Descrição: Atualiza as informações de um cliente existente.
Parâmetros:
id (long): ID do cliente a ser atualizado.
cliente (Cliente): O objeto Cliente contendo as novas informações.
Comportamento: Atualiza os detalhes do cliente correspondente ao ID fornecido.
Exceção: Lança RuntimeException se o cliente não for encontrado.

- **Produto**
```
package com.marcello.gerencia_clientes_produtos.Service;

import com.marcello.gerencia_clientes_produtos.Model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    public List<Produto> listProducts() {
        return produtos;
    }

    public Produto getProductById(long id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        throw new RuntimeException("Produto não encontrado");
    }

    public void deleteProduct(long id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                return;
            }
        }
        throw new RuntimeException("Produto não encontrado");
    }

    public void createProduct(Produto produto) {
        produtos.add(produto);
    }

    public void updateProduct(long id, Produto produto) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(produto.getNome());
                p.setDescricao(produto.getDescricao());
                p.setPreco(produto.getPreco());
                return;
            }
        }
        throw new RuntimeException("Produto não encontrado");
    }

}
```
Bem semelhante ao cliente, faz operações CRUD mas para produto.

## Controllers
- **Cliente**
- 
```
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
```
Descrição:
O ClienteController é um controlador REST responsável por expor endpoints para o gerenciamento de clientes. Utiliza o ClienteService para realizar operações de CRUD (Create, Read, Update, Delete) e responde às requisições HTTP.

Endpoints
GET /clientes

Descrição: Retorna a lista de todos os clientes.
Resposta de Sucesso:
Código: 200 OK
Corpo: Lista de objetos Cliente.<br>
GET /clientes/{id}

Descrição: Retorna um cliente específico com base no ID fornecido.
Parâmetros:
id (long): ID do cliente a ser buscado.
Resposta de Sucesso:
Código: 200 OK
Corpo: Objeto Cliente correspondente ao ID.
Resposta de Erro:
Código: 400 Bad Request
Corpo: Mensagem "Cliente não encontrado".<br>
DELETE /clientes/{id}

Descrição: Remove um cliente da lista com base no ID fornecido.
Parâmetros:
id (long): ID do cliente a ser removido.
Resposta de Sucesso:
Código: 200 OK
Corpo: Mensagem "Cliente deletado com sucesso".
Resposta de Erro:
Código: 400 Bad Request
Corpo: Mensagem "Cliente não encontrado".<br>
POST /clientes

Descrição: Adiciona um novo cliente à lista.
Corpo da Requisição:
Objeto Cliente: O objeto Cliente a ser adicionado.
Resposta de Sucesso:
Código: 200 OK
Corpo: Mensagem "Cliente criado com sucesso".
Resposta de Erro:
Código: 400 Bad Request
Corpo: Mensagem "Erro ao criar cliente".<br>
PUT /clientes/{id}

Descrição: Atualiza as informações de um cliente existente.
Parâmetros:
id (long): ID do cliente a ser atualizado.
Corpo da Requisição:
Objeto Cliente: O objeto Cliente contendo as novas informações.
Resposta de Sucesso:
Código: 200 OK
Corpo: Mensagem "Cliente atualizado com sucesso".
Resposta de Erro:
Código: 400 Bad Request
Corpo: Mensagem "Cliente não encontrado".
# Testes
```
@SpringBootTest
class GerenciaClientesProdutosApplicationTests {

	@Test
	void testCreateAndListClients() {
		ClienteService clienteService = new ClienteService();
		Cliente cliente = new Cliente(1, "Marcello", "marcello@example.com", "123.456.789-00", "01/01/2000", "123456789");
		clienteService.createClient(cliente);
		assertEquals(1, clienteService.listClients().size());
	}

	@Test
	void testCreateAndListProducts() {
		ProdutoService produtoService = new ProdutoService();
		Produto produto = new Produto(1, "Produto 1", "Descrição do Produto 1", 100.0);
		produtoService.createProduct(produto);
		assertEquals(1, produtoService.listProducts().size());
	}

	@Test
	void testGetClientByIdNotFound() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			ClienteService clienteService = new ClienteService();
			clienteService.getClientById(2);
		});

		assertEquals("Cliente não encontrado", exception.getMessage());
	}

	@Test
	void testDeleteClient() {
		Cliente cliente = new Cliente(1, "Cliente 1", "cliente@email.com", "12345678901", "01/01/2000", "123");
		ClienteService clienteService = new ClienteService();
		clienteService.createClient(cliente);

		clienteService.deleteClient(1);
		assertEquals(0, clienteService.listClients().size());
	}

}
```
Descrição: Testes unitários que testam se o comportamento está de acordo com o esperado

# Exemplos
Fazendo uma requisição POST que cria um cliente
![image](https://github.com/mronald-js/APIRestful-java-spring-boot-atividade-POO/assets/130300493/d1782e01-a6fd-4aa2-aa2c-f6163f3c5810)<br>
Cliente é criado:
![image](https://github.com/mronald-js/APIRestful-java-spring-boot-atividade-POO/assets/130300493/999d3b26-6a1d-44b8-83cf-e0328217907d)<br>
Visualizando Cliente após sua criação:
![image](https://github.com/mronald-js/APIRestful-java-spring-boot-atividade-POO/assets/130300493/92e1eb53-771c-4ec4-9cb8-a473926edadd)
![image](https://github.com/mronald-js/APIRestful-java-spring-boot-atividade-POO/assets/130300493/8e41d658-5273-4a24-a01f-ad863485f9a5)





