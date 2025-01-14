package ecommerce.controllers;

import ecommerce.models.Usuario;
import ecommerce.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService = new UsuarioService();

    @PostMapping
    public Usuario criarUsuario(@RequestParam String nome) {
        System.out.println("Recebendo requisição para criar usuário com nome: " + nome); // Log do nome recebido
        Usuario usuario = usuarioService.criarUsuario(nome);
        System.out.println("Usuário criado: " + usuario); // Log do objeto usuário criado
        return usuario;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        System.out.println("Recebendo requisição para listar todos os usuários"); // Log ao listar usuários
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        System.out.println("Usuários encontrados: " + usuarios); // Log da lista de usuários
        return usuarios;
    }
}
