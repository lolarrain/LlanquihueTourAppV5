package data;

import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Registrable;
import model.Vehiculo;

import java.util.ArrayList;

/**
 * Gestiona una colección de entidades registrables
 * pertenecientes al sistema Llanquihue Tour.
 */
public class GestorEntidades {

    private ArrayList<Registrable> entidades;

    /**
     * Construye un gestor con una colección inicialmente vacía.
     */
    public GestorEntidades() {
        entidades = new ArrayList<>();
    }

    /**
     * Agrega una nueva entidad a la colección.
     *
     * @param entidad entidad que será registrada
     */
    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    /**
     * Obtiene la colección completa de entidades registradas.
     *
     * @return colección de entidades
     */
    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

    /**
     * Recorre las entidades registradas, identifica
     * su tipo específico y genera un resumen.
     *
     * @return resumen de las entidades registradas
     */
    public String obtenerResumenEntidades() {

        if (entidades.isEmpty()) {
            return "No hay entidades registradas.";
        }

        String resumen = "";

        for (Registrable entidad : entidades) {

            if (entidad instanceof GuiaTuristico) {
                resumen += "Categoría identificada: Guía turístico\n";

            } else if (entidad instanceof Vehiculo) {
                resumen += "Categoría identificada: Vehículo\n";

            } else if (entidad instanceof ColaboradorExterno) {
                resumen += "Categoría identificada: Colaborador externo\n";
            }

            resumen += entidad.mostrarResumen();
            resumen += "\n\n-----------------------------\n\n";
        }

        return resumen;
    }
}