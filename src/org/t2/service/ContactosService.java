package org.t2.service;

import org.t2.exceptions.NotFoundException;
import org.t2.model.Contactos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactosService {
    ArrayList<Contactos> agenda = new ArrayList<>(10);

    public void addContacto(Contactos newContacto) {
        if (agendaLLena()){
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
        while (contactoIterador.hasNext()){
            Contactos contacto = contactoIterador.next();
            if ((contacto.getNombre() == nombre)){
                return true;
            }
        }
        return false;

    }
    public Contactos buscarContacto(String nombre){
        Iterator<Contactos> contactoIterador = agenda.iterator();
        while (contactoIterador.hasNext()){
            Contactos contacto = contactoIterador.next();
           if(contacto.getNombre() == nombre){
               return contacto;
           }
        }
        throw new NotFoundException("Contacto no encontrado");
    }

}
