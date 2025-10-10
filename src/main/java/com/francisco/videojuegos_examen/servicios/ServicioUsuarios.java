package com.francisco.videojuegos_examen.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.francisco.videojuegos_examen.modelos.LoginUsuario;
import com.francisco.videojuegos_examen.modelos.Usuario;
import com.francisco.videojuegos_examen.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
    @Autowired
    private final RepositorioUsuarios repositorioUsuarios;
    public ServicioUsuarios(RepositorioUsuarios repositorioUsuarios){
        this.repositorioUsuarios = repositorioUsuarios;
    }

    public Usuario encontrarPorCorreo(String Correo){
        return this.repositorioUsuarios.findByCorreo(Correo);
    }
    public Usuario encontrarPorId(Long id){
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    public Usuario agregar(Usuario nuevoUsuario){
        String encrypted = BCrypt.hashpw(nuevoUsuario.getContrasena(), BCrypt.gensalt());
        nuevoUsuario.setContrasena(encrypted);
        return this.repositorioUsuarios.save(nuevoUsuario);
    }

    public BindingResult validarRegistro(BindingResult validation, Usuario usuario){
        Usuario existe = this.repositorioUsuarios.findByCorreo(usuario.getCorreo());
        if(!usuario.getContrasena().equals(usuario.getConfirmarContrasena())){
            validation.rejectValue("confirmarContrasena", "errorContrasena", "contrasenas no coinciden");
        }
        if(existe != null){
            validation.rejectValue("correo", "correoExiste", "ese correo ya esta registrado prueba con otro");
        }
        return validation;
    }

    public Usuario validarLogin(LoginUsuario loginUsuario){
        Usuario usuarioActual = this.repositorioUsuarios.findByCorreo(loginUsuario.getCorreoLogin());
        if(usuarioActual != null){
            if(BCrypt.checkpw(loginUsuario.getContrasenaLogin(), usuarioActual.getContrasena())){
                return usuarioActual;
            }
        }
        return null;
    }
}
