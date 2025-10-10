package com.francisco.videojuegos_examen.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.francisco.videojuegos_examen.modelos.Juego;
import com.francisco.videojuegos_examen.modelos.LoginUsuario;
import com.francisco.videojuegos_examen.modelos.Usuario;
import com.francisco.videojuegos_examen.servicios.ServicioJuegos;
import com.francisco.videojuegos_examen.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorJuegos {
    @Autowired
    private final ServicioJuegos servicioJuegos;
    private final ServicioUsuarios servicioUsuarios;
    public ControladorJuegos(ServicioJuegos servicioJuegos, ServicioUsuarios servicioUsuarios){
        this.servicioJuegos = servicioJuegos;
        this.servicioUsuarios = servicioUsuarios;
    } 
    @GetMapping("/formulario/crear/juego")
    public String crearJuego(@ModelAttribute("nuevoJuego") Juego nuevoJuego,
                            HttpSession session,
                            @ModelAttribute("loginUsuario") LoginUsuario loginUsuario){
        if(session.getAttribute("userId") == null){
            return "login";
        }
        return "formularioJuego";
    }
    @PostMapping("/procesa/formulario/juego")
    public String procesaJuego(@Valid @ModelAttribute("nuevoJuego") Juego nuevoJuego,
                                BindingResult validation,
                                HttpSession session){
        if(validation.hasErrors()){
            return "formularioJuego";
        }
        Long userId = (Long) session.getAttribute("userId");
        Usuario usuario = this.servicioUsuarios.encontrarPorId(userId);
        nuevoJuego.setUsuario(usuario);
        this.servicioJuegos.agregarJuego(nuevoJuego);
        return "redirect:/inicio";
    }

    @DeleteMapping("/juego/procesa/eliminar/{idJuego}")
    public String eliminarJuego(@PathVariable("idJuego") Long idJuego){
        this.servicioJuegos.eliminar(idJuego);
        return "redirect:/inicio";
    }

    @GetMapping("/juego/detalles/{idJuego}")
    public String detalles(@PathVariable("idJuego") Long idJuego,
                            Model model, HttpSession session,
                            @ModelAttribute("loginUsuario") LoginUsuario loginUsuario){
        if(session.getAttribute("userId") == null){
            return "login";
        }
        Juego juegoPorId = this.servicioJuegos.encontrarPorId(idJuego);
        model.addAttribute("juegoPorId", juegoPorId);
        return "detalleJuego";
    }

    @GetMapping("/juego/formulario/editar/{idJuego}")
    public String editarJuego(@PathVariable("idJuego") Long idJuego,
                                Model model,
                                HttpSession session,
                                @ModelAttribute("loginUsuario") LoginUsuario loginUsuario){
        if(session.getAttribute("userId") == null){
            return "login";
        }
        Juego juegoActual = this.servicioJuegos.encontrarPorId(idJuego);
        model.addAttribute("editarJuego", juegoActual);
        return "editarJuego";
    }
    @PutMapping("/procesa/formulario/editar/{idJuego}")
    public String procesaEditar(@PathVariable("idJuego") Long idJuego,
                                @Valid @ModelAttribute("editarJuego") Juego editarJuego,
                                BindingResult validations){
        if(validations.hasErrors()){
            return "editarJuego";
        }
        editarJuego.setId(idJuego);
        this.servicioJuegos.editarJuego(editarJuego);
        return "redirect:/inicio";
    }
}
