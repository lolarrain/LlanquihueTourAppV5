package ui;

import data.GestorEntidades;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Vehiculo;

import javax.swing.JOptionPane;

/**
 * Gestiona la interacción gráfica entre el usuario
 * y el sistema Llanquihue Tour.
 */
public class Interfaz {

    private final GestorEntidades gestor;

    public Interfaz() {
        gestor = new GestorEntidades();
    }

    public void iniciar() {

        int opcion;

        do {

            String menu = """
                    === LLANQUIHUE TOUR ===

                    1. Registrar guía turístico
                    2. Registrar vehículo
                    3. Registrar colaborador externo
                    4. Mostrar entidades registradas
                    5. Salir
                    """;

            String entrada = JOptionPane.showInputDialog(
                    null,
                    menu,
                    "Llanquihue Tour",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (entrada == null) {
                opcion = 5;

            } else {

                try {
                    opcion = Integer.parseInt(entrada.trim());

                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Debe ingresar un número válido.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    opcion = 0;
                }
            }

            switch (opcion) {

                case 1:
                    registrarGuiaTuristico();
                    break;

                case 2:
                    registrarVehiculo();
                    break;

                case 3:
                    registrarColaboradorExterno();
                    break;

                case 4:
                    mostrarEntidades();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(
                            null,
                            "Programa finalizado."
                    );
                    break;

                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opción no válida. Ingrese un número entre 1 y 5.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
            }

        } while (opcion != 5);
    }

    private void registrarGuiaTuristico() {

        String nombre = solicitarTextoObligatorio(
                "Ingrese el nombre del guía:",
                "nombre"
        );

        if (nombre == null) {
            return;
        }

        String rut = solicitarRut(
                "Ingrese el RUT del guía:"
        );

        if (rut == null) {
            return;
        }

        String especialidad = solicitarTextoObligatorio(
                "Ingrese la especialidad del guía:",
                "especialidad"
        );

        if (especialidad == null) {
            return;
        }

        GuiaTuristico guia = new GuiaTuristico(
                nombre,
                rut,
                especialidad
        );

        gestor.agregarEntidad(guia);

        JOptionPane.showMessageDialog(
                null,
                "Guía turístico registrado correctamente.",
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void registrarVehiculo() {

        String patente = solicitarTextoObligatorio(
                "Ingrese la patente del vehículo:",
                "patente"
        );

        if (patente == null) {
            return;
        }

        String modelo = solicitarTextoObligatorio(
                "Ingrese el modelo del vehículo:",
                "modelo"
        );

        if (modelo == null) {
            return;
        }

        Integer capacidad = solicitarEnteroPositivo(
                "Ingrese la capacidad de pasajeros:"
        );

        if (capacidad == null) {
            return;
        }

        Vehiculo vehiculo = new Vehiculo(
                patente,
                modelo,
                capacidad
        );

        gestor.agregarEntidad(vehiculo);

        JOptionPane.showMessageDialog(
                null,
                "Vehículo registrado correctamente.",
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void registrarColaboradorExterno() {

        String nombre = solicitarTextoObligatorio(
                "Ingrese el nombre del colaborador:",
                "nombre"
        );

        if (nombre == null) {
            return;
        }

        String rut = solicitarRut(
                "Ingrese el RUT del colaborador:"
        );

        if (rut == null) {
            return;
        }

        String empresa = solicitarTextoObligatorio(
                "Ingrese la empresa del colaborador:",
                "empresa"
        );

        if (empresa == null) {
            return;
        }

        ColaboradorExterno colaborador = new ColaboradorExterno(
                nombre,
                rut,
                empresa
        );

        gestor.agregarEntidad(colaborador);

        JOptionPane.showMessageDialog(
                null,
                "Colaborador externo registrado correctamente.",
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Solicita un texto obligatorio y verifica que no esté vacío.
     *
     * El cuadro de entrada se vuelve a mostrar mientras el usuario
     * ingrese un valor vacío. Si presiona Cancelar, retorna null.
     *
     * @param mensaje mensaje mostrado al usuario
     * @param nombreCampo nombre del campo que se está validando
     * @return texto válido ingresado o null si se cancela la operación
     */
    private String solicitarTextoObligatorio(
            String mensaje,
            String nombreCampo
    ) {

        while (true) {

            String entrada = JOptionPane.showInputDialog(
                    null,
                    mensaje
            );

            if (entrada == null) {
                return null;
            }

            entrada = entrada.trim();

            if (!entrada.isEmpty()) {
                return entrada;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "El campo " + nombreCampo + " no puede estar vacío.",
                    "Dato inválido",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    /**
     * Solicita un RUT y verifica que tenga un formato básico válido.
     *
     * Se aceptan formatos con puntos y guion o solamente con guion.
     * Esta validación revisa la estructura del dato, pero no calcula
     * el dígito verificador.
     *
     * @param mensaje mensaje mostrado al usuario
     * @return RUT válido o null si se cancela la operación
     */
    private String solicitarRut(String mensaje) {

        while (true) {

            String rut = JOptionPane.showInputDialog(
                    null,
                    mensaje
            );

            if (rut == null) {
                return null;
            }

            rut = rut.trim();

            if (rut.matches("\\d{1,2}(\\.\\d{3}){2}-[\\dkK]")
                    || rut.matches("\\d{7,8}-[\\dkK]")) {

                return rut;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Ingrese un RUT con formato válido.\n"
                            + "Ejemplo: 12.345.678-5 o 12345678-5.",
                    "RUT inválido",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    /**
     * Solicita un número entero mayor que cero.
     *
     * El cuadro de entrada se repite mientras el usuario ingrese
     * un valor inválido. Si presiona Cancelar, retorna null.
     *
     * @param mensaje mensaje mostrado al usuario
     * @return número entero positivo o null si se cancela la operación
     */
    private Integer solicitarEnteroPositivo(String mensaje) {

        while (true) {

            String entrada = JOptionPane.showInputDialog(
                    null,
                    mensaje
            );

            if (entrada == null) {
                return null;
            }

            try {

                int numero = Integer.parseInt(entrada.trim());

                if (numero > 0) {
                    return numero;
                }

                JOptionPane.showMessageDialog(
                        null,
                        "Debe ingresar un número mayor que cero.",
                        "Dato inválido",
                        JOptionPane.WARNING_MESSAGE
                );

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Debe ingresar un número entero válido.",
                        "Dato inválido",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    /**
     * Muestra el resumen de todas las entidades registradas.
     */
    private void mostrarEntidades() {

        JOptionPane.showMessageDialog(
                null,
                gestor.obtenerResumenEntidades(),
                "Entidades registradas",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}