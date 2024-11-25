package com.universidad.recursos;

import java.time.LocalDate;

public abstract class RecursoAcademico {
    private final String identificador;
    private String titulo;
    private LocalDate fechaCreacion;
    private String autor;
    private String categoria;

    public RecursoAcademico(String identificador, String titulo, LocalDate fechaCreacion, String autor) {
        this.identificador = isNull(identificador);
        this.titulo = isNull(titulo);
        if (fechaCreacion == null) {
            throw new IllegalArgumentException("La fecha no puede estar vacia");
        }
        this.fechaCreacion = fechaCreacion;
        this.autor = isNull(autor);
        this.categoria = null;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = isNull(titulo);
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        if (fechaCreacion == null) {
            throw new IllegalArgumentException("La fecha no puede estar vacia");
        }
        this.fechaCreacion = fechaCreacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = isNull(autor);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  "   identificador = " + identificador 
                + "\n   titulo = '" + titulo 
                + "'\n   fechaCreacion = " + fechaCreacion 
                + "\n   autor = '" + autor 
                + "'\n   categoria = '" + categoria + "'";
    }

    
    
    public final String isNull(String valor) {
        if (valor == null || valor.isEmpty()) {
            throw new IllegalArgumentException("No se admiten valores vacios");
        }
        return valor;
    }

    public abstract double calcularRelevancia();

    public abstract void mostrarDetalles();
}
