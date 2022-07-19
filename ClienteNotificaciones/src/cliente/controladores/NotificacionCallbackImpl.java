package cliente.controladores;

import cliente.DTO.SensorDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class NotificacionCallbackImpl extends UnicastRemoteObject implements NotificacionCallbackInt{

   public NotificacionCallbackImpl() throws RemoteException
   {
       super();
   }

   @Override
   public void notificarNuevaAlerta(SensorDTO objSensor) throws RemoteException {
       System.out.println(objSensor);
   }
}
