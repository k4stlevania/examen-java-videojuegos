package com.francisco.videojuegos_examen.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Size;

@Entity
@Table(name="videojuegos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor proporciona el titulo")
    @Size(min = 5, message = "El titulo debe tener al menos 5 caracteres")
    private String titulo;

    @NotBlank(message = "Por favor proporciona el genero")
    @Size(min = 5, message = "El genero debe tener al menos 5 caracteres")
    private String genero;

    @NotBlank(message = "Por favor proporciona la plataforma")
    @Size(min=3, message = "La plataforma debe tener al menos 3 caracteres")
    private String plataforma;

    @NotBlank(message = "Por favor proporciona el desarrollador")
    @Size(min=5, message = "El desarrollador debe tener al menos 5 caracteres")
    private String desarrollador;

    @NotBlank(message = "porfavor proporciona una URL valida con la imagen")
    private String imagen;

    @NotNull(message = "Por favor proporciona la fecha")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaLanzamiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Usuario usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaCreacion;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaActualizacion;

    @PrePersist
    private void onCreate(){
        this.fechaCreacion = new Date();
        this.fechaActualizacion = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @PreUpdate
    private void onUpdate(){
        this.fechaActualizacion = new Date();
    }
}
