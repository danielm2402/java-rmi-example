package servidor.servicios;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import servidor.DTO.SensorDTO;

public class Conexion_cliente_servidor {

    private String dirIpServidor = "";
    private int puertoServidor;
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;
    private Socket socket;
    private SensorDTO message;

    public void ServerConnection(String dirIP, int puerto) {
        try {
            setDirIpServidor(dirIP);
            setPuertoServidor(puerto);
            setSocket(new Socket(dirIP, puerto));
            setFlujoEntrada(new DataInputStream(getSocket().getInputStream()));
            setFlujoSalida(new DataOutputStream(getSocket().getOutputStream()));
        } catch (IOException excep) {
            excep.printStackTrace();
        }
    }

    public void peticion_respuesta(SensorDTO sensor) {
        String tmp = null;
        try {
            //NOtificacion objNotificacion=new Notificacion(indicadores con valor menor a 0);
            Gson gson = new Gson();
            String json = gson.toJson(sensor);
            flujoSalida.writeUTF(json);
            getSocket().close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getDirIpServidor() {
        return dirIpServidor;
    }

    public void setDirIpServidor(String dirIpServidor) {
        this.dirIpServidor = dirIpServidor;
    }

    public int getPuertoServidor() {
        return puertoServidor;
    }

    public void setPuertoServidor(int puertoServidor) {
        this.puertoServidor = puertoServidor;
    }

    public DataInputStream getFlujoEntrada() {
        return flujoEntrada;
    }

    public void setFlujoEntrada(DataInputStream flujoEntrada) {
        this.flujoEntrada = flujoEntrada;
    }

    public DataOutputStream getFlujoSalida() {
        return flujoSalida;
    }

    public void setFlujoSalida(DataOutputStream flujoSalida) {
        this.flujoSalida = flujoSalida;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public SensorDTO getMessage() {
        return message;
    }

    public void setMessage(SensorDTO message) {
        this.message = message;
    }
}
