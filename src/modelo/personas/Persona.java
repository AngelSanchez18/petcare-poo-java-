package personas;

// Contiene los datos comunes de las personas de la clínica.
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

    public String getNombre(){
        return nombreP;
    }
}