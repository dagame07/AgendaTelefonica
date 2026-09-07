package org.t2.main;

import org.t2.model.Contactos;
import org.t2.service.ContactosService;

public class AgendaMain {
    public static void main(String[] args) {
        Contactos miguel = new Contactos("Miguel Sanchez", 3123312310L);
        Contactos miguelon = new Contactos("Miguel Sachez", 31235412310L);
        Contactos miguelon1 = new Contactos("Miguel Snchez", 31235412310L);
        Contactos miguelonsiuto = new Contactos("Migue Sanchez", 31235412310L);
        Contactos miguelonson = new Contactos("Migel Sanchez", 31235412310L);
        Contactos miguelonsan = new Contactos("Miuel Sanchez", 31235412310L);
        Contactos miguelonon = new Contactos("Miguel Sancez", 31235412310L);
        Contactos miguelonchan = new Contactos("Mig Sanchez", 31235412310L);
        Contactos miguelonchin = new Contactos("Miguelon Sanchez", 31235412310L);
        Contactos miguelonchon = new Contactos("Miguelin Sanchez", 31235412310L);
        Contactos miguelonchonon = new Contactos("Miguelin Saez", 31235412310L);


        ContactosService service = new ContactosService();

        service.addContacto(miguel);

        System.out.println(service.viewAgenda());

        service.addContacto(miguelon);
        service.addContacto(miguelon1);
        service.addContacto(miguelonsiuto);
        service.addContacto(miguelonson);
        service.addContacto(miguelonsan);
        service.addContacto(miguelonon);
        service.addContacto(miguelonchan);
        service.addContacto(miguelonchin);
        service.addContacto(miguelonchon);
        service.addContacto(miguelonchonon);

        for (Contactos c : service.viewAgenda()){
            System.out.println(c);
        }

        //service.eliminarContacto("miguel Sanchez");


        service.modifyTelefono("Miguel Sanchez");
        for (Contactos c : service.viewAgenda()){
            System.out.println(c);
        }

   }
}

