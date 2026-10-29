package mascotas;
import java.util.*;
import servicios.*;
import personas.*;

public abstract class Mascota{
    protected String nombre;
    protected int edad;
    protected float peso;
    protected Dueno dueno;
    protected LinkedList<Cita> historial = new LinkedList<>();
    protected ArrayList<Cita> agenda = new ArrayList<>();

    public Mascota(String nombre, int edad, float peso, Dueno dueno){
        this.nombre = nombre;
        setEdad(edad);
        setPeso(peso);
        this.dueno = dueno;
    }

    public abstract String getTipo();

    public abstract String getSonido();

    public void setCita(Cita cita){
        agenda.add(cita);
    }

    public Dueno getDueno(){
        return dueno;
    }

    private void setPeso(float peso) {
        if(peso >= 0){
            this.peso = peso;
            return;
        }
        System.out.println("El peso es negativo");
    }

    private void setEdad(int edad){
        if(edad >= 0){
            this.edad = edad;
            return;
        }
        System.out.println("La edad es negativa");
    }
}