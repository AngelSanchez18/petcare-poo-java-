package personas;
import mascotas.*;
import java.util.*;

public class Dueno extends Persona{
    protected String direccion;
    //Hashmap para identificar las mascotas del dueño
    protected Map<String, Mascota> mascotas = new HashMap<>();

    // Constructor dueño 
    public Dueno(String nombre, String apellido, String telefono, String correo, String direccion){
        super(nombre, apellido, telefono, correo);
        this.direccion = direccion;
    }

    public void setAnimal(String nombre, int edad, float peso, String raza, int nivelEnergia){
        Perro nuevo = new Perro(nombre, edad, peso, nombreP, raza, nivelEnergia);
        mascotas.put(nombre, nuevo); 
    }

    public void setAnimal(String nombre, int edad, float peso, boolean esDomestico){
        Gato nuevo = new Gato(nombre, edad, peso, nombreP, esDomestico);
        mascotas.put(nombre, nuevo);
    }

    public void setAnimal(String nombre, int edad, float peso, float longitud_alas){
        AveExotica nuevo = new AveExotica(nombre, edad, peso, nombreP, longitud_alas);
        mascotas.put(nombre, nuevo);
    }
}