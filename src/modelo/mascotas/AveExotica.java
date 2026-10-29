package mascotas;

import personas.Dueno;

public class AveExotica extends Mascota{
    protected float longitudAlas;

    public AveExotica(String nombre, int edad, float peso, Dueno dueno, float longitudAlas){
        super(nombre, edad, peso, dueno);
        this.longitudAlas = longitudAlas;
    }

    @Override
    public String getTipo(){
        return "Ave Exotica";
    }

    @Override
    public String getSonido(){
        return "Kakarakeo";
    }

    private void setLongitudAlas(float longitudAlas){
        if(longitudAlas >= 0){
            this.longitudAlas = longitudAlas;
            return;
        }
        System.out.println("La longitud es negativa"); 
    }
}