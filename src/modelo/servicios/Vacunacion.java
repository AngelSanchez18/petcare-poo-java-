package servicios;

public class Vacunacion extends ServicioCobro{
    protected float precioVacuna;

    public Vacunacion(float precioVacuna){
        this.precioVacuna = precioVacuna;
        total = precioVacuna + tarifaBase;
    }    
}