package co.edu.unicauca.servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lmarango
 */
public class GestorPeticion {
    
    private GestorConsulta gestorConsulta;

    public GestorPeticion() {
        this.gestorConsulta = new GestorConsulta();
    }
    
    public List<String> getProcesos() {
        String line;
        List<String> auxProcesos = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(System.getenv("windir")+"\\system32\\"+"tasklist.exe /FO csv");
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while((line = input.readLine()) != null){
                auxProcesos.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gestorConsulta.getProcesosSolicitados(auxProcesos);
    }

    public String getDirectorioInicioUsuario() {
        return System.getProperty("user.home");
    }

    public String getNombreUsuario() {
        return System.getProperty("user.name");
    }
}
