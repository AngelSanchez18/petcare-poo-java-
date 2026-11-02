package mascotas;
import java.util.*;
import servicios.*;
import personas.*;

// Define los datos y operaciones comunes de las mascotas.
public abstract class Mascota{
    protected String nombre;
    protected int edad;
    protected float peso;
    protected Dueno dueno;
    protected LinkedList<Cita> historial = new LinkedList<>();
    protected ArrayList<Cita> agenda = new ArrayList<>();

    public Mascota(String nombre, int edad, float peso, Dueno dueno){
        this.nombre = nombre;
        setEdad(edad);
        setPeso(peso);
        this.dueno = dueno;
    }

    public String getNombre(){
        return nombre;
    }

    public abstract String getTipo();

    public abstract String getSonido();

    public void printCitas(){
        // Muestra las citas pendientes de la mascota.
        int i = 1;
        System.out.println("Citas de " + nombre);
        for(Cita cita : agenda){
            System.out.println(i + ". Cita: " + cita.getFecha());
            i++;
        }
    }

    public void setCita(Cita cita){
        agenda.add(cita);
    }

    public Dueno getDueno(){
        return dueno;
    }

    public void asignarDueno(Dueno dueno){
        if(dueno == null){
            throw new IllegalArgumentException("El dueño es obligatorio");
        }
        this.dueno = dueno;
    }

    private void setPeso(float peso) {
        if(peso >= 0){
            this.peso = peso;
            return;
        }
        System.out.println("El peso es negativo");
    }

    private void setEdad(int edad){
        if(edad >= 0){
            this.edad = edad;
            return;
        }
        System.out.println("La edad es negativa");
    }

    public int getAgendaSize(){
        return agenda.size();
    }

    public void atenderCita(int opt){
        // Atiende una cita y la mueve al historial.
        if(opt >= 0 && opt < agenda.size()){
            Cita cita = agenda.get(opt);
            cita.atenderCita();
            agenda.remove(cita);
            historial.add(cita);
            return;
        }
        System.out.println("Opcion no valida");
    }

    public void cancelarCita(int opt){
        // Cancela una cita y conserva el registro en el historial.
        if(opt >= 0 && opt < agenda.size()){
            Cita cita = agenda.get(opt);
            cita.cancelarCita();
            agenda.remove(cita);
            historial.add(cita);
            return;
        }
        System.out.println("Opcion no valida");
    }

    public void printHistorial(){
        // Muestra las citas finalizadas o canceladas.
        System.out.println("Historial de " + nombre);
        if(historial.isEmpty()){
            System.out.println("La mascota no tiene historial");
            return;
        }
        for(int i = 0; i < historial.size(); i++){
            Cita cita = historial.get(i);
            System.out.println((i + 1) + ". " + cita.getFecha()
                + " - " + cita.getEstado() + " - " + cita.getTotal());
        }
    }

    public int getHistorialSize(){
        return historial.size();
    }

    public void generarComprobante(int opcion){
        // Genera el comprobante de una cita del historial.
        if(opcion < 1 || opcion > historial.size()){
            System.out.println("Opcion no valida");
            return;
        }
        historial.get(opcion - 1).generarComprobante();
    }

    public float getTotalCobrado(){
        // Suma únicamente las citas que fueron atendidas.
        float total = 0;
        for(Cita cita : historial){
            if(cita.getEstado() == EstadoCita.ATENDIDA){
                total += cita.getTotal();
            }
        }
        return total;
    }
}