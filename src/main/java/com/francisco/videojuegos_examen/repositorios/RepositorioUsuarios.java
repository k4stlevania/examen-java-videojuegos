package com.francisco.videojuegos_examen.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.francisco.videojuegos_examen.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
    List<Usuario> findAll();
    Usuario findByCorreo(String correo);
    Usuario findByNombre(String nombre);
    Usuario save(Usuario usuario);
}
