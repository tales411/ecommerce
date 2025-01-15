package ecommerce.services;

import ecommerce.models.Usuario;
import ecommerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    // Injeção de dependência via construtor
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Criar um novo usuário
    public Usuario criarUsuario(String nome) {
        System.out.println("Criando usuário com nome: " + nome); // Log do nome do usuário
        Usuario usuario = new Usuario(nome);
        return usuarioRepository.save(usuario); // Salva o usuário no banco de dados
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        System.out.println("Listando todos os usuários"); // Log antes de listar usuários
        return usuarioRepository.findAll(); // Busca todos os usuários do banco de dados
    }
}
