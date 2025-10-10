package com.francisco.videojuegos_examen.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.francisco.videojuegos_examen.modelos.Juego;

@Repository
public interface RepositorioJuegos extends CrudRepository<Juego, Long> {
    List<Juego> findAll();
    
    void deleteById(Long id);
    Juego save(Juego juego);
}
