package personas;
import servicios.*;
import java.util.*;
import java.time.*;

// Representa un veterinario y las citas bajo su responsabilidad.
public class Veterinario extends Persona{
    public String especialidad;
    public int idConsultorio;
    public ArrayList<Cita> agenda = new ArrayList<>();    

    public Veterinario(String nombre, String apellido, String telefono, String correo, String especialidad){
        super(nombre, apellido, telefono, correo);
        this.especialidad = especialidad;
    }

    public void asignarConsultorio(int idConsultorio){
        // Asigna el consultorio después de validar su identificador.
        if(idConsultorio < 0){
            throw new IllegalArgumentException("El id del consultorio no puede ser negativo");
        }
        this.idConsultorio = idConsultorio;
    }

    public void setCita(Cita cita){
        agenda.add(cita);
    }

    public boolean isDisponible(LocalDate fecha){
        // Verifica que no exista otra cita en la misma fecha.
        for(Cita cita : agenda){
            if(cita.getFecha().equals(fecha)){
                return false;
            }
        }
        return true;
    }

    public void printHistorial(){
        // Muestra las citas que ya no están programadas.
        System.out.println("Historial de " + getNombreCompleto());
        int numero = 1;
        for(Cita cita : agenda){
            if(cita.getEstado() != EstadoCita.PROGRAMADA){
                System.out.println(numero + ". " + cita.getFecha()
                    + " - " + cita.getMascota().getNombre()
                    + " - " + cita.getEstado());
                numero++;
            }
        }
        if(numero == 1){
            System.out.println("El veterinario no tiene historial");
        }
    }

    public int getHistorialSize(){
        int cantidad = 0;
        for(Cita cita : agenda){
            if(cita.getEstado() != EstadoCita.PROGRAMADA){
                cantidad++;
            }
        }
        return cantidad;
    }

    public void generarComprobante(int opcion){
        // Busca en el historial y genera el comprobante seleccionado.
        int numero = 1;
        for(Cita cita : agenda){
            if(cita.getEstado() != EstadoCita.PROGRAMADA){
                if(numero == opcion){
                    cita.generarComprobante();
                    return;
                }
                numero++;
            }
        }
        System.out.println("Opcion no valida");
    }

    public float getTotalCobrado(){
        // Calcula la mitad del total de cada cita atendida.
        float total = 0;
        for(Cita cita : agenda){
            if(cita.getEstado() == EstadoCita.ATENDIDA){
                total += cita.getCobradoVeterinario();
            }
        }
        return total;
    }
}