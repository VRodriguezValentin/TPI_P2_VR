package com.universidad.prueba;

import com.universidad.excepciones.*;
import com.universidad.recursos.*;
import com.universidad.gestores.GestorRecursos;
import com.universidad.interfaces.FiltroRecurso;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;




public class UniversidadRequiriente {
    public static void main(String[] args) {
        
        try{
            LocalDate hoy = LocalDate.now();
      
            
            //Libro Test
            System.out.println("[==============]Libro[==============]\n");
            Libro libro1 = new Libro("L001", "Analisis Matematico Avanzado", hoy, "Carlos", 120, "Santillana");
            Libro libro2 = new Libro("L002", "El Nihilismo", hoy, "Felipe", 500, "Editorial X");
            //Libro libro3 = new Libro("L003", "El Libro Falso", hoy, "Pepe", 0, "Firulete");//(Descomentar para lanzar excepcion)
            
            System.out.println("Es un Libro Digital?");
            // Caso 1: No es Libro digital
            System.out.println("Caso 1 -  No es Libro digital: " + libro1.esLibroDigital()); //false
            // Caso 2: Es Libro digital
            libro1.setEditorial("eBooks");
            System.out.println("Caso 2 -  Es Libro digital: " + libro1.esLibroDigital()); //true
            
            
            System.out.println("\nCalcular Relevancia:");
            System.out.println("Relevancia Baja: " + libro1.calcularRelevancia());
            libro1.setEditorial("El Ateneo");
            System.out.println("Relevancia Alta: " + libro1.calcularRelevancia() + "\n");
            
            
            libro1.mostrarDetalles();
            
            
            
            //Articulo Test
            System.out.println("\n\n[==============]Articulo[==============]\n");
            Articulo articulo1 = new Articulo("A001", "Avances Tecnologicos", hoy, "Andres", "Paparazzi");
            
            //articulo1.setPalabrasClave(null); //(Descomentar para lanzar excepcion)
            
            
            System.out.println("Contar Palabras Clave:");
            System.out.println("Caso 1 - Lista vacia - Total Palabras Clave: " + articulo1.contarPalabrasClave());
            articulo1.setPalabrasClave(Arrays.asList("IA", "Procesador", "RAM", "SQL"));
            System.out.println("Caso 2 - Lista con datos - Total Palabras Clave: " + articulo1.contarPalabrasClave());
            
            
            System.out.println("\nCalcular Relevancia:");
            System.out.println("Relevancia Baja: " + articulo1.calcularRelevancia());
            articulo1.setRevista("Gente");
            System.out.println("Relevancia Alta: " + articulo1.calcularRelevancia() + "\n");
            
            
            articulo1.mostrarDetalles();
            
            
            
            //Trabajo de Investigacion Test
            System.out.println("\n\n[==============]Trabajo de investigacion[==============]\n");
            TrabajoInvestigacion trabajo1 = new TrabajoInvestigacion("T001", "La IA y sus beneficios", hoy, "Felipe", "Inteligencia Artificial");
            
            //trabajo1.setAutores(null); //(Descomentar para lanzar excepcion)
            
            System.out.println("Tiene financiamiento?");
            // Caso 1: Lista vacia
            System.out.println("Caso 1 - Lista vacia: " + trabajo1.tieneFinanciamiento()); // false
            // Caso 2: Lista con "Pepe" y menor a 4
            trabajo1.setAutores(Arrays.asList("Carlos", "Pepe", "Julia"));
            System.out.println("Caso 2 - Lista con Pepe y menor a 4: " + trabajo1.tieneFinanciamiento()); // true
            // Caso 3: Lista sin "Pepe" y mayor a 4
            trabajo1.setAutores(Arrays.asList("Carlos", "Julia", "Colapinto", "Messi", "David"));
            System.out.println("Caso 3 - Lista sin Pepe y mayor a 4: " + trabajo1.tieneFinanciamiento()); // true
            // Caso 4: Lista sin "Pepe" y menor a 4
            trabajo1.setAutores(Arrays.asList("Felipe", "Carlos"));
            System.out.println("Caso 4 - Lista sin Pepe y menor a 4: " + trabajo1.tieneFinanciamiento()); // false
            
            
            System.out.println("\nCalcular Relevancia:");
            System.out.println("Relevancia Alta: " + trabajo1.calcularRelevancia());
            trabajo1.setAutores(Arrays.asList("Lionel", "Nestor", "Pele"));
            System.out.println("Relevancia Baja: " + trabajo1.calcularRelevancia() + "\n");
            
            
            trabajo1.mostrarDetalles();
            
            
            
            //Gestor de Recursos Test
            System.out.println("\n\n[==============]Gestor de Recursos[==============] \n");
            GestorRecursos gestor1 = new GestorRecursos();
            
            
            System.out.println("Obtener Categorias de Clasificacion:");
            //Caso 1: Categorias Libro
            System.out.println("Categorias Libro:  " + Arrays.toString(gestor1.obtenerCategoriasClasificacion(libro1)));
            //Caso 2: Categorias Articulo
            System.out.println("Categorias Ariculo:  " + Arrays.toString(gestor1.obtenerCategoriasClasificacion(articulo1)));
            //Caso 3: Categorias TrabajoInvestigacion
            System.out.println("Categorias TrabajoInvestigacion:  " + Arrays.toString(gestor1.obtenerCategoriasClasificacion(trabajo1)) + "\n");
            
            
            System.out.println("Asignar Categoria:");
            //Caso 1: Se asigna una categoria correctamente
            gestor1.asignarCategoria(libro1, "Calculo");
            //Caso 2: Se asigna una categoria invalida (Descomentar para lanzar excepcion)
            //gestor1.asignarCategoria(libro1, "Pepe");
            
            
            //Se instancia un filtro por tipo de recurso
            FiltroRecurso filtro1 = recurso -> recurso instanceof Libro;
            
            System.out.println("Filtrar por Recurso de tipo Libro:");
            //Caso 1: Es un Libro
            System.out.println("\nCaso 1 - Es un Libro: " + gestor1.filtrarRecurso(libro1, filtro1)); //true
            //Caso 2: No es un Libro, es un articulo
            System.out.println("Caso 2 - No es un Libro: " + gestor1.filtrarRecurso(articulo1, filtro1)); //false
            
            //Se instancia un filtro por tipo de categoria
            FiltroRecurso filtro2 = recurso -> "Tecnologico".equals(recurso.getCategoria());
            
            System.out.println("Filtrar por categoria -> 'Tecnologico':");
            //Caso 1: Categoria invalida
            System.out.println("Caso 1 - Categoria invalida: " + gestor1.filtrarRecurso(articulo1, filtro2)); //false
            //Caso 2: Categoria valida
            gestor1.asignarCategoria(articulo1, "Tecnologico");
            System.out.println("Caso 2 - Categoria valida: " + gestor1.filtrarRecurso(articulo1, filtro2) + "\n"); //true
            
            
            System.out.println("Se agrega y se elimina un Recurso dela lista:");
            gestor1.agregarRecurso(libro2);
            gestor1.removerRecurso(libro2);
            System.out.println("Se carga el archivo que contiene la lista de Recursos: ");
            gestor1.cargarRecursos("recursos.ser");
            //gestor1.agregarRecurso(libro2); //(Descomentar para lanzar excepcion)
            //gestor1.removerRecurso(libro2); //(Descomentar para lanzar excepcion)
            
            
            //Ordenar Lista de Recursos por autor (A-Z)
            System.out.println("\nOrdenar Lista de Recursos por autor (A-Z):\n");
            System.out.println(gestor1.ordenarRecursos(Comparator.comparing(RecursoAcademico::getAutor)));
            
            //Ordenar Lista de Recursos por autor (Mas viejo - Mas actual)
            System.out.println("Ordenar Lista de Recursos por autor (Mas viejo - Mas actual):\n");
            articulo1.setFechaCreacion(LocalDate.parse("2024-08-01"));
            trabajo1.setFechaCreacion(LocalDate.parse("2024-01-01"));
            System.out.println(gestor1.ordenarRecursos(Comparator.comparing(RecursoAcademico::getFechaCreacion)) + "\n");
            
            
            System.out.println("Se realiza la evaluacion y se obtiene el puntaje:");
            //Caso 1: Libro evaluado por ExpertoLibros
            System.out.println("Caso 1 - Libro evaluado por ExpertoLibros: ");
            gestor1.realizarEvaluacion(Evaluador.ExpertoLibros, libro1);
            
            //Caso 2: Libro evaluado por ExpertoLiteriario
            System.out.println("Caso 2 - Libro evaluado por ExpertoLiteriario: ");
            gestor1.realizarEvaluacion(Evaluador.ExpertoLiteriario, libro1);
            
            //Caso 3: Libro evaluado por Aprendiz (Descomentar para lanzar excepcion)
            //System.out.println("Caso 3 - Libro evaluado por Aprendiz: ");
            //gestor1.realizarEvaluacion(Evaluador.Aprendiz, libro1);
            
            
            System.out.println("\nSe guarda la lista de recursos y se genera un informe de los Recursos Academicos en la lista:");
            gestor1.guardarRecursos("recursos.ser");
            gestor1.mostrarRecursos();
            
            
            
            
        } catch(CategoriaInvalidaException | InvalidListType | InvalidNumeroPaginas | 
                LimiteRecursosException | RecursoNoEncontradoException | InvalidEvaluator x){
            System.err.println("ERROR - " + x);
            
        } catch(Exception e){
            System.err.println("ERROR GENERAL - " + e);
        }
    }
}