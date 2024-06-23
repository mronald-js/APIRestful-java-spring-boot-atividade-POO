package com.marcello.gerencia_clientes_produtos;

import com.marcello.gerencia_clientes_produtos.Controller.ClienteController;
import com.marcello.gerencia_clientes_produtos.Model.Cliente;
import com.marcello.gerencia_clientes_produtos.Model.Produto;
import com.marcello.gerencia_clientes_produtos.Service.ClienteService;
import com.marcello.gerencia_clientes_produtos.Service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
