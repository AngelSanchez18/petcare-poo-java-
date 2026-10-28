package centro;

public class Consultorio{
    protected String nombre;
    protected int id;
    protected Map<String, Recepcionista> personal = new HashMap<>(); 

    public Consultorio(String nombre, int id){
        this.nombre = nombre;
        setId(id);
    }

    private void setId(int id){
        if(id >= 0){
            this.id = id;
            return
        }
        System.out.println("Este id es negativo");
    }

    public setRecepcionista(String nombre, String apellido, String telefono, String correo, String turno){
        Recepcionista nuevo = new Recepcionista(nombre, apellido, telefono, correo, turno);
        personal.put(nombre, nuevo);
    }
}