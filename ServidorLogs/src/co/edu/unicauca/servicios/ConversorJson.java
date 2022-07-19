package co.edu.unicauca.servicios;

import co.edu.unicauca.dtos.SensorDTO;
import com.google.gson.Gson;

/**
 *
 * @author lmarango
 */
public class ConversorJson {
    public static String objectToJson(SensorDTO sensor){
        Gson gson = new Gson();
        String response;
        response = gson.toJson(sensor);
        return response;
    }
}
