package servicios;

// Servicio cuyo costo corresponde a la tarifa base.
public class ConsultaGeneral extends ServicioCobro{
    public ConsultaGeneral(){
        // La consulta general usa únicamente la tarifa base.
        total = tarifaBase;
    }
}