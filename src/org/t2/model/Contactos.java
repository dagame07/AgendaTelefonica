package org.t2.model;

public class Contactos {
    private String nombre;
    private Long telefono;
    private String apellido;

    // Constructor
    public Contactos(String nombre, String apellido, Long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // Getter y Setter

    //Concatena nombre + apellido — se usa en varias partes del servicio para comparar contactos.
    public String fullName() { return nombre + " " + apellido;}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    // toString


    @Override
    public String toString() {
        //Para que los datos sean visibles en consola
        return "Contactos{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}

