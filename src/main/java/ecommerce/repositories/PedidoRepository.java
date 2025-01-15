package ecommerce.repositories;

import ecommerce.models.Pedido;
import ecommerce.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuario(Usuario usuario);
}
