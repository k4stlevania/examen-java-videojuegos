package com.francisco.videojuegos_examen.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.videojuegos_examen.modelos.Juego;
import com.francisco.videojuegos_examen.repositorios.RepositorioJuegos;

@Service
public class ServicioJuegos {
    @Autowired
    private final RepositorioJuegos repositorioJuegos;
    
    public ServicioJuegos (RepositorioJuegos repositorioJuegos){
        this.repositorioJuegos = repositorioJuegos;
    }

    public List<Juego> obtenerTodos(){
        return this.repositorioJuegos.findAll();
    }

    public void eliminar(Long idJuego){
        this.repositorioJuegos.deleteById(idJuego);
    }

    public Juego encontrarPorId(Long id){
        return this.repositorioJuegos.findById(id).orElse(null);
    }
    public void editarJuego(Juego juego){
        this.repositorioJuegos.save(juego);
    }

    public void agregarJuego(Juego nuevoJuego){
        this.repositorioJuegos.save(nuevoJuego);
    }
}
