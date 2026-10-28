package mascotas;
import java.util.*;
import servicios.*;

public abstract class Mascota{
    protected String nombre;
    protected int edad;
    protected float peso;
    protected String nombreDueno;
    protected LinkedList<ServicioCobro> historial = new LinkedList<>();

    public Mascota(String nombre, int edad, float peso, String nombreDueno){
        this.nombre = nombre;
        setEdad(edad);
        setPeso(peso);
        this.nombreDueno = nombreDueno;
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

    public addConsulta(){
        ConsultaGeneral nuevo = new ConsultaGeneral();
        historial.addFirst(nuevo);
    }

    public addConsulta(float precioVacuna){
        Vacunacion nuevo = new Vacunacion(precioVacuna);
        historial.addFirst(nuevo);
    }

    public addConsulta(float complejidad, int horas){
        Cirugia nuevo = new Cirugia(complejidad, horas);
        historial.addFirst(nuevo);
    }
}