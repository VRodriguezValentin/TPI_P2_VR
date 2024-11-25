package com.universidad.gestores;

import com.universidad.excepciones.CategoriaInvalidaException;
import com.universidad.excepciones.InvalidEvaluator;
import com.universidad.excepciones.LimiteRecursosException;
import com.universidad.excepciones.RecursoNoEncontradoException;
import com.universidad.interfaces.*;
import com.universidad.recursos.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class GestorRecursos implements Clasificable, Evaluable{
    protected List<RecursoAcademico> recursos = new ArrayList<>();
    protected String[] categorias;

    
    @Override
    public String[] obtenerCategoriasClasificacion(RecursoAcademico recurso) throws RecursoNoEncontradoException{ //Filtra el recurso que sea y devuelve una lista de las clasificaciones posibles
        if (recurso == null) {
            throw new RecursoNoEncontradoException("El recurso no puede ser nulo");
        }
        
        if (recurso instanceof Libro) {
            return new String[]{"Programacion", "Psicologia", "Calculo", "Historia"};   
        } 
        
        if (recurso instanceof Articulo) {
            return new String[]{"Cientifico", "Tecnologico", "Historico", "Literario"};   
        } 
        
        if (recurso instanceof TrabajoInvestigacion) {
            return new String[]{"Aplicada", "Experimental", "Exploratoria", "Descriptiva"};  
        }
        
        throw new RecursoNoEncontradoException("Recurso no encontrado");
    }

    
    
    @Override
    public void asignarCategoria(RecursoAcademico recurso, String categoria) throws RecursoNoEncontradoException, CategoriaInvalidaException{ //Asigna una categoria a un recurso
        this.categorias = this.obtenerCategoriasClasificacion(recurso);
        
        for (String c : categorias) {
            
            if (c.equals(categoria)) {
                recurso.setCategoria(categoria);
                System.out.println("Categoria '" + categoria + "' asignada correctamente");
                return;
            }
        }
        throw new CategoriaInvalidaException("La categoria '" + categoria + "' es invalida para el recurso '" + recurso.getTitulo() + "'\n\tCategorias validas: " + Arrays.toString(categorias));  
    }
    
    
    
    @Override
    public void realizarEvaluacion(Evaluador evaluador, RecursoAcademico recurso) throws InvalidEvaluator{ 
        boolean evaluacionExitosa = false;
        double evaluacionNota = 2.0;
        
        switch (evaluador) {
            case ExpertoLibros:
                evaluacionExitosa = recurso instanceof Libro;
                break;
                
            case ExpertoAriculos:
                evaluacionExitosa = recurso instanceof Articulo;
                break;
                
            case ExpertoProyectosInvestigacion:
                evaluacionExitosa = recurso instanceof TrabajoInvestigacion;
                break;
                
            case ExpertoLiteriario:
                evaluacionExitosa = recurso instanceof Articulo || recurso instanceof Libro || recurso instanceof TrabajoInvestigacion;
                evaluacionNota = 3.0;
                break;
                
            case Aprendiz:
                evaluacionNota = 1.0;
                break;
                
            default:
                throw new InvalidEvaluator("Evaluador '" + evaluador + "' no admitido");
        }

        if (evaluacionExitosa) {
            System.out.println(this.obtenerPuntaje(recurso, evaluacionNota));
            
        } else {
            throw new InvalidEvaluator("El evaluador " + evaluador + " no esta capacitado para evaluar el recurso '" + recurso.getTitulo()+ "'");
        }
    }
    
    
    
        @Override
    public double obtenerPuntaje(RecursoAcademico recurso, double evaluacion) {
        
        return recurso.calcularRelevancia() * evaluacion;
    }
    
    
    
    public boolean filtrarRecurso(RecursoAcademico recurso, FiltroRecurso filtro) {
        
        return filtro.evaluar(recurso);
    }
    
    
    
    public void agregarRecurso(RecursoAcademico recurso) throws LimiteRecursosException {
        if (recursos.size() >= 3){
            throw new LimiteRecursosException("La lista de recursos esta llena");
           
        } else{
            recursos.add(recurso);
            System.out.println("Recurso '" + recurso.getTitulo() + "' agregado correctamente");
        }
    }
   
   
   
    public void removerRecurso(RecursoAcademico recurso) throws RecursoNoEncontradoException {
        if (!recursos.contains(recurso)) {
            throw new RecursoNoEncontradoException("El recurso no se encuentra en la lista de recursos");
            
        } else{
            recursos.remove(recurso);
            System.out.println("Recurso '" + recurso.getTitulo() + "' eliminado correctamente");
            
        }
    }
   
   
    public void guardarRecursos(String rutaArchivo) {
        try (FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(recursos);
            System.out.println("Recursos guardados correctamente en " + rutaArchivo);
            
        } catch (Exception e) {
            System.err.println("Problema detectado al guardar los recursos");
        }
    }
   
   
   
    public void cargarRecursos(String rutaArchivo) {
        try (FileInputStream fileIn = new FileInputStream(rutaArchivo);
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            recursos = (List<RecursoAcademico>) in.readObject();
            System.out.println("Recursos cargados correctamente en " + rutaArchivo);
        
        } catch (Exception e) {
            System.err.println("Problema detectado al cargar los recursos"); 
        }
    }

    
 
    public List<RecursoAcademico> ordenarRecursos(Comparator<RecursoAcademico> comparador) {
        
        return recursos.stream().sorted(comparador).toList();
    }
    
    
    
    public void mostrarRecursos() {
        if (recursos.isEmpty()) {
            System.out.println("No hay recursos almacenados para el informe");
            
        } else{
            System.out.println("\n\t!!!Se encontraron " + recursos.size() + " Recursos Academicos!!!\n");
        
            recursos.forEach(RecursoAcademico::mostrarDetalles);
        }  
    } 
}
