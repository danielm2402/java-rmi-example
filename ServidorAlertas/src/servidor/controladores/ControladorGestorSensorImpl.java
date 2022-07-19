/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.controladores;

import java.rmi.RemoteException;
import servidor.DTO.SensorDTO;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import servidor.servicios.Conexion_cliente_servidor;

/**
 *
 * @author braia
 */
public class ControladorGestorSensorImpl extends UnicastRemoteObject implements ControladorGestorSensorInt {

    private final ControladorGestionNotificacionesImpl controladorNotif;
    private final Conexion_cliente_servidor servidorLog;

    public ControladorGestorSensorImpl(ControladorGestionNotificacionesImpl controladorNotif, Conexion_cliente_servidor servidorLog) throws RemoteException {
        this.controladorNotif = controladorNotif;
        this.servidorLog = servidorLog;
    }

    @Override
    public boolean enviarIndicadorLectura(SensorDTO objSensor) throws RemoteException {
        System.out.println("Se recibio la informacion de la habitacion: " + objSensor.getNumHabitacion());
        int contarIndicadores = 0;

        if (objSensor.getIndicador().getFrecuenciaCardiaca() <= 0 || objSensor.getIndicador().getFrecuenciaRespiratoria() <= 0 || objSensor.getIndicador().getSaturacionOxigeno() <= 0 || objSensor.getIndicador().getTemperatura() <= 0 || objSensor.getIndicador().getTensionArterial().getPresionSistolica() <= 0 || objSensor.getIndicador().getTensionArterial().getPresionDiastolica() <= 0) {
            
            Date date = new Date();
          
            objSensor.setDate(date);
            this.servidorLog.peticion_respuesta(objSensor);
            //Aqui se va a llamar al cliente para conectar al servidor de logs. y tambien incluir fecha (actual del pc) capturar el errore y mandarlo,
            //servidorLog.enviarFalla("El ritmo cardiaco fallo"); //Programar Metodo

        } else {
            if (!(objSensor.getIndicador().getFrecuenciaCardiaca() >= 60 && objSensor.getIndicador().getFrecuenciaCardiaca() <= 80)) {
                contarIndicadores++;
            }
            if (!(objSensor.getIndicador().getFrecuenciaRespiratoria() >= 12 && objSensor.getIndicador().getFrecuenciaRespiratoria() <= 20)) {
                contarIndicadores++;
            }
            if (!(objSensor.getIndicador().getSaturacionOxigeno() >= 95 && objSensor.getIndicador().getSaturacionOxigeno() <= 100)) {
                contarIndicadores++;
            }
            if (!(objSensor.getIndicador().getTemperatura() >= 36.2 && objSensor.getIndicador().getTemperatura() <= 37.2)) {
                contarIndicadores++;
            }
            if (!(objSensor.getIndicador().getTensionArterial().getPresionSistolica() >= 110 && objSensor.getIndicador().getTensionArterial().getPresionSistolica() <= 140)) {
                contarIndicadores++;
            }
            if (!(objSensor.getIndicador().getTensionArterial().getPresionDiastolica() >= 70 && objSensor.getIndicador().getTensionArterial().getPresionDiastolica() <= 90)) {
                contarIndicadores++;
            }
            if (contarIndicadores >= 2) {
                controladorNotif.notificarClientes(objSensor);
            }
        }
        return true;
    }

}
