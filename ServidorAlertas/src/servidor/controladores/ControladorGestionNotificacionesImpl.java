package servidor.controladores;

import cliente.controladores.NotificacionCallbackInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import servidor.DTO.SensorDTO;

public class ControladorGestionNotificacionesImpl extends UnicastRemoteObject implements ControladorGestionNotificacionesInt{

    private final List<NotificacionCallbackInt> referenciasNotificaciones;
    
    public ControladorGestionNotificacionesImpl() throws RemoteException
    {
        super();
        this.referenciasNotificaciones= new ArrayList();
    }    

    @Override
    public void registrarReferenciaRemotaNotificacion(NotificacionCallbackInt objReferencia) throws RemoteException {
        this.referenciasNotificaciones.add(objReferencia);
        
    }
    
    public void notificarClientes(SensorDTO objSensor) throws RemoteException{
        for (NotificacionCallbackInt referenciasNotificacione : referenciasNotificaciones) {
            referenciasNotificacione.notificarNuevaAlerta(objSensor);
        }
    }
}
