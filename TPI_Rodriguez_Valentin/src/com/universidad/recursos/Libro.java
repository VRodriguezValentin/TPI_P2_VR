package com.universidad.recursos;

import com.universidad.excepciones.InvalidNumeroPaginas;
import java.io.Serializable;
import java.time.LocalDate;


public class Libro extends RecursoAcademico implements Serializable{
    private int numeroPaginas;
    private String editorial;

    public Libro(String identificador, String titulo, LocalDate fechaCreacion, String autor, int numeroPaginas, String editorial) throws InvalidNumeroPaginas {
        super(identificador, titulo, fechaCreacion, autor);
        if (numeroPaginas <= 0){
            throw new InvalidNumeroPaginas("El libro debe tener al menos una o mas paginas");
        }
        this.numeroPaginas = numeroPaginas;
        this.editorial = isNull(editorial);
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) throws InvalidNumeroPaginas {
        if (numeroPaginas <= 0){
            throw new InvalidNumeroPaginas("El libro debe tener al menos una o mas paginas");
        }
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = isNull(editorial);
    }
    
    
    @Override
    public double calcularRelevancia() {
        switch (this.editorial) {
            case "El Ateneo":
                return 5.0;
            case "Estrada":
                return 4.5;
            case "Santillana":
                return 3.7;
            case "Urano":
                return 2.2;
            default:
                return 1.0;
        }
    }

    @Override
    public String toString() {
        return  "\t--<Libro>--\n" + super.toString() +
                "\n   numeroPaginas = " + numeroPaginas +
                "\n   editorial = '" + editorial + "\n\t--</Libro>--\n\n";
    }

    @Override
    public void mostrarDetalles() {
        System.out.println(this);
    }
    
    public boolean esLibroDigital(){
        return this.editorial.equals("eBooks") || this.editorial.equals("TecBooks");
    }
    
}
