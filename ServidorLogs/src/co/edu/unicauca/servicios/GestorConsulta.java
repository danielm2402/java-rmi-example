package co.edu.unicauca.servicios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lmarango
 */
public class GestorConsulta {
    
    public List<String> getProcesosSolicitados(List<String> procesos){
        int contador = 0;
        List<String> auxProcesos = new ArrayList<>();
        procesos = filtrarOrdenarProcesos(procesos);
        for(String string : procesos){
            if(contador == 5){
                break;
            }
            auxProcesos.add(string);
            contador++;
        }
        return auxProcesos;
    }
    
    public List<String> filtrarOrdenarProcesos(List<String> procesos){
        String[] auxProcesses;
        procesos.remove(0);
        List<String> filtroProcesos = new ArrayList<>();
        for(String tmpString : procesos){
            auxProcesses = tmpString.split(",");
            filtroProcesos.add(auxProcesses[0]+","+Double.parseDouble(auxProcesses[4].split(" ")[0].split("\"")[1]));
            filtroProcesos.sort((String o1, String o2) -> {
                Double element1 = Double.parseDouble(o1.split(",")[1]);
                Double element2 = Double.parseDouble(o2.split(",")[1]);
                return element2.compareTo(element1);
            });
        }
        return filtroProcesos;
    }
}
