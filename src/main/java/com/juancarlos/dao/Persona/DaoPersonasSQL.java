package com.juancarlos.dao.Persona;

import com.juancarlos.db.DBConnectionSQL;
import com.juancarlos.entities.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoPersonasSQL implements  DaoPersonas{
    @Override
    public void add(Persona persona) {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            statement.execute("insert into personas(nombre,telefono) values ('" + persona.getNombre() + "','" + persona.getTelefono() +  "')");
        } catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                System.err.println("error insertar persona");
            } else {
                System.err.println(exception.getMessage());
            }
        }
    }

    @Override
    public List<Persona> getAll() {
        List<Persona> personas = new ArrayList<>();
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from personas ");
            while (resultSet.next()) {

                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");


                personas.add(new Persona(nombre,telefono));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return personas;

    }


    @Override
    public void clear() {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            statement.execute("delete from personas");
        }catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                System.err.println("error lista de personas");
            } else {
                System.err.println(exception.getMessage());
            }
        }
    }
    }

