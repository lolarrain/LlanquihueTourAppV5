package model;

/**
 * Representa un vehículo utilizado en las operaciones
 * de Llanquihue Tour.
 */
public class Vehiculo implements Registrable {

    private String patente;
    private String modelo;
    private int capacidad;

    /**
     * Construye un nuevo vehículo.
     *
     * @param patente patente del vehículo
     * @param modelo modelo del vehículo
     * @param capacidad capacidad máxima de pasajeros
     */
    public Vehiculo(String patente, String modelo, int capacidad) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la patente del vehículo.
     *
     * @return patente del vehículo
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Modifica la patente del vehículo.
     *
     * @param patente nueva patente
     */
    public void setPatente(String patente) {
        this.patente = patente;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Modifica el modelo del vehículo.
     *
     * @param modelo nuevo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la capacidad del vehículo.
     *
     * @return capacidad máxima de pasajeros
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Modifica la capacidad del vehículo.
     *
     * @param capacidad nueva capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Devuelve un resumen con la información principal
     * del vehículo.
     *
     * @return resumen del vehículo
     */
    @Override
    public String mostrarResumen() {
        return "Tipo: Vehículo"
                + "\nPatente: " + patente
                + "\nModelo: " + modelo
                + "\nCapacidad: " + capacidad + " pasajeros";
    }
}
