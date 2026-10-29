package personas;

public abstract class Persona{
    protected String nombreP;
    protected String apellido;
    protected String telefono;
    protected String correo;

    public Persona(String nombreP, String apellido, String telefono, String correo){
        this.nombreP = nombreP;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombreCompleto(){
        return nombreP + " " + apellido;
    }
}