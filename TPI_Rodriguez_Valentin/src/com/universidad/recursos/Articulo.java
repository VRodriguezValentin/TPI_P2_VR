package com.universidad.recursos;

import com.universidad.excepciones.InvalidListType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Articulo extends RecursoAcademico implements Serializable{
    protected List<String> palabrasClave;
    private String revista;

    public Articulo(String identificador, String titulo, LocalDate fechaCreacion, String autor, String revista) {
        super(identificador, titulo, fechaCreacion, autor);
        this.palabrasClave = new ArrayList<>();
        this.revista = isNull(revista);
    }

    public List<String> getPalabrasClave() {
        return new ArrayList<>(this.palabrasClave);
    }

    public void setPalabrasClave(List<String> palabrasClave) throws InvalidListType {
        if (palabrasClave == null) {
            throw new InvalidListType("La lista no puede ser nula");
        }
        this.palabrasClave = new ArrayList<>(palabrasClave);
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = isNull(revista);
    }
    

    @Override
    public double calcularRelevancia() {
        switch (this.revista) {
            case "Gente":
                return 5.0;
            case "Caras":
                return 4.2;
            case "Noticias":
                return 3.5;
            case "Paparazzi":
                return 2.3;
            default:
                return 1.0;
        }
    }

    @Override
    public String toString() {
        return "\t--<Articulo>--\n" + super.toString() +
                "\n   palabrasClave = " + palabrasClave +
                "\n   revista = '" + revista + "'\n\t--</Articulo>--\n\n";
    }

    @Override
    public void mostrarDetalles() {
        System.out.println(this);
    }
    
    public int contarPalabrasClave() {
        return this.palabrasClave.size();
    }
    
}
