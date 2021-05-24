package com.juancarlos.dao.Persona;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.juancarlos.db.DBConnectionORM;
import com.juancarlos.entities.Persona;

import java.sql.SQLException;
import java.util.List;

public class DaoPersonasORM implements  DaoPersonas{
    Dao<Persona, String> daopersonasORM;

    public DaoPersonasORM() throws SQLException {
        this.daopersonasORM = DaoManager.createDao(
                DBConnectionORM.getInstance(),
                Persona.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstance(),
                daopersonasORM);
    }

    @Override
    public void add(Persona persona) {
        try {
            daopersonasORM.create(persona);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Persona> getAll() {
        try {
            return daopersonasORM.queryForAll();
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public void clear() {
        try {
            daopersonasORM.delete(getAll());
        } catch (SQLException throwables) {
        }
    }
}
