package org.t2.model;

public class Contactos {
    private String nombre;
    private String telefono;

    // Constructor
    public Contactos(String nombre, String telefono) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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

