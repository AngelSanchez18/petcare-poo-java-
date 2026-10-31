package personas;
import servicios.*;
import java.util.*;
import java.time.*;

public class Veterinario extends Persona{
    public String especialidad;
    public int idConsultorio;
    public ArrayList<Cita> agenda = new ArrayList<>();    

    public Veterinario(String nombre, String apellido, String telefono, String correo, String especialidad){
        super(nombre, apellido, telefono, correo);
        this.especialidad = especialidad;
    }

    public void setCita(Cita cita){
        agenda.add(cita);
    }

    public boolean isDisponible(LocalDate fecha){
        for(Cita cita : agenda){
            if(cita.getFecha().equals(fecha)){
                return false;
            }
        }
        return true;
    }
}