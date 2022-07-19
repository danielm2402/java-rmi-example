package cliente.vista;

import cliente.utilidades.UtilidadesConsola;
import static cliente.utilidades.UtilidadesConsola.leerDecimal;
import static cliente.utilidades.UtilidadesConsola.leerEntero;
import java.rmi.RemoteException;
import servidor.DTO.IndicadorClinicoDTO;
import servidor.DTO.SensorDTO;
import servidor.DTO.TensionArterialDTO;
import servidor.controladores.ControladorGestorSensorInt;

public class Menu {

    private final ControladorGestorSensorInt objRemoto;

    public Menu(ControladorGestorSensorInt objRemoto) {
        this.objRemoto = objRemoto;
    }

    public void ejecutarMenuPrincipal() {
        SensorDTO objSensor = new SensorDTO();
        IndicadorClinicoDTO objIndicador = new IndicadorClinicoDTO();
        TensionArterialDTO objTension = new TensionArterialDTO();
        System.out.println("Digite el numero de habitacion: ");
        objSensor.setNumHabitacion(leerEntero());

        while (true) {
            try {
                System.out.println("Digite la frecuencia cardiaca: ");
                objIndicador.setFrecuenciaCardiaca(leerEntero());
                System.out.println("Digite la presion sistolica: ");
                objTension.setPresionSistolica(leerEntero());
                System.out.println("Digite la presion diastolica: ");
                objTension.setPresionDiastolica(leerEntero());
                System.out.println("Digite la frecuencia respiratoria: ");
                objIndicador.setFrecuenciaRespiratoria(leerEntero());
                System.out.println("Digite la temperatura: ");
                objIndicador.setTemperatura(leerDecimal());
                System.out.println("Digite la saturacion de oxigeno (sin porcentaje ej: 90)");
                objIndicador.setSaturacionOxigeno(leerEntero());
                objIndicador.setTensionArterial(objTension);
                objSensor.setIndicador(objIndicador);

                objRemoto.enviarIndicadorLectura(objSensor);

            } catch (Exception e) {
                System.out.println("Excepcion tal: " + e.getMessage());
            }
        }
    }
}