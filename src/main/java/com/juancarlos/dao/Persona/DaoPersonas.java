package com.juancarlos.dao.Persona;

import com.juancarlos.entities.Persona;

import java.util.List;

public interface DaoPersonas {
    public void add(Persona persona);
    public List<Persona> getAll();

}
