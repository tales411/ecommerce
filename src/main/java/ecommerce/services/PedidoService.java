package ecommerce.services;

import ecommerce.models.Pedido;
import ecommerce.models.Produto;
import ecommerce.models.Usuario;
import ecommerce.repositories.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional // Gerencia transações automaticamente
    public Pedido criarPedido(Usuario usuario) {
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        return pedidoRepository.save(pedido); // Salva o pedido no banco de dados
    }

    @Transactional
    public void adicionarProdutoAoPedido(Long pedidoId, Produto produto) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElse(null);
        if (pedido != null) {
            pedido.adicionarProduto(produto);
            pedidoRepository.save(pedido); // Atualiza o pedido no banco de dados
        }
    }

    @Transactional
    public void removerProdutoDoPedido(Long pedidoId, Produto produto) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElse(null);
        if (pedido != null) {
            pedido.removerProduto(produto);
            pedidoRepository.save(pedido); // Atualiza o pedido no banco de dados
        }
    }

    @Transactional(readOnly = true)
    public List<Pedido> listarPedidosPorUsuario(Usuario usuario) {
        return pedidoRepository.findByUsuario(usuario);
    }
}
