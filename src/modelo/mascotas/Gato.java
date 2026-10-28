package mascotas;

public class Gato extends Mascota{
    protected boolean esDomestico;

    public Gato(String nombre, int edad, float peso, boolean esDomestico){
        super(nombre, edad, peso, nombre);
        this.esDomestico = esDomestico;
    }
}