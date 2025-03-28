package com.example.ProjetoSpring.controller;

import com.example.ProjetoSpring.model.Usuario;
import com.example.ProjetoSpring.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listartodos(){
           return usuarioService.listarUsuarios();
    }

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        String mensagem = "Usuario "+ usuario.getNome()+ " cadastrado com sucesso";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);

    }

    @PutMapping
    public ResponseEntity<String> atualizar(@Valid @RequestBody Usuario usuario){
        usuarioService.atualizar(usuario);
        String mensagem = "Dados de "+ usuario.getNome()+ " alterados com sucesso";
        return ResponseEntity.ok().body(mensagem);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> excluir(@PathVariable String email){
        usuarioService.excluir(email);
        return ResponseEntity.noContent().build();
    }
}
