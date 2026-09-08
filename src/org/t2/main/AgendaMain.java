package org.t2.main;

import org.t2.exceptions.NotFoundException;
import org.t2.model.Contactos;
import org.t2.service.ContactosService;

import java.util.Scanner;

public class AgendaMain {
    public static void main(String[] args) {
        //Se inicia el scanner
        Scanner sc = new Scanner(System.in);
        //Llamamos la clase ContactosService
        ContactosService agenda = new ContactosService();
        int opcion;

        //Iniciamos nuestro bucle, termina si el usuario teclea 0
        do {
            System.out.println("\n--- MENÚ AGENDA ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Existe contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar numero");
            System.out.println("7. Espacios libres");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Teléfono: ");
                    Long telefono = sc.nextLong();
                    sc.nextLine();
                    agenda.addContacto(new Contactos(nombre, apellido, telefono));
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    if (agenda.existeContacto(nombre, apellido)) {
                        System.out.println("Ya existe ese contacto");
                    } else {
                        System.out.println("No existe ese contacto");
                    }
                    break;

                case 3:
                    for (Contactos c : agenda.viewAgenda()){
                        System.out.println(c);
                    }
                    break;
                case 4:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    //Evitar crasheos en caso de una excepicion
                    try {
                        System.out.println(agenda.buscarContacto(nombre, apellido));
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    //Evitar crasheos en caso de una excepicion
                    try {
                        agenda.eliminarContacto(nombre, apellido);
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    //Evitar crasheos en caso de una excepicion
                    try {
                        //Busca en la lista si existe el contacto
                        agenda.buscarContacto(nombre, apellido);
                        System.out.print("Teléfono nuevo: ");
                        telefono = sc.nextLong();
                        sc.nextLine();
                        agenda.modifyTelefono(nombre, apellido, telefono);
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    /*try {
                        Contactos contactoAModificar = agenda.buscarContacto(nombre, apellido);
                        System.out.print("Teléfono nuevo: ");
                        telefono = sc.nextLong();
                        sc.nextLine();
                        contactoAModificar.setTelefono(telefono);
                        System.out.println("Contacto modificado");
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }*/

                    break;
                case 7:
                    agenda.espacioslibres();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

   }
}

