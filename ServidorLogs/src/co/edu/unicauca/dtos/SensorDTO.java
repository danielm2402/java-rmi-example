/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author braia
 */
public class SensorDTO implements Serializable{
    private int numHabitacion;
    private IndicadorClinicoDTO indicador;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public SensorDTO() {
    }
    
    public SensorDTO(int numHabitacion, IndicadorClinicoDTO indicador) {
        this.numHabitacion = numHabitacion;
        this.indicador = indicador;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public IndicadorClinicoDTO getIndicador() {
        return indicador;
    }

    public void setIndicador(IndicadorClinicoDTO indicador) {
        this.indicador = indicador;
    }
    
}
