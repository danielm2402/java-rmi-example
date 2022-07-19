package co.edu.unicauca.modelo;

public class ServidorConcurrente extends PlantillaServidor{

    public ServidorConcurrente() {}
    
    @Override
    public void atenderPeticiones() {
        try {            
            while (true) {
                System.out.println("id del hilo principal:"+Thread.currentThread().getId());
                this.objsocket=objservidor.accept();
                System.out.println("Cliente conectado");
                new GestorDeHilo(this.objsocket).start();
            }
        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }
    
}
