package mascotas;

public class AveExotica extends Mascota{
    protected float longitudAlas;

    public AveExotica(String nombre, int edad, float peso, float longitudAlas){
        super(nombre, edad, peso, nombre);
        this.longitudAlas = longitudAlas;
    }

    void setLongitudAlas(float longitudAlas){
        if(longitudAlas >= 0){
            this.longitudAlas = longitudAlas;
            return;
        }
        System.out.println("La longitud es negativa"); 
    }
}