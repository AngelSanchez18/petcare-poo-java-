package servicios;

public class Cirugia extends ServicioCobro{
    protected float complejidad;
    protected int horas;

    public Cirugia(float complejidad, int horas){
        this.complejidad = complejidad;
        this.horas = horas;
        total = complejidad + tarifaBase + (horas*2);
    }
}