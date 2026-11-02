package app;
import java.util.*;
import java.time.*;
import personas.*;
import servicios.*;
import mascotas.*;
import centro.*;

// Punto de entrada de la aplicación de consola.
public class Main{

    // Muestra las operaciones disponibles de la clínica.
    public static void menu(){
        System.out.println("1.Registrar dueño y mascota");
        System.out.println("2.Registrar veterinario y asignar clinica");
        System.out.println("3.Agendar una cita");
        System.out.println("4.Atender cita");
        System.out.println("5.Cancelar cita");
        System.out.println("6.Generar comprobante de una cita atendida");
        System.out.println("7.Consultar el historial clinico de una mascota");
        System.out.println("8.Listar mascotas y su sonido");
        System.out.println("9.Ver el total cobrado por veterinario");
        System.out.println("10.Dar de baja una mascota");
        System.out.println("11.Agregar consultorio");
        System.out.println("0.Salir");
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Clinica clinica = new Clinica(scanner);
        // Carga información de ejemplo antes de iniciar el menú.
        cargarDatosIniciales(clinica);

        do{
            System.out.println("Bienvenido a Petcare!");
            menu();
            System.out.print("Elija alguna de las opciones: ");
            int opt = scanner.nextInt();
            scanner.nextLine();

            switch(opt){
                case 0:
                    System.out.println("Gracias por usar Petcare!");
                    return;

                case 1:
                    clinica.setCliente();
                    break;
                
                case 2:
                    clinica.setPersonal();
                    break;
                
                case 3:
                    clinica.agendarCita();
                    break;
                
                case 4:
                    clinica.procesarCita(true);
                    break;
                
                case 5:
                    clinica.procesarCita(false);
                    break;
                
                case 6:
                    clinica.generarComprobante();
                    break;
                
                case 7:
                    clinica.consultarHistorial();
                    break;

                case 8:
                    clinica.listarMascotas();
                    break;
                
                case 9:
                    clinica.consultarCobradoVeterinario();
                    break;

                case 10:
                    clinica.darDeBaja();
                    break;

                case 11:
                    clinica.setConsultorio();
                    break;

                default:
                    System.out.println("Opcion no valida!");
                    break;    
            }
        }while(true);
    }

    private static void cargarDatosIniciales(Clinica clinica){
        // Prepara consultorios, personal, mascotas y citas iniciales.
        Consultorio consultorioNorte = new Consultorio("Consultorio Norte", 1);
        Consultorio consultorioSur = new Consultorio("Consultorio Sur", 2);
        clinica.agregarConsultorio(consultorioNorte);
        clinica.agregarConsultorio(consultorioSur);

        consultorioNorte.agregarRecepcionista(new Recepcionista(
            "Laura", "Gomez", "555-1001", "laura@petcare.com", "Matutino"));
        consultorioSur.agregarRecepcionista(new Recepcionista(
            "Diego", "Ruiz", "555-1002", "diego@petcare.com", "Vespertino"));

        Veterinario veterinarioPerros = new Veterinario(
            "Ana", "Martinez", "555-2001", "ana@petcare.com", "Perros");
        Veterinario veterinarioGatos = new Veterinario(
            "Carlos", "Lopez", "555-2002", "carlos@petcare.com", "Gatos");
        Veterinario veterinarioAves = new Veterinario(
            "Sofia", "Hernandez", "555-2003", "sofia@petcare.com", "Ave Exotica");
        clinica.agregarVeterinario(veterinarioPerros, consultorioNorte.getId());
        clinica.agregarVeterinario(veterinarioGatos, consultorioSur.getId());
        clinica.agregarVeterinario(veterinarioAves, consultorioNorte.getId());

        Dueno duenoPerro = new Dueno(
            "Miguel", "Sanchez", "555-3001", "miguel@email.com", "Calle 1");
        Dueno duenoGato = new Dueno(
            "Elena", "Torres", "555-3002", "elena@email.com", "Calle 2");
        Dueno duenoAve = new Dueno(
            "Jorge", "Ramirez", "555-3003", "jorge@email.com", "Calle 3");

        Mascota perro = new Perro(
            "Max", 4, 18.5f, duenoPerro, "Labrador", 8);
        Mascota gato = new Gato(
            "Luna", 3, 4.2f, duenoGato, true);
        Mascota ave = new AveExotica(
            "Kiwi", 2, 0.8f, duenoAve, 25.0f);
        duenoPerro.agregarMascota(perro);
        duenoGato.agregarMascota(gato);
        duenoAve.agregarMascota(ave);
        clinica.agregarDueno(duenoPerro);
        clinica.agregarDueno(duenoGato);
        clinica.agregarDueno(duenoAve);

        crearCita(perro, duenoPerro, veterinarioPerros,
            new ConsultaGeneral(), LocalDate.of(2026, 11, 5));
        crearCita(gato, duenoGato, veterinarioGatos,
            new Vacunacion(35), LocalDate.of(2026, 11, 6));
        crearCita(ave, duenoAve, veterinarioAves,
            new Cirugia(80, 2), LocalDate.of(2026, 11, 7));
    }

    private static void crearCita(Mascota mascota, Dueno dueno,
            Veterinario veterinario, ServicioCobro servicio, LocalDate fecha){
        // Relaciona la cita con la mascota y el veterinario.
        Cita cita = new Cita(fecha, servicio, dueno, mascota, veterinario);
        mascota.setCita(cita);
        veterinario.setCita(cita);
    }
}