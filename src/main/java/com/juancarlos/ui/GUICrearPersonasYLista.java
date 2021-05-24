package com.juancarlos.ui;

import com.juancarlos.dao.DaoFactory;
import com.juancarlos.dao.Source;
import com.juancarlos.entities.Persona;

import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import java.awt.*;
import java.util.List;

public class GUICrearPersonasYLista extends JFrame {
    private JTextField inputnombre;
    private JTextField inputtelefono;
    private JButton buttonAñadir;

    private JLabel nombre;
    private JPanel root;
    private JPanel jpanel;

    Persona persona = null;

    public GUICrearPersonasYLista(List<Persona> personas) {
        setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(root);
        jpanel.setLayout(new BoxLayout(jpanel,BoxLayout.Y_AXIS));
        listadodepersonas(personas);
        UIManager.put("OptionPane.yesButtonText", "Si");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
        setHandlers();


    }

    private GUICrearPersonasYLista setHandlers() {
        buttonAñadir.addActionListener(e -> {
            DaoFactory.getInstance().getDaoPersonas(Source.SQL).add(buildPersona());
        });
        return null;
    }





    private void listadodepersonas(List<Persona> personas) {
        DaoFactory.getInstance().getDaoPersonas(Source.SQL).getAll();
        for (int i = 0; i <personas.size() ; i++) {
             Persona persona = personas.get(i);
             JLabel nombre = new JLabel(persona.getNombre());
             JLabel telefono =new JLabel(persona.getTelefono());

             JPanel panel = new JPanel();
             panel.setLayout(new FlowLayout());
             panel.add(nombre);
             panel.add(telefono);

            jpanel.add(panel);

            buttonAñadir.addActionListener(e->{
                DaoFactory.getInstance().getDaoPersonas(Source.SQL).add(buildPersona());
            });

        }
        }




    private Persona buildPersona(){
        try {
            String nombre = inputnombre.getText();
            String telefono = inputtelefono.getText();

            persona = new Persona(nombre,telefono);
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,
                    "Error al crear la persona",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return persona;
    }

}


