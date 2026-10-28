package personas;

public class Veterinario extends Persona{
    protected String especialidad;

    public Veterinario(String nombre, String apellido, String telefono, String correo, String especialidad){
        super(nombre, apellido, telefono, correo);
        this.especialidad = especialidad;
    }
}