package co.edu.unicauca.modelo;

import co.edu.unicauca.dtos.SensorDTO;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
            System.out.println("Error en el sensor de la habitacion " + objSensor.getNumHabitacion());
            objSocketCliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
