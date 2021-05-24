package com.juancarlos.dao.Tarea;

import com.juancarlos.entities.Tarea;

import java.util.List;

public interface DaoTareas {
    public void eliminar(String nombre);
    public void crear(Tarea tarea);
    public List<Tarea> getAll();
}
