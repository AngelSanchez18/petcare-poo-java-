package centro;
import personas.*;
import servicios.*;
import java.util.*;

public class Consultorio{
    protected String nombre;
    protected int id;
    protected Map<String, Recepcionista> personal = new HashMap<>(); 
    protected Map<String, Cita> citas = new HashMap<>();

    public Consultorio(String nombre, int id){
        this.nombre = nombre;
        setId(id);
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    private void setId(int id){
        if(id >= 0){
            this.id = id;
            return;
        }
        System.out.println("Este id es negativo");
    }

    public void setRecepcionista(String nombre, String apellido, String telefono, String correo, String turno){
        Recepcionista nuevo = new Recepcionista(nombre, apellido, telefono, correo, turno);
        personal.put(nombre, nuevo);
    }

    public void agregarRecepcionista(Recepcionista recepcionista){
        if(recepcionista == null){
            throw new IllegalArgumentException("La recepcionista es obligatoria");
        }
        personal.put(recepcionista.getNombreCompleto(), recepcionista);
    }
}