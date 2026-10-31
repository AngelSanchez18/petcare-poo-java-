package servicios;
import java.time.*;
import mascotas.Mascota;
import personas.Dueno;
import personas.Veterinario;

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
        if(estado == EstadoCita.PROGRAMADA){
            estado = EstadoCita.ATENDIDA;
            System.out.println("Cita atendida exitosamente");
            return;
        }
        System.out.println("La cita se encuentra cancelada o ya fue atendida");
    }

    public void cancelarCita(){
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
}