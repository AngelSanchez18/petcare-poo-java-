package personas;
import mascotas.*;
import java.util.*;

public class Dueno extends Persona{
    protected String direccion;

    public Dueno(String nombre, String apellido, String telefono, String correo, String direccion){
        super(nombre, apellido, telefono, correo);
        this.direccion = direccion;
    }
}