package com.example.ProjetoSpring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @NotBlank(message = "O Nome de Usuario é obrigatorio.")
    private String nome;

    @NotBlank(message = "O emial é Obrigatorio")
    @Email(message = "Informe um E-mail valido")
    private String email;

    @NotBlank(message = "A senha é Onbrigatoria")
    @Size(min = 3, message = "A senha deve conter no minimo 3 digitos")
    private String senha;

    public Usuario() {
    }

    public Usuario(String email, Long id, String nome, String senha) {
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public @NotBlank(message = "O emial é Obrigatorio") @Email(message = "Informe um E-mail valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O emial é Obrigatorio") @Email(message = "Informe um E-mail valido") String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O Nome de Usuario é obrigatorio.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O Nome de Usuario é obrigatorio.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "A saenha é Onbrigatoria") @Size(min = 3, message = "A senha deve conter no minimo 3 digitos") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A saenha é Onbrigatoria") @Size(min = 3, message = "A senha deve conter no minimo 3 digitos") String senha) {
        this.senha = senha;
    }


}
