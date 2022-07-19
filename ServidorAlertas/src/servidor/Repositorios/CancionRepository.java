package servidor.Repositorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import servidor.DTO.CancionDTO;


public class CancionRepository implements CancionRepositoryInt
{  
    private final ArrayList<CancionDTO> listaCanciones;
    
    public CancionRepository()
    {
        this.listaCanciones= new ArrayList();
    }

    private boolean almacenarArchivo(byte array[])
    {
        boolean bandera=true;
        try {
            File objFile= new File("misCanciones/cancion_" + (this.listaCanciones.size() + 1) + ".mp3");// archivo donde se almacenara la canción
            OutputStream output= new FileOutputStream(objFile);
            output.write(array);// escribiendo la canción en el archivo
            } catch (FileNotFoundException ex) {
            bandera=false;
        } catch (IOException ex) {
             bandera=false;
        }
        
        return bandera;
    }
   
    @Override
    public boolean registrarCancion(CancionDTO objCancion) {
        
        boolean bandera;
        objCancion.setId(this.listaCanciones.size() + 1);
        bandera=this.almacenarArchivo(objCancion.getArrayBytes());
        this.listaCanciones.add(objCancion);
        System.out.println("Archivo creado en el servidor");
        System.out.println("Metadatos del archivo: ");
        System.out.println("titulo: " + objCancion.getTitulo());
        System.out.println("Artista: " + objCancion.getArtista());
        System.out.println("tamaño en KB: " + objCancion.getTamKB());
        return bandera;
    }
    
    public ArrayList<CancionDTO> listarCanciones()
    {
        return this.listaCanciones;
    }
       
}
