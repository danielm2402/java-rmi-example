package co.edu.unicauca.modelo;

import co.edu.unicauca.dtos.SensorDTO;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class GestorDeHilo extends Thread {

    private Socket objSocketCliente;

    public GestorDeHilo(Socket objSocket) {
        this.objSocketCliente = objSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("id del hilo generado:" + Thread.currentThread().getId());
            System.out.println("Atendiendo hilo de cliente");
            DataInputStream flujoEntrada;
            DataOutputStream flujoSalida;
            String message;
            flujoEntrada = new DataInputStream(objSocketCliente.getInputStream());
            flujoSalida = new DataOutputStream(objSocketCliente.getOutputStream());
            message = flujoEntrada.readUTF();//se bloquea el servidor
            SensorDTO objSensor = new SensorDTO();
            Gson gson = new Gson();
            objSensor = gson.fromJson(message, objSensor.getClass());
            System.out.println(" El paciente en la habitación: " + objSensor.getNumHabitacion()+ "Presenta indicadores fuera de rango en la fecha: " + objSensor.getDate());
            validarIndicadores(objSensor);
            objSocketCliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void validarIndicadores(SensorDTO objSensor){
       
        if (objSensor.getIndicador().getFrecuenciaCardiaca() <= 0) {
            
           System.out.println("Frecuencia cardiaca: "+ objSensor.getIndicador().getFrecuenciaCardiaca());
        }
        if(objSensor.getIndicador().getFrecuenciaRespiratoria() <= 0){
            System.out.println("Frecuencia Respiratoria: "+ objSensor.getIndicador().getFrecuenciaRespiratoria());
        }
        if(objSensor.getIndicador().getSaturacionOxigeno() <= 0){
            System.out.println("Saturación de oxigeno: "+ objSensor.getIndicador().getSaturacionOxigeno());
        }
        if(objSensor.getIndicador().getTemperatura() <= 0){
            System.out.println("Temperatura: " + objSensor.getIndicador().getTemperatura());
        }
        if(objSensor.getIndicador().getTensionArterial().getPresionSistolica() <= 0){
            System.out.println("Presión Sistolica: " + objSensor.getIndicador().getTensionArterial().getPresionSistolica());
        }
        if(objSensor.getIndicador().getTensionArterial().getPresionDiastolica() <= 0){
            System.out.println("Presión Diastolica: " + objSensor.getIndicador().getTensionArterial().getPresionDiastolica());
        }
        
       
    }
}
