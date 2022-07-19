package cliente.servicios;


import cliente.controladores.NotificacionCallbackImpl;
import cliente.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import cliente.controladores.NotificacionCallbackInt;
import servidor.controladores.ControladorGestionNotificacionesInt;


public class ClienteDeObjetos
{

	private static ControladorGestionNotificacionesInt objRemoto;
        
	public static void main(String[] args) throws RemoteException 
        {           
            int numPuertoRMIRegistry = 0;
            String direccionIpRMIRegistry = "";        
               
            System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry para el Cliente de Notificaciones");
            direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
            System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry para el Cliente de Notificaciones");
            numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero(); 
           
            objRemoto = (ControladorGestionNotificacionesInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,numPuertoRMIRegistry, "objServicioGestionNotificaciones");
                
            NotificacionCallbackImpl objRemotoNotif= new NotificacionCallbackImpl();
            
            objRemoto.registrarReferenciaRemotaNotificacion(objRemotoNotif);
            
            System.out.println("Esperando notificaciones ...");
	}		
}

