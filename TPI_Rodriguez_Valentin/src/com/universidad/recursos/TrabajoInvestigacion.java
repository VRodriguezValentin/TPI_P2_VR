package com.universidad.recursos;

import com.universidad.excepciones.InvalidListType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrabajoInvestigacion extends RecursoAcademico{
    protected List<String> autores;
    private String lineaInvestigacion;

    public TrabajoInvestigacion(String identificador, String titulo, LocalDate fechaCreacion, String autor, String lineaInvestigacion) {
        super(identificador, titulo, fechaCreacion, autor);
        this.autores = new ArrayList<>();
        this.lineaInvestigacion = isNull(lineaInvestigacion);
    }

    public List<String> getAutores() {
        return new ArrayList<>(autores);
    }

    public void setAutores(List<String> autores) throws InvalidListType {
        if (autores == null) {
            throw new InvalidListType("La lista no puede ser nula");
        }
        this.autores = new ArrayList<>(autores);
    }

    public String getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(String lineaInvestigacion) {
        this.lineaInvestigacion = isNull(lineaInvestigacion);
    }


    @Override
    public double calcularRelevancia() {
        
        if (!autores.isEmpty()) {
            for (String autor : autores) {
                if (autor.equals(this.getAutor())) {
                    return 5.0;
                } else if (autor.equals("Carlos")) {
                    return 4.3;
                } else if (autor.equals("Felipe")) {
                    return 3.6;
                } else if (autor.equals("Einstein")) {
                    return 2.1;
                }
            }
            return 1.0;
        }
        return 0.0;
    }
    
    @Override
    public String toString() {
        return  "\t--<TrabajoInvestigacion>--\n" + super.toString() +
                "\n   autores= " + autores +
                "\n   lineaInvestigacion= '" + lineaInvestigacion + "'\n\t--</TrabajoInvestigacion>--\n\n";
    }

    @Override
    public void mostrarDetalles() {
        System.out.println(this);
    }
    
    public boolean tieneFinanciamiento() {
        return this.autores.size() > 4 || this.autores.contains("Pepe");
    }
    
}
