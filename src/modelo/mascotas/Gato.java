package mascotas;

import personas.Dueno;

public class Gato extends Mascota{
    protected boolean esDomestico;

    public Gato(String nombre, int edad, float peso, Dueno dueno, boolean esDomestico){
        super(nombre, edad, peso, dueno);
        this.esDomestico = esDomestico;
    }

    @Override
    public String getTipo(){
        return "Gato";
    }

    @Override
    public String getSonido(){
        return "Maullido";
    }
}