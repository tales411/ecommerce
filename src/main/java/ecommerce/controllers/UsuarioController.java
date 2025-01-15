package ecommerce.controllers;

import ecommerce.models.Usuario;
import ecommerce.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario criarUsuario(@RequestParam String nome) {
        Usuario usuario = usuarioService.criarUsuario(nome);
        return usuario;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}
