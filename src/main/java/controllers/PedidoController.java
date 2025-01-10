package controllers;

import models.Pedido;
import models.Produto;
import services.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService = new PedidoService();

    @PostMapping
    public Pedido criarPedido(@RequestParam Long usuarioId) {
        return pedidoService.criarPedido(usuarioId);
    }

    @PostMapping("/{pedidoId}/adicionar-produto")
    public void adicionarProdutoAoPedido(@PathVariable Long pedidoId, @RequestBody Produto produto) {
        pedidoService.adicionarProdutoAoPedido(pedidoId, produto);
    }

    @PostMapping("/{pedidoId}/remover-produto")
    public void removerProdutoDoPedido(@PathVariable Long pedidoId, @RequestBody Produto produto) {
        pedidoService.removerProdutoDoPedido(pedidoId, produto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> listarPedidosPorUsuario(@PathVariable Long usuarioId) {
        return pedidoService.listarPedidosPorUsuario(usuarioId);
    }
}
