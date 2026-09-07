package org.t2.service;

import org.t2.exceptions.NotFoundException;
import org.t2.model.Contactos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactosService {
    ArrayList<Contactos> agenda = new ArrayList<>(10);

    public void addContacto(Contactos newContacto) {
        if (agendaLLena()) {
            System.out.println("Agenda llena, no se pueden agregar más contactos");
        } else if (existeContacto(newContacto.getNombre())) {
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

    public boolean existeContacto(String nombre) {
        Iterator<Contactos> contactoIterador = agenda.iterator();
        while (contactoIterador.hasNext()) {
            Contactos contacto = contactoIterador.next();
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;

    }

    public Contactos buscarContacto(String nombre) {
        Iterator<Contactos> contactoIterador = agenda.iterator();
        while (contactoIterador.hasNext()) {
            Contactos contacto = contactoIterador.next();
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        throw new NotFoundException("Contacto no encontrado");
    }

    public void eliminarContacto(String nombre) {
        Contactos eliminar = buscarContacto(nombre);
        agenda.remove(eliminar);
        System.out.println("Contacto eliminado exitosamente");
    }

    public Contactos modifyTelefono(String nombre, Long nuevo) {
       Contactos modify = buscarContacto(nombre);
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


