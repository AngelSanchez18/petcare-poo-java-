package servicios;

// Calcula el costo de una cirugía según complejidad y duración.
public class Cirugia extends ServicioCobro{
    protected float complejidad;
    protected int horas;

    public Cirugia(float complejidad, int horas){
        // El costo combina tarifa base, complejidad y duración.
        this.complejidad = complejidad;
        this.horas = horas;
        total = complejidad + tarifaBase + (horas*2);
    }
}