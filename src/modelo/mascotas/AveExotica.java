package mascotas;

public class AveExotica extends Mascota{
    float longitudAlas;

    AveExotica(String nombre, int edad, float peso, float longitudAlas){
        super(nombre, edad, peso, nombre);
        this.longitudAlas = longitudAlas;
    }
}