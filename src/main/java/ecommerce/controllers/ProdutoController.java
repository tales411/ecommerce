package controllers;

import models.Produto;
import services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    // Construtor com injeção de dependência
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Endpoint para criar um produto
    @PostMapping
    public Produto criarProduto(@RequestParam String nome, @RequestParam Double preco) {
        return produtoService.criarProduto(nome, preco);
    }

    // Endpoint para listar todos os produtos
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}
