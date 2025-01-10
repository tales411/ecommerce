package controllers;

import models.Produto;
import services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService = new ProdutoService();

    @PostMapping
    public Produto criarProduto(@RequestParam String nome, @RequestParam Double preco) {
        return produtoService.criarProduto(nome, preco);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}
