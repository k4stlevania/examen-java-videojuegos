package com.francisco.videojuegos_examen.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.francisco.videojuegos_examen.modelos.LoginUsuario;
import com.francisco.videojuegos_examen.modelos.Usuario;
import com.francisco.videojuegos_examen.servicios.ServicioJuegos;
import com.francisco.videojuegos_examen.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class ControladorUsuarios {
    @Autowired
    private final ServicioUsuarios servicioUsuarios;
    private final ServicioJuegos servicioJuegos;
    public ControladorUsuarios(ServicioUsuarios servicioUsuarios, ServicioJuegos servicioJuegos){
        this.servicioUsuarios = servicioUsuarios;
        this.servicioJuegos = servicioJuegos;
    }
    @GetMapping("/inicio")
    public String inicio(Model model,
                        HttpSession session,
                        @ModelAttribute("loginUsuario") LoginUsuario loginUsuario){
        if(session.getAttribute("userId") == null){
            return "login";
        }
        model.addAttribute("user", session.getAttribute("userName"));
        model.addAttribute("juegos", this.servicioJuegos.obtenerTodos());
        return "inicio";
    }
    @GetMapping("/")
    public String registrar(@ModelAttribute("nuevoUsuario") Usuario nuevUsuario){
        return "usuarioFormulario";        
    }
    @PostMapping("/usuarios/procesa/formulario")
    public String procesaFormulario(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
                                    BindingResult validations,
                                    HttpSession session,
                                    @ModelAttribute("loginUsuario") LoginUsuario loginUsuario){
        validations = this.servicioUsuarios.validarRegistro(validations, nuevoUsuario);
        if(validations.hasErrors()){
            return "usuarioFormulario";
        }
        this.servicioUsuarios.agregar(nuevoUsuario);
        session.setAttribute("userName", this.servicioUsuarios.encontrarPorCorreo(nuevoUsuario.getCorreo()));
        session.setAttribute("userId", nuevoUsuario.getId());
        return "redirect:/inicio";
    }

    // Login
    @GetMapping("/login")
    public String login(@ModelAttribute("loginUsuario") LoginUsuario loginUsuario) {
        return "login";
    }
    @PostMapping("/usuarios/procesa/login")
    public String procesaLogin(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
                                BindingResult validations,
                                HttpSession session){
        Usuario existe = this.servicioUsuarios.validarLogin(loginUsuario);
        if(existe == null){
            validations.rejectValue("contrasenaLogin", "errorLogin", "credenciales incorrectas");
        }
        if(validations.hasErrors()){
            return "login";
        }
        session.setAttribute("userName", this.servicioUsuarios.encontrarPorCorreo(loginUsuario.getCorreoLogin()));
        session.setAttribute("userId", existe.getId());
        return "redirect:/inicio";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
    
}
