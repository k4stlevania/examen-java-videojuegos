package com.francisco.videojuegos_examen.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUsuario{
    @NotBlank(message = "proporcion tu correo")
    @Size(min = 3, message="Nombre debe tener al menos 3 caracteres")
    private String correoLogin;

    @Size(min=8, message = "contrasena debe tener al menos 8 caracteres")
    private String contrasenaLogin;

    public LoginUsuario(){}

    public String getCorreoLogin() {
        return correoLogin;
    }

    public void setCorreoLogin(String correoLogin) {
        this.correoLogin = correoLogin;
    }

    public String getContrasenaLogin() {
        return contrasenaLogin;
    }

    public void setContrasenaLogin(String contrasenaLogin) {
        this.contrasenaLogin = contrasenaLogin;
    }
}