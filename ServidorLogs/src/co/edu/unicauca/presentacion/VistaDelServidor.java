package co.edu.unicauca.presentacion;

import co.edu.unicauca.modelo.FabricaServidor;
import co.edu.unicauca.modelo.PlantillaServidor;
import java.util.Scanner;

public class VistaDelServidor {
   
    public static void main(String[] args) {
        try (Scanner objScanner = new Scanner(System.in)) {
            String tipo= "concurrente";
            int puerto=0;
            FabricaServidor fabrica = new FabricaServidor();
            //System.out.println("======== Seleccione el tipo de servidor ==========");
            //System.out.println("Digite el tipo de servidor que desea utilizar");
            //System.out.println("\nsecuencial \t concurrente");
            //tipo = objScanner.nextLine();
            System.out.println("\nDigite el puerto de escucha: ");
            puerto = objScanner.nextInt();
            PlantillaServidor objServidor = fabrica.obtenerTipoServidor(tipo);
            objServidor.inicializarServidor(puerto);
            objServidor.ejecutarServidor();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}
