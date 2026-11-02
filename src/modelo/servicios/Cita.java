package servicios;
import java.time.*;
import mascotas.Mascota;
import personas.Dueno;
import personas.Veterinario;

// Relaciona una mascota, su dueño, un veterinario y un servicio.
public class Cita{
    protected LocalDate fecha;
    protected EstadoCita estado;
    protected ServicioCobro servicio;
    protected Dueno dueno;
    protected Mascota mascota;
    protected Veterinario veterinario;
    
    public Cita(LocalDate fecha, ServicioCobro servicio, Dueno dueno, Mascota mascota, Veterinario veterinario){
        this.fecha = fecha;
        estado = EstadoCita.PROGRAMADA;
        this.servicio = servicio;
        this.dueno = dueno;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }

    public void atenderCita(){
        // Cambia el estado solo si la cita sigue programada.
        if(estado == EstadoCita.PROGRAMADA){
            estado = EstadoCita.ATENDIDA;
            System.out.println("Cita atendida exitosamente");
            return;
        }
        System.out.println("La cita se encuentra cancelada o ya fue atendida");
    }

    public void cancelarCita(){
        // Cancela la cita únicamente si aún está programada.
        if(estado == EstadoCita.PROGRAMADA){
            estado = EstadoCita.CANCELADA;
            System.out.println("Cita cancelada exitosamente");
            return;
        }
        System.out.println("La cita se encuentra atendida o ya fue cancelada");
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public EstadoCita getEstado(){
        return estado;
    }

    public Mascota getMascota(){
        return mascota;
    }

    public float getTotal(){
        return servicio.getTotal();
    }

    public float getCobradoVeterinario(){
        // El veterinario recibe la mitad del valor de la cita.
        return getTotal() / 2;
    }

    public void generarComprobante(){
        // Imprime el resumen de la cita y su servicio.
        System.out.println("----- Comprobante -----");
        System.out.println("Fecha: " + fecha);
        System.out.println("Mascota: " + mascota.getNombre());
        System.out.println("Veterinario: " + veterinario.getNombreCompleto());
        System.out.println("Estado: " + estado);
        System.out.println("Total: $" + servicio.getTotal());
        System.out.println("-----------------------");
    }
}