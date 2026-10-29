package centro;
import java.util.*;
import java.time.*;
import personas.*;
import servicios.*;
import mascotas.*;

public class Main{

    void menu(){
        System.out.println("1.Registrar dueno y mascota");
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
        Clinica clinica;
        System.out.println("Bienvenido a Petcare!");
        menu();
        System.out.print("Elija alguna de las opciones: ");
        int opt = scanner.nextInt();

        switch(opt){
            case 1:
                clinica.setMascota();
                break;
            
            case 2:
                clinica.setPersonal();
                break;
            
            case 3:
                clinica.agendarCita();
                break;
            
            case 4:
                clinica.atenderCita();
                break;
            
            case 5:
                clinica.cancelarCita();
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
                clinica.darDeBaja()
                break;

            case 11:
                clinica.setConsultorio();
                break;

            default:
                System.out.prinln("Opcion no valida!");
                break;    
        }
    }
}