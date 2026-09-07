package org.t2.service;

import org.t2.exceptions.NotFoundException;
import org.t2.model.Contactos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactosService {
    ArrayList<Contactos> agenda = new ArrayList<>(10);

    public void addContacto(Contactos newContacto) {
        String name = newContacto.getNombre();
        String apellido = newContacto.getApellido();
        if (agendaLLena()) {
            System.out.println("Agenda llena, no se pueden agregar más contactos");
        } else if (existeContacto(name, apellido)) {
            System.out.println("Ya existe ese contacto");
        } else {
            agenda.add(newContacto);
            System.out.println("Se agrego correctamente");
        }
    }

    public List<Contactos> viewAgenda() {
        return agenda;
    }

    public boolean agendaLLena() {
        return agenda.size() >= 10;
    }

    public boolean existeContacto(String nombre, String apellido) {
        Iterator<Contactos> contactoIterador = agenda.iterator();
        while (contactoIterador.hasNext()) {
            Contactos contacto = contactoIterador.next();
            String fullName = nombre + " " + apellido;
            if (contacto.fullName().equalsIgnoreCase(fullName)) {
                return true;
            }
        }
        return false;

    }

    public Contactos buscarContacto(String nombre, String apellido) {
        Iterator<Contactos> contactoIterador = agenda.iterator();
        while (contactoIterador.hasNext()) {
            Contactos contacto = contactoIterador.next();
            String fullName = nombre + " " + apellido;
            if (contacto.fullName().equalsIgnoreCase(fullName)) {
                return contacto;
            }
        }
        throw new NotFoundException("Contacto no encontrado");
    }

    public void eliminarContacto(String nombre, String apellido) {
        Contactos eliminar = buscarContacto(nombre, apellido);
        agenda.remove(eliminar);
        System.out.println("Contacto eliminado exitosamente");
    }

    public Contactos modifyTelefono(String nombre, String apellido, Long nuevo) {
       Contactos modify = buscarContacto(nombre, apellido);
       modify.setTelefono(nuevo);
        System.out.println("Contacto modificado");
       return  null;

    }

    public void espacioslibres() {
        int espacio = agenda.size() ;
        int x =  10 - espacio;
        if (x != 0 ){
            System.out.println("aun tienes " + x + " espacios");
        }else  {
            System.out.println("sin espacios");
        }
    }

}


