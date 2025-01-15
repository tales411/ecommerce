package ecommerce.repositories;

import ecommerce.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
