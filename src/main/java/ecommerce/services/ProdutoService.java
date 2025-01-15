package ecommerce.services;

import ecommerce.models.Produto;
import ecommerce.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Criar um novo produto
    public Produto criarProduto(String nome, Double preco) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        return produtoRepository.save(produto); // Salva no banco de dados
    }

    // Listar todos os produtos
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll(); // Busca todos os produtos do banco
    }
}
