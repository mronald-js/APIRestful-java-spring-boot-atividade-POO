package com.marcello.gerencia_clientes_produtos.Controller;

import com.marcello.gerencia_clientes_produtos.Model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marcello.gerencia_clientes_produtos.Service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping //Lista todos os produtos
    public ResponseEntity<List<Produto>> listProducts() {
        return ResponseEntity.ok(produtoService.listProducts());
    }

    @GetMapping("/{id}") //Acha um produto pelo id
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(produtoService.getProductById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Produto não encontrado");
        }
    }

    @DeleteMapping("/{id}") //Deleta um produto pelo id
    public ResponseEntity<?> deleteProduct(@PathVariable long id) {
        try {
            produtoService.deleteProduct(id);
            return ResponseEntity.ok("Produto deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Produto não encontrado");
        }
    }

    @PostMapping //Cria um novo produto
    public ResponseEntity<?> createProduct(@RequestBody Produto produto) {
        try {
            produtoService.createProduct(produto);
            return ResponseEntity.ok("Produto criado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao criar produto");
        }
    }

    @PutMapping("/{id}") //Atualiza um produto pelo id
    public ResponseEntity<?> updateProduct(@PathVariable long id, @RequestBody Produto produto) {
        try {
            produtoService.updateProduct(id, produto);
            return ResponseEntity.ok("Produto atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Produto não encontrado");
        }
    }


}
