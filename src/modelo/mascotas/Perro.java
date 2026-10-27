package mascotas;

public class Perro extends Mascota{
    String raza;
    int nivelEnergia;

    Perro(String nombre, int edad, float peso, String nombreDueno, String raza, int nivelEnergia){
        super(nombre, edad, peso, nombreDueno);
        this.raza = raza;
        setNivelEnergia(nivelEnergia);
    }

    private void setNivelEnergia(int nivelEnergia) {
        if(nivelEnergia >= 0){
            this.nivelEnergia = nivelEnergia;
        }
        System.out.println("El nivel de energia es negativo");
    }
}