package com.juancarlos.dao.Tarea;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.juancarlos.entities.Data;
import com.juancarlos.entities.Tarea;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DaoTareasXML implements DaoTareas{
    private final String file = "tareas.xml";
    @Override
    public void eliminar(String nombre) {
        List<Tarea> tareas = getAll();
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getNombre().equals(nombre)) {
                tareas.remove(nombre);
                save(tareas);

            }
        }
    }

    @Override
    public void crear(Tarea tarea) {
        List<Tarea> tareas=getAll();
        tareas.add(tarea);
        save(tareas);
    }

    @Override
    public List<Tarea> getAll() {
        Data data = new Data(null);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(Path.of(file)));
            data = xmlMapper.readValue(xml, Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getTareas();
    }
    private void save(List<Tarea> tareas){
        Data dataContainer = new Data(tareas);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(file), dataContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
