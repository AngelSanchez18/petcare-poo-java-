package centro;
import personas.*;

public class Clinica{
    protected String nombre;
    protected Map<String, Consultorio> consultorios = new HashMap<>();
    protected Map<String, Veterinario> personal = new HashMap<>();
    protected Map<String, Dueno> clientes = new HashMap<>(); 

    public Clinica(){
        nombre = "Pet care";
    }

    public void setPersonal(String nombre, String apellido, String telefono, String correo, String especialidad){
        Veterinario nuevo = new Veterinario(nombre, apellido, telefono, correo, especialidad);
        personal.put(nombre, nuevo);
    }

    public void setConsultorio(String nombre, int id){
        Consultorio nuevo = new Consultorio(nombre, id);
        consultorios.put(nombre, nuevo);
    }

    public void setCliente(String nombre, String apellido, String telefono, String correo, String direccion){
        Cliente nuevo = new Cliente(nombre, apellido, telefono, correo, direccion);
        clientes.put(nombre, nuevo);
    }

}