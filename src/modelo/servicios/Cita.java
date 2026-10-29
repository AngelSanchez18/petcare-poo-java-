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
}