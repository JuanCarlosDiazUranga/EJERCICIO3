package com.juancarlos.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "data")
public class Data {
    @JacksonXmlElementWrapper(localName = "tareas")
    @JacksonXmlProperty(localName = "tarea")
    List<Tarea> tareas;

    public Data(){}

    public Data(List<Tarea> tareas) {
        if(tareas != null) {
            this.tareas = tareas;
        }
        else this.tareas = new ArrayList<>();
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> articulos) {
        this.tareas = tareas;
    }
}
