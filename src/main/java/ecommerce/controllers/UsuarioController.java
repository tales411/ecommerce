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
        return usuarioService.criarUsuario(nome);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}
