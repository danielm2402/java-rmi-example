/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.servicios;

import servidor.utilidades.UtilidadesRegistroS;
import servidor.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidor.Repositorios.CancionRepository;
import servidor.controladores.ControladorGestionNotificacionesImpl;
import servidor.controladores.ControladorGestorSensorImpl;
import static servidor.utilidades.UtilidadesConsola.leerCadena;
import static servidor.utilidades.UtilidadesConsola.leerEntero;

public class ServidorDeObjetos {

    public static void main(String args[]) throws RemoteException {
        Conexion_cliente_servidor cliente = new Conexion_cliente_servidor();
        int numPuertoRMIRegistryServidorCanciones;
        int numPuertoServidorLogs;
        String direccionIpRMIRegistryServidorCanciones;
        String direccionIPServidorLogs;

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiRegistry servidor Alertas");
        direccionIpRMIRegistryServidorCanciones = leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiRegistry servidor Alertas");
        numPuertoRMIRegistryServidorCanciones = leerEntero();
        
        System.out.println("Ingrese La direccion IP del servidor de Logs: ");
        direccionIPServidorLogs = UtilidadesConsola.leerCadena();
        System.out.println("Ingrese el puerto de escucha: ");
        numPuertoServidorLogs = UtilidadesConsola.leerEntero();
        
        ControladorGestionNotificacionesImpl objRemotoGestionNotificaciones = new ControladorGestionNotificacionesImpl();
        cliente.ServerConnection(direccionIPServidorLogs, numPuertoServidorLogs);
        
        ControladorGestorSensorImpl objRemotoGestionSensor = new ControladorGestorSensorImpl(objRemotoGestionNotificaciones,cliente);

        try {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistryServidorCanciones);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoGestionNotificaciones, direccionIpRMIRegistryServidorCanciones, numPuertoRMIRegistryServidorCanciones, "objServicioGestionNotificaciones");
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoGestionSensor, direccionIpRMIRegistryServidorCanciones, numPuertoRMIRegistryServidorCanciones, "objServicioGestionSensores");
            
            
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }

    }

}
