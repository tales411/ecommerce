package ecommerce.controllers;

import ecommerce.models.Pedido;
import ecommerce.models.Produto;
import ecommerce.models.Usuario;
import ecommerce.services.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService = new PedidoService();

    @PostMapping
    public Pedido criarPedido(@RequestBody Usuario usuario) {
        // Agora recebe um objeto Usuario no corpo da requisição
        return pedidoService.criarPedido(usuario);
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
        // Cria um objeto Usuario fictício apenas para teste
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return pedidoService.listarPedidosPorUsuario(usuario);
    }
}
