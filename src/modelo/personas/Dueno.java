package personas;
import mascotas.*;
import java.util.*;

// Representa al propietario responsable de una mascota.
public class Dueno extends Persona{
    protected String direccion;
    protected HashMap<String, Mascota> mascotas = new HashMap<>();

    public Dueno(String nombre, String apellido, String telefono, String correo, String direccion){
        super(nombre, apellido, telefono, correo);
        this.direccion = direccion;
    }

    public void agregarMascota(Mascota mascota){
        if(mascota == null){
            throw new IllegalArgumentException("La mascota es obligatoria");
        }
        if(mascotas.containsKey(mascota.getNombre())){
            throw new IllegalArgumentException("Ya existe una mascota con ese nombre para este dueño");
        }
        mascotas.put(mascota.getNombre(), mascota);
    }

    public Mascota buscarMascota(String nombre){
        return mascotas.get(nombre);
    }

    public Collection<Mascota> getMascotas(){
        return mascotas.values();
    }

    public Mascota quitarMascota(String nombre){
        return mascotas.remove(nombre);
    }
}