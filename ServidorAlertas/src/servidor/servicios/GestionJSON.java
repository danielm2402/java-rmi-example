package servidor.servicios;

import com.google.gson.Gson;
import servidor.DTO.SensorDTO;

public class GestionJSON {

    public static SensorDTO JsonToObject(String json) {
        Gson gson = new Gson();
        SensorDTO response = new SensorDTO();
        response = gson.fromJson(json, SensorDTO.class);
        return response;
    }
}
