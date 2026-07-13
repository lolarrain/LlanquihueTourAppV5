package model;

/**
 * Define el comportamiento común para todas las entidades
 * gestionables dentro del sistema Llanquihue Tour.
 */
public interface Registrable {

    /**
     * Devuelve un resumen con la información principal de la entidad.
     *
     * @return resumen de la entidad
     */
    String mostrarResumen();
}