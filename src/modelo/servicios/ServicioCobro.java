package servicios;

public abstract class ServicioCobro{
    protected static float tarifaBase = 10;
    protected float total;

    public float getTotal(){
        return total;
    }
}