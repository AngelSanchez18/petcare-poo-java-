package mascotas;

public class Gato extends Mascota{
    boolean esDomestico;

    Gato(String nombre, int edad, float peso, boolean esDomestico){
        super(nombre, edad, peso, nombre);
        this.esDomestico = esDomestico;
    }
}