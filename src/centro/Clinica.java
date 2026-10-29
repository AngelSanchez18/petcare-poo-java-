package centro;
import java.util.*;
import java.time.*;
import personas.*;
import servicios.*;
import mascotas.*;

public class Clinica{
    Scanner scanner = new Scanner(System.in);
    protected String nombre;
    protected Map<String, Consultorio> consultorios = new HashMap<>();
    protected ArrayList<Veterinario> personal = new ArrayList<>();
    protected Map<String, Mascota> mascotas = new HashMap<>(); 

    public Clinica(){
        nombre = "Pet care";
    }

    public void setPersonal(){
        System.out.println("Datos del veterinario");
        System.out.print("Escriba el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Escriba el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Escriba el telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Escriba el correo: ");
        String correo = scanner.nextLine();
        System.out.print("Escriba la especialidad: ");
        String especialidad = scanner.nextLine();

        Veterinario nuevo = new Veterinario(nombre, apellido, telefono, correo, especialidad);
        personal.add(nuevo);
    }

    public void setConsultorio(){
        System.out.println("Datos del consultorio");
        System.out.print("Escriba el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Escriba el id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Consultorio nuevo = new Consultorio(nombre, id);
        consultorios.put(nombre, nuevo);
    }

    public void setMascota(){
        Dueno dueno = setDueno();

        System.out.println("¿Que animal es su mascota?");
        System.out.println("1.Perro");
        System.out.println("2.Gato");
        System.out.println("3.Ave exotica");
        System.out.print("Elija su opcion: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Escriba el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Escriba la edad: ");
        int edad = scanner.nextInt();
        System.out.print("Escriba el peso: ");
        float peso = scanner.nextFloat();
        scanner.nextLine();

        Mascota nueva;

        switch(opt){
            case 1:
                System.out.print("Escriba la raza: ");
                String raza = scanner.nextLine();
                System.out.print("Escriba el nivel de energia: ");
                int nivelEnergia = scanner.nextInt();
                nueva = new Perro(nombre, edad, peso, dueno, raza, nivelEnergia);
                break;
            case 2:
                System.out.print("¿Es domestico? (true/false): ");
                boolean esDomestico = scanner.nextBoolean();
                nueva = new Gato(nombre, edad, peso, dueno, esDomestico);
                break;
            case 3:
                System.out.print("Escriba la longitud de las alas: ");
                float longitudAlas = scanner.nextFloat();
                nueva = new AveExotica(nombre, edad, peso, dueno, longitudAlas);
                break;
            default:
                System.out.println("Opcion no valida");
                return;
        }

        mascotas.put(nombre, nueva);
    }

    public Dueno setDueno(){
        System.out.println("Datos del dueno");
        System.out.print("Escriba el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Escriba el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Escriba el telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Escriba el correo: ");
        String correo = scanner.nextLine();
        System.out.print("Escriba la direccion: ");
        String direccion = scanner.nextLine();

        return new Dueno(nombre, apellido, telefono, correo, direccion);
    }

    public void agendarCita(){
        System.out.println("Datos de la cita");
        System.out.print("Escriba el nombre de la mascota: ");
        String nombreMascota = scanner.nextLine();
        Mascota mascota = mascotas.get(nombreMascota);
        if(mascota == null){
            System.out.println("No existe una mascota con ese nombre");
            return;
        }

        ArrayList<Veterinario> veterinariosCompatibles = new ArrayList<>();
        for(Veterinario veterinario : personal){
            if(especialidadCompatible(veterinario.especialidad, mascota.getTipo())){
                veterinariosCompatibles.add(veterinario);
            }
        }
        
        System.out.println("Veterinarios disponibles para " + mascota.getTipo() + ":");
        for(int i = 0; i < veterinariosCompatibles.size(); i++){
            Veterinario veterinario = veterinariosCompatibles.get(i);
            System.out.println((i + 1) + ". " + veterinario.getNombreCompleto());
        }
        System.out.print("Elija el veterinario: ");
        int opcionVeterinario = scanner.nextInt();
        scanner.nextLine();
        if(opcionVeterinario < 1 || opcionVeterinario > veterinariosCompatibles.size()){
            System.out.println("Opcion no valida");
            return;
        }
        Veterinario veterinario = veterinariosCompatibles.get(opcionVeterinario - 1);

        System.out.print("Escriba la fecha (AAAA-MM-DD): ");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());

        System.out.println("Seleccione el servicio:");
        System.out.println("1. Consulta general");
        System.out.println("2. Vacunacion");
        System.out.println("3. Cirugia");
        System.out.print("Elija el servicio: ");
        int opcionServicio = scanner.nextInt();
        scanner.nextLine();

        ServicioCobro servicio;
        switch(opcionServicio){
            case 1:
                servicio = new ConsultaGeneral();
                break;
            case 2:
                System.out.print("Escriba el precio de la vacuna: ");
                float precioVacuna = scanner.nextFloat();
                scanner.nextLine();
                servicio = new Vacunacion(precioVacuna);
                break;
            case 3:
                System.out.print("Escriba la complejidad de la cirugia: ");
                float complejidad = scanner.nextFloat();
                System.out.print("Escriba la cantidad de horas: ");
                int horas = scanner.nextInt();
                scanner.nextLine();
                servicio = new Cirugia(complejidad, horas);
                break;
            default:
                System.out.println("Opcion no valida");
                return;
        }

        Cita cita = new Cita(
            fecha,
            servicio,
            mascota.getDueno(),
            mascota,
            veterinario
        );
        mascota.setCita(cita);
        veterinario.setCita(cita);
        System.out.println("Cita programada correctamente");
    }

    public void atenderCita(){

    }

    public void cancelarCita(){

    }

    public void generarComprobante(){

    }

    public void consultarHistorial(){

    }

    public void listarMascotas(){

    }

    public void consultarCobradoVeterinario(){

    }

    public void darDeBaja(){
        
    }
}