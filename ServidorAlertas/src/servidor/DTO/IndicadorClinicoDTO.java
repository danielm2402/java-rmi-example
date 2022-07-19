/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DTO;

import java.io.Serializable;

/**
 *
 * @author braia
 */
public class IndicadorClinicoDTO implements Serializable{
    private int frecuenciaCardiaca;
    private TensionArterialDTO tensionArterial;
    private int frecuenciaRespiratoria;
    private double temperatura;
    private int saturacionOxigeno;

    public IndicadorClinicoDTO() {
    }

    public IndicadorClinicoDTO(int frecuenciaCardiaca, TensionArterialDTO tensionArterial, int frecuenciaRespiratoria, double temperatura, int saturacionOxigeno) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.tensionArterial = tensionArterial;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.temperatura = temperatura;
        this.saturacionOxigeno = saturacionOxigeno;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public TensionArterialDTO getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(TensionArterialDTO tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    public int getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(int frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getSaturacionOxigeno() {
        return saturacionOxigeno;
    }

    public void setSaturacionOxigeno(int saturacionOxigeno) {
        this.saturacionOxigeno = saturacionOxigeno;
    }
}
