package servicios;

// Base para los servicios que calculan un importe.
public abstract class ServicioCobro{
    protected static float tarifaBase = 10;
    protected float total;

    public float getTotal(){
        // Devuelve el precio calculado del servicio.
        return total;
    }
}