package servidor.DTO;

import java.io.Serializable;

public class CancionDTO implements Serializable
{	
    private String artista;
    private String titulo;
    private int id;
    private  String tipo;
    private int tamKB;
    private byte[] arrayBytes;

    public CancionDTO(String artista, String titulo, String tipo, int tamKB) {
        this.artista = artista;
        this.titulo = titulo;
        this.tipo = tipo;
        this.tamKB = tamKB; 
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTamKB() {
        return tamKB;
    }

    public void setTamKB(int tamKB) {
        this.tamKB = tamKB;
    }

    public byte[] getArrayBytes() {
        return arrayBytes;
    }

    public void setArrayBytes(byte[] arrayBytes) {
        this.arrayBytes = arrayBytes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
