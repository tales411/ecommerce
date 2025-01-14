package ecommerce.services;

import ecommerce.models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>(); // Lista de usuários em memória
    private Long idAtual = 1L; // Gerador de IDs para usuários

    // Criar um novo usuário
    public Usuario criarUsuario(String nome) {
        System.out.println("Criando usuário com nome: " + nome); // Log do nome do usuário
        Usuario usuario = new Usuario();
        usuario.setId(idAtual++);
        usuario.setNome(nome);
        usuarios.add(usuario);
        System.out.println("Usuário criado e adicionado à lista: " + usuario); // Log do objeto usuário criado
        return usuario;
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        System.out.println("Listando todos os usuários"); // Log antes de listar usuários
        return usuarios;
    }
}
