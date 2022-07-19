package co.edu.unicauca.modelo;

public class FabricaServidor {

    public PlantillaServidor obtenerTipoServidor(String servidorSeleccionado) {
        return new ServidorConcurrente();

    }
}
