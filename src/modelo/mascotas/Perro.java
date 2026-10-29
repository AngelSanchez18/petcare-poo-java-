package mascotas;

import personas.Dueno;

public class Perro extends Mascota{
    protected String raza;
    protected int nivelEnergia;

    public Perro(String nombre, int edad, float peso, Dueno dueno, String raza, int nivelEnergia){
        super(nombre, edad, peso, dueno);
        this.raza = raza;
        setNivelEnergia(nivelEnergia);
    }

    @Override
    public String getTipo(){
        return "Perro";
    }

    @Override
    public String getSonido(){
        return "Ladrido";
    }

    private void setNivelEnergia(int nivelEnergia) {
        if(nivelEnergia >= 0){
            this.nivelEnergia = nivelEnergia;
            return;
        }
        System.out.println("El nivel de energia es negativo");
    }
}