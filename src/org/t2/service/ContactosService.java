package org.t2.service;

import org.t2.exceptions.NotFoundException;
import org.t2.model.Contactos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactosService {
    //Creacion de un Array, se limita manualmente a 10 contactos
    ArrayList<Contactos> agenda = new ArrayList<>(10);

    // Trujillo
    public void addContacto(Contactos newContacto) {
        //Función para agregar contactos
        String name = newContacto.getNombre();
        String apellido = newContacto.getApellido();
        //Valida que la agenda no este llena y que el contacto no exista aún
        if (agendaLLena()) {
            System.out.println("Agenda llena, no se pueden agregar más contactos");
        } else if (existeContacto(name, apellido)) {
            System.out.println("Ya existe ese contacto");
        } else {
            agenda.add(newContacto);
            System.out.println("Se agrego correctamente");
        }
    }

    // Miguel
    //Funcion para devolver la lista completa de agenda
    public List<Contactos> viewAgenda() {
        return agenda;
    }

    // Miguel
    //Funcion para verificar la agenda llego a 10 contactos registrados
    public boolean agendaLLena() {
        return agenda.size() >= 10;
    }

    // Denisse
    public boolean existeContacto(String nombre, String apellido) {
        //Con un iterador recorre la lista comparando el nombre completo, ignorando mayusculas y minusculas
        Iterator<Contactos> contactoIterador = agenda.iterator();
        while (contactoIterador.hasNext()) {
            Contactos contacto = contactoIterador.next();
            String fullName = nombre + " " + apellido;
            if (contacto.fullName().equalsIgnoreCase(fullName)) {
                return true;
            }
        } return false;
    }

    // Ana Valeria
    public Contactos buscarContacto(String nombre, String apellido) {
        //Con un iterador recorre la lista comparando el nombre completo, ignorando mayusculas y minusculas
        Iterator<Contactos> contactoIterador = agenda.iterator();
            while (contactoIterador.hasNext()) {
                Contactos contacto = contactoIterador.next();
                String fullName = nombre + " " + apellido;
                if (contacto.fullName().equalsIgnoreCase(fullName)) {
                    return contacto;
                }
            }
            throw new NotFoundException("Usuario no encontrado");
    }

    // Miguel
    public void eliminarContacto(String nombre, String apellido) {
        //Función para eliminar contacto, utiliza la función buscarContacto
        Contactos eliminar = buscarContacto(nombre, apellido);
        agenda.remove(eliminar);
        System.out.println("Contacto eliminado exitosamente");
    }

    // Vale
    public Contactos modifyTelefono(String nombre, String apellido, Long nuevo) {
        //Fucnion para modificar el telefono de un contacto, busca el contacto y actualiza el telefono
        Contactos modify = buscarContacto(nombre, apellido);
        modify.setTelefono(nuevo);
        System.out.println("Contacto modificado");
        return modify;
    }

    // Vale
    public void espacioslibres() {
        //Funcion para verificar cuantos espacios libres quedan en la agenda
        int espacio = agenda.size() ;
        int x =  10 - espacio;
        if (x != 0 ){
            System.out.println("aun tienes " + x + " espacios");
        }else  {
            System.out.println("sin espacios");
        }
    }

}


