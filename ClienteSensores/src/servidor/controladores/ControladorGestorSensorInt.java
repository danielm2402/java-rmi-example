

package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.SensorDTO;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorSensorInt extends Remote
{
     public boolean enviarIndicadorLectura(SensorDTO objSensor)  throws RemoteException;      
}
