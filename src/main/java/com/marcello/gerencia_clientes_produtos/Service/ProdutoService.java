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
