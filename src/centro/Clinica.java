package centro;
import java.util.*;
import java.time.*;
import personas.*;
import servicios.*;
import mascotas.*;

// Administra consultorios, personal, dueños y citas.
public class Clinica{
    Scanner scanner;
    protected String nombre;
    protected Map<String, Consultorio> consultorios = new HashMap<>();
    protected ArrayList<Veterinario> personal = new ArrayList<>();
    protected HashMap<String, Dueno> duenos = new HashMap<>();

    public Clinica(){
        nombre = "Pet care";
        scanner = new Scanner(System.in);
    }

    public Clinica(Scanner scanner){
        if(scanner == null){
            throw new IllegalArgumentException("El scanner es obligatorio");
        }
        nombre = "Pet care";
        this.scanner = scanner;
    }

    // Registra un consultorio validando que exista.
    public void agregarConsultorio(Consultorio consultorio){
        if(consultorio == null){
            throw new IllegalArgumentException("El consultorio es obligatorio");
        }
        consultorios.put(consultorio.getNombre(), consultorio);
    }

    // Registra un veterinario y le asigna un consultorio válido.
    public void agregarVeterinario(Veterinario veterinario, int idConsultorio){
        if(veterinario == null){
            throw new IllegalArgumentException("El veterinario es obligatorio");
        }
        Consultorio consultorio = buscarConsultorio(idConsultorio);
        if(consultorio == null){
            throw new IllegalArgumentException("No existe el consultorio indicado");
        }
        veterinario.asignarConsultorio(idConsultorio);
        personal.add(veterinario);
    }

    // Guarda un dueño usando su nombre completo como identificador.
    public void agregarDueno(Dueno dueno){
        if(dueno == null){
            throw new IllegalArgumentException("El dueño es obligatorio");
        }
        String identificador = dueno.getNombreCompleto();
        if(duenos.containsKey(identificador)){
            throw new IllegalArgumentException("Ya existe un dueño con ese nombre");
        }
        duenos.put(identificador, dueno);
    }

    // Guarda la mascota dentro del dueño responsable, no en la clínica.
    public void agregarMascota(Mascota mascota){
        if(mascota == null){
            throw new IllegalArgumentException("La mascota es obligatoria");
        }
        if(mascota.getDueno() == null){
            throw new IllegalArgumentException("La mascota debe tener un dueño");
        }
        if(buscarMascota(mascota.getNombre()) != null){
            throw new IllegalArgumentException("Ya existe una mascota con ese nombre");
        }
        Dueno dueno = mascota.getDueno();
        Dueno duenoRegistrado = duenos.get(dueno.getNombreCompleto());
        if(duenoRegistrado == null){
            agregarDueno(dueno);
            duenoRegistrado = dueno;
        }
        if(duenoRegistrado != dueno){
            mascota.asignarDueno(duenoRegistrado);
        }
        duenoRegistrado.agregarMascota(mascota);
    }

    private Mascota buscarMascota(String nombre){
        for(Dueno dueno : duenos.values()){
            Mascota mascota = dueno.buscarMascota(nombre);
            if(mascota != null){
                return mascota;
            }
        }
        return null;
    }

    private Consultorio buscarConsultorio(int id){
        // Busca un consultorio por su identificador.
        for(Consultorio consultorio : consultorios.values()){
            if(consultorio.getId() == id){
                return consultorio;
            }
        }
        return null;
    }

    public void setPersonal(){
        // Captura los datos de un veterinario desde la consola.
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
        // Captura y registra un nuevo consultorio.
        System.out.println("Datos del consultorio");
        System.out.print("Escriba el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Escriba el id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Consultorio nuevo = new Consultorio(nombre, id);
        consultorios.put(nombre, nuevo);
    }

    public void setCliente(){
        // Permite registrar un dueño nuevo o usar uno ya registrado.
        Dueno dueno;
        if(duenos.isEmpty()){
            System.out.println("No hay dueños registrados. Se creará uno nuevo.");
            dueno = setDueno();
        }else{
            System.out.println("Seleccione el dueño de la mascota:");
            System.out.println("1. Registrar un dueño nuevo");
            System.out.println("2. Usar un dueño existente");
            System.out.print("Elija su opcion: ");
            int opcionDueno = scanner.nextInt();
            scanner.nextLine();

            if(opcionDueno == 1){
                dueno = setDueno();
            }else if(opcionDueno == 2){
                dueno = seleccionarDueno();
                if(dueno == null){
                    return;
                }
            }else{
                System.out.println("Opcion no valida");
                return;
            }
        }

        System.out.println("¿Que animal es su mascota?");
        System.out.println("1.Perro");
        System.out.println("2.Gato");
        System.out.println("3.Ave exotica");
        System.out.print("Elija su opcion: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Escriba el nombre: ");
        String nombre = scanner.nextLine();

        if(buscarMascota(nombre) != null){
            System.out.println("Ya existe una mascota con ese nombre");
            return;
        }

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

        try{
            agregarMascota(nueva);
        }catch(IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }

    private Dueno seleccionarDueno(){
        ArrayList<Dueno> duenosDisponibles = new ArrayList<>(duenos.values());
        int numero = 1;
        for(Dueno dueno : duenosDisponibles){
            System.out.println(numero + ". " + dueno.getNombreCompleto());
            numero++;
        }

        System.out.print("Elija el dueño: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if(opcion < 1 || opcion > duenosDisponibles.size()){
            System.out.println("Opcion no valida");
            return null;
        }
        return duenosDisponibles.get(opcion - 1);
    }

    public Dueno setDueno(){
        // Captura los datos básicos del dueño.
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

    private Dueno buscarDueno(String nombreCompleto){
        return duenos.get(nombreCompleto);
    }

    private boolean especialidadCompatible(String especialidad, String tipoMascota) {
    // Comprueba que la especialidad corresponda al tipo de mascota.
    return switch (especialidad) {
        case "Perros" -> tipoMascota.equals("Perro");
        case "Gatos" -> tipoMascota.equals("Gato");
        case "Aves" -> tipoMascota.equals("Ave exotica");
        default -> false;
        };
    }


    public void agendarCita(){
        // Selecciona mascota, veterinario y servicio para crear una cita.
        System.out.println("Datos de la cita");
        System.out.print("Escriba el nombre de la mascota: ");
        String nombreMascota = scanner.nextLine();
        Mascota mascota = buscarMascota(nombreMascota);
        if(mascota == null){
            System.out.println("No existe una mascota con ese nombre");
            return;
        }

        System.out.print("Escriba la fecha (AAAA-MM-DD): ");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());

        ArrayList<Veterinario> veterinariosCompatibles = new ArrayList<>();
        for(Veterinario veterinario : personal){
            // Solo se muestran veterinarios compatibles y disponibles.
            if(especialidadCompatible(veterinario.especialidad, mascota.getTipo()) && veterinario.isDisponible(fecha)){
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

    public void procesarCita(boolean opt){
        // Atiende o cancela una cita según la opción recibida.
        System.out.print("Escriba el nombre de la mascota: ");
        String nombre = scanner.nextLine();
        Mascota mascota = buscarMascota(nombre);
        if(mascota != null){
            mascota.printCitas();
            System.out.print("Elija la cita a atender: ");
            int opcionCita = scanner.nextInt();
            scanner.nextLine();
            if(opcionCita < 1 || opcionCita > mascota.getAgendaSize()){
                System.out.println("Opcion no valida");
                return;
            }
            if(!opt){
                mascota.cancelarCita(opcionCita - 1);
            } else {
                mascota.atenderCita(opcionCita - 1);
            }
        } else {
            System.out.println("No se encontro la mascota");
        }
    }

    public void generarComprobante(){
        // Genera un comprobante consultando el historial elegido.
        System.out.println("Generar comprobante por:");
        System.out.println("1. Mascota");
        System.out.println("2. Veterinario");
        System.out.print("Elija una opcion: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if(tipo == 1){
            System.out.print("Escriba el nombre de la mascota: ");
            Mascota mascota = buscarMascota(scanner.nextLine());
            if(mascota == null){
                System.out.println("No existe una mascota con ese nombre");
                return;
            }
            mascota.printHistorial();
            if(mascota.getHistorialSize() == 0){
                return;
            }
            System.out.print("Elija el historial para generar: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            mascota.generarComprobante(opcion);
            return;
        }

        if(tipo == 2){
            System.out.print("Escriba el nombre completo del veterinario: ");
            String nombre = scanner.nextLine();
            Veterinario veterinario = buscarVeterinario(nombre);
            if(veterinario != null){
                veterinario.printHistorial();
                if(veterinario.getHistorialSize() == 0){
                    return;
                }
                System.out.print("Elija el historial para generar: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                veterinario.generarComprobante(opcion);
                return;
            }
            System.out.println("No existe un veterinario con ese nombre");
            return;
        }
        System.out.println("Opcion no valida");
    }

    public void consultarHistorial(){
        // Muestra el historial clínico de una mascota.
        System.out.print("Escriba el nombre de la mascota: ");
        Mascota mascota = buscarMascota(scanner.nextLine());
        if(mascota == null){
            System.out.println("No existe una mascota con ese nombre");
            return;
        }
        mascota.printHistorial();
    }

    public void listarMascotas(){
        // Lista las mascotas registradas junto con su sonido.
        if(duenos.isEmpty()){
            System.out.println("No hay mascotas registradas");
            return;
        }
        System.out.println("Mascotas registradas:");
        for(Dueno dueno : duenos.values()){
            for(Mascota mascota : dueno.getMascotas()){
                System.out.println("- " + mascota.getNombre() + " ("
                    + mascota.getTipo() + ") - Sonido: " + mascota.getSonido());
            }
        }
    }

    public void consultarCobradoVeterinario(){
        // Consulta el total cobrado por un veterinario.
        System.out.print("Escriba el nombre completo del veterinario: ");
        String nombre = scanner.nextLine();
        Veterinario veterinario = buscarVeterinario(nombre);
        if(veterinario != null){
            System.out.println("Cobrado por " + veterinario.getNombreCompleto() + ": $"
                + veterinario.getTotalCobrado());
            return;
        }
        System.out.println("No existe un veterinario con ese nombre");
    }

    private Veterinario buscarVeterinario(String nombre){
        String nombreNormalizado = nombre.trim();
        for(Veterinario veterinario : personal){
            if(veterinario.getNombreCompleto().trim().equalsIgnoreCase(nombreNormalizado)){
                return veterinario;
            }
        }
        return null;
    }

    public void darDeBaja(){
        // Elimina una mascota del registro de la clínica.
        System.out.print("Escriba el nombre de la mascota: ");
        String nombre = scanner.nextLine();
        Mascota mascota = buscarMascota(nombre);
        if(mascota == null){
            System.out.println("No existe una mascota con ese nombre");
            return;
        }
        mascota.getDueno().quitarMascota(nombre);
        System.out.println("Mascota dada de baja correctamente");
    }
}