package services;

import models.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>(); // Lista de produtos em memória
    private Long idAtual = 1L; // Gerador de IDs para produtos

    // Criar um novo produto
    public Produto criarProduto(String nome, Double preco) {
        Produto produto = new Produto();
        produto.setId(idAtual++);
        produto.setNome(nome);
        produto.setPreco(preco);
        produtos.add(produto);
        return produto;
    }

    // Listar todos os produtos
    public List<Produto> listarProdutos() {
        return produtos;
    }
}
