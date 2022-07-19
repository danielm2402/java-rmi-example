package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.Remote;
import cliente.controladores.NotificacionCallbackInt;


public interface ControladorGestionNotificacionesInt extends Remote{
   public void registrarReferenciaRemotaNotificacion(NotificacionCallbackInt objReferencia) throws RemoteException;
}
