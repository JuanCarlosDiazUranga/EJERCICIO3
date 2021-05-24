package com.juancarlos.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tareas")
@JacksonXmlRootElement(localName="tarea")
public class Tarea {
    @JacksonXmlProperty(isAttribute = true)
    @DatabaseField(id = true)
   private String nombre;
    @JacksonXmlProperty(isAttribute = true)
    @DatabaseField
   private String descripcion;
    @DatabaseField(foreign = true, columnName = "persona", canBeNull = true)
    @JacksonXmlProperty(isAttribute = true)
   private Persona persona;
    @JacksonXmlProperty(isAttribute = true)
    @DatabaseField
   private  Urgencia urgencia;

    public Tarea(String nombre, String descripcion, Persona persona, Urgencia urgencia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.persona = persona;
        this.urgencia = urgencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public Urgencia getUrgencia() {
        return urgencia;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", persona=" + persona +
                ", urgencia=" + urgencia +
                '}';
    }
}
