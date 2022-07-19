

package cliente.controladores;

import servidor.DTO.SensorDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;


//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface NotificacionCallbackInt extends Remote
{
    public void notificarNuevaAlerta(SensorDTO objSensor) throws RemoteException;
}
