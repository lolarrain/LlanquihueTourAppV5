package model;

/**
 * Representa una persona vinculada a las operaciones
 * de Llanquihue Tour.
 *
 * Sirve como clase base para entidades como
 * GuiaTuristico y ColaboradorExterno.
 */
public abstract class Persona implements Registrable {

    private String nombre;
    private String rut;

    /**
     * Construye una nueva persona con su nombre y RUT.
     *
     * @param nombre nombre de la persona
     * @param rut RUT de la persona
     */
    public Persona(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Devuelve un resumen con la información principal de la persona.
     *
     * Cada subclase debe proporcionar su propia implementación.
     *
     * @return resumen de la persona
     */
    @Override
    public abstract String mostrarResumen();
}
