package com.universidad.interfaces;

import com.universidad.excepciones.InvalidEvaluator;
import com.universidad.recursos.Evaluador;
import com.universidad.recursos.RecursoAcademico;


public interface Evaluable {
    
    public double obtenerPuntaje(RecursoAcademico recurso, double evaluacionNota);
    
    public void realizarEvaluacion(Evaluador evaluador, RecursoAcademico recurso) throws InvalidEvaluator;
}
