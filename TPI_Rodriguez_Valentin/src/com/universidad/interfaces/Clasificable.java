package com.universidad.interfaces;

import com.universidad.excepciones.CategoriaInvalidaException;
import com.universidad.excepciones.RecursoNoEncontradoException;
import com.universidad.recursos.RecursoAcademico;


public interface Clasificable {
    
    public String[] obtenerCategoriasClasificacion(RecursoAcademico recurso) throws RecursoNoEncontradoException;
    
    public void asignarCategoria(RecursoAcademico recurso, String categoria) throws RecursoNoEncontradoException, CategoriaInvalidaException;
}
