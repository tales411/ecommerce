package ecommerce.services;

import ecommerce.models.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service // Essa anotação é necessária para que o Spring gerencie a classe
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
