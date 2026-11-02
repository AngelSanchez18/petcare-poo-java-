package servicios;

// Calcula el costo de una vacunación.
public class Vacunacion extends ServicioCobro{
    protected float precioVacuna;

    public Vacunacion(float precioVacuna){
        // El costo suma la vacuna y la tarifa base.
        this.precioVacuna = precioVacuna;
        total = precioVacuna + tarifaBase;
    }    
}