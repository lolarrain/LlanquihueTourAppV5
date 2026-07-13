package model;

/**
 * Representa a un guía turístico vinculado
 * a las operaciones de Llanquihue Tour.
 */
public class GuiaTuristico extends Persona implements Registrable {

    private String especialidad;

    /**
     * Construye un nuevo guía turístico.
     *
     * @param nombre nombre del guía
     * @param rut RUT del guía
     * @param especialidad especialidad principal del guía
     */
    public GuiaTuristico(String nombre, String rut, String especialidad) {
        super(nombre, rut);
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la especialidad del guía turístico.
     *
     * @return especialidad del guía
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Modifica la especialidad del guía turístico.
     *
     * @param especialidad nueva especialidad del guía
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Devuelve un resumen con la información principal
     * del guía turístico.
     *
     * @return resumen del guía turístico
     */
    @Override
    public String mostrarResumen() {
        return "Tipo: Guía turístico"
                + "\nNombre: " + getNombre()
                + "\nRUT: " + getRut()
                + "\nEspecialidad: " + especialidad;
    }
}