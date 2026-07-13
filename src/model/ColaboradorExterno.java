package model;

/**
 * Representa a un colaborador externo que presta servicios
 * a Llanquihue Tour.
 */
public class ColaboradorExterno extends Persona implements Registrable {

    private String empresa;

    /**
     * Construye un nuevo colaborador externo.
     *
     * @param nombre nombre del colaborador
     * @param rut RUT del colaborador
     * @param empresa empresa a la que pertenece
     */
    public ColaboradorExterno(String nombre, String rut, String empresa) {
        super(nombre, rut);
        this.empresa = empresa;
    }

    /**
     * Obtiene la empresa del colaborador.
     *
     * @return empresa del colaborador
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Modifica la empresa del colaborador.
     *
     * @param empresa nueva empresa del colaborador
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Devuelve un resumen con la información principal
     * del colaborador externo.
     *
     * @return resumen del colaborador externo
     */
    @Override
    public String mostrarResumen() {
        return "Tipo: Colaborador externo"
                + "\nNombre: " + getNombre()
                + "\nRUT: " + getRut()
                + "\nEmpresa: " + empresa;
    }
}