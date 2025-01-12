package ecommerce.services;

import ecommerce.models.Pedido;
import ecommerce.models.Produto;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>(); // Lista de pedidos em memória
    private Long idAtual = 1L; // Gerador de IDs para pedidos

    // Criar um novo pedido para um usuário
    public Pedido criarPedido(Long usuarioId) {
        Pedido pedido = new Pedido();
        pedido.setId(idAtual++);
        pedido.setUsuarioId(usuarioId);
        pedidos.add(pedido);
        return pedido;
    }

    // Adicionar um produto ao pedido
    public void adicionarProdutoAoPedido(Long pedidoId, Produto produto) {
        Pedido pedido = buscarPedidoPorId(pedidoId);
        if (pedido != null) {
            pedido.adicionarProduto(produto);
        }
    }

    // Remover um produto do pedido
    public void removerProdutoDoPedido(Long pedidoId, Produto produto) {
        Pedido pedido = buscarPedidoPorId(pedidoId);
        if (pedido != null) {
            pedido.removerProduto(produto);
        }
    }

    // Listar todos os pedidos de um usuário
    public List<Pedido> listarPedidosPorUsuario(Long usuarioId) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getUsuarioId().equals(usuarioId)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    // Buscar pedido pelo ID
    private Pedido buscarPedidoPorId(Long pedidoId) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(pedidoId)) {
                return pedido;
            }
        }
        return null; // Se não encontrar, retorna null
    }
}
