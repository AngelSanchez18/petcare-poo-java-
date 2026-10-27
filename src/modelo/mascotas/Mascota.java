package mascotas;

public abstract class Mascota{
    String nombre;
    int edad;
    float peso;
    String nombreDueno;

    Mascota(String nombre, int edad, float peso, String nombreDueno){
        this.nombre = nombre;
        setEdad(edad);
        setPeso(peso);
        this.nombreDueno = nombreDueno;
    }

    private void setPeso(float peso) {
        if(peso >= 0){
            this.peso = peso;
        }
        System.out.println("El peso es negativo");
    }

    private void setEdad(int edad){
        if(edad >= 0){
            this.edad = edad;
        }
        System.out.println("La edad es negativa");
    }
}