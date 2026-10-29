package personas;

public class Recepcionista extends Persona{
    protected String turno;

    public Recepcionista(String nombre, String apellido, String telefono, String correo, String turno){
        super(nombre, apellido, telefono, correo);
        this.turno = turno;
    }
}