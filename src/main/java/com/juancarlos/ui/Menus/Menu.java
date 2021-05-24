package com.juancarlos.ui.Menus;

import com.juancarlos.dao.DaoFactory;
import com.juancarlos.dao.Source;
import com.juancarlos.entities.Persona;
import com.juancarlos.entities.Tarea;
import com.juancarlos.ui.GUICrearPersonasYLista;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void muestraPrincipal(){
        while(true) {
            System.out.print("1) Personas\n2) Tareas\n0) Salir\nOpción: ");
            Scanner scanner = new Scanner(System.in);
            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion == 1) {
                    menupersona();     }
            else if (opcion == 2) {
                menutarea();
            }
            else if(opcion == 0){

            }
        }
    }

    public static void menupersona(){
        while(true) {
            System.out.print("1) Introducir\n2) Mostrar\n0) Eliminar\nOpción: ");
            Scanner scanner = new Scanner(System.in);
            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion == 1) {
               // introducepersona();
                List<Persona> articuloList= DaoFactory.getInstance().getDaoPersonas(Source.SQL).getAll();
                GUICrearPersonasYLista guiCrearPersonasYLista= new GUICrearPersonasYLista(articuloList);
                guiCrearPersonasYLista.setVisible(true);
            } else if (opcion == 2) {
                List<Persona> articuloList= DaoFactory.getInstance().getDaoPersonas(Source.SQL).getAll();
                GUICrearPersonasYLista guiCrearPersonasYLista= new GUICrearPersonasYLista(articuloList);
                guiCrearPersonasYLista.setVisible(true);
            }
            else if(opcion == 0){
                break;
            }
        }
    }
    private static void introducepersona(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

        Persona persona = new Persona(nombre,telefono);



        DaoFactory.getInstance().getDaoPersonas(Source.SQL).add(persona);
    }
    public static void menutarea(){
        while(true) {
            System.out.print("1) Introducir\n2) Mostrar\n0) Eliminar\nOpción: ");
            Scanner scanner = new Scanner(System.in);
            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion == 1) {
                Tarea tarea = new Tarea(null,null,null,null);
                System.out.print("A quien vas a encargar la tarea?");
                DaoFactory.getInstance().getDaoTareas(Source.XML).getAll();
                DaoFactory.getInstance().getDaoTareas(Source.XML).crear(tarea);
            }else if (opcion == 2) {
                DaoFactory.getInstance().getDaoTareas(Source.XML).getAll();
            }
            else if(opcion == 0){

            }
        }
    }
}
