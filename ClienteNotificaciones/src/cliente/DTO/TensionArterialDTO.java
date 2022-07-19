/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.DTO;

import java.io.Serializable;

/**
 *
 * @author braia
 */
public class TensionArterialDTO implements Serializable{
    private int presionSistolica;
    private int presionDiastolica;

    public TensionArterialDTO() {
    }

    public TensionArterialDTO(int presionSistolica, int presionDiastolica) {
        this.presionSistolica = presionSistolica;
        this.presionDiastolica = presionDiastolica;
    }

    public int getPresionSistolica() {
        return presionSistolica;
    }

    public void setPresionSistolica(int presionSistolica) {
        this.presionSistolica = presionSistolica;
    }

    public int getPresionDiastolica() {
        return presionDiastolica;
    }

    public void setPresionDiastolica(int presionDiastolica) {
        this.presionDiastolica = presionDiastolica;
    }
    
    
}
