package org.t2.model;

public class Contactos {
    private String nombre;
    private Long telefono;

    // Constructor
    public Contactos(String nombre, Long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

}

