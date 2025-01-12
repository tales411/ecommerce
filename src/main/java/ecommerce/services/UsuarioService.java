package ecommerce.services;

import ecommerce.models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>(); // Lista de usuários em memória
    private Long idAtual = 1L; // Gerador de IDs para usuários

    // Criar um novo usuário
    public Usuario criarUsuario(String nome) {
        Usuario usuario = new Usuario();
        usuario.setId(idAtual++);
        usuario.setNome(nome);
        usuarios.add(usuario);
        return usuario;
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}
