package personas;

public abstract class Persona{
    String nombreP;
    String apellido;
    String telefono;
    String correo;

    Persona(String nombreP, String apellido, String telefono, String correo){
        this.nombreP = nombreP;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }
}