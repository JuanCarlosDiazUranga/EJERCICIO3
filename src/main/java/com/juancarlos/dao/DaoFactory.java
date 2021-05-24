package com.juancarlos.dao;

import com.juancarlos.dao.Persona.DaoPersonas;
import com.juancarlos.dao.Persona.DaoPersonasORM;
import com.juancarlos.dao.Persona.DaoPersonasSQL;
import com.juancarlos.dao.Tarea.DaoTareas;
import com.juancarlos.dao.Tarea.DaoTareasXML;

import java.sql.SQLException;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoPersonas daoPersonas;
    private DaoTareas daoTareas;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public DaoPersonas getDaoPersonas(Source source) {
        if (daoPersonas == null){
            if (source == Source.SQL){
                daoPersonas = new DaoPersonasSQL();
            }
            else if (source == Source.ORM){
                try {
                    daoPersonas = new DaoPersonasORM();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return daoPersonas;
    }
    public DaoTareas getDaoTareas(Source source){
        if (daoTareas == null){
            if (source == Source.XML) {
                daoTareas = new DaoTareasXML();
            }
        }
        return daoTareas;
    }
}


