# Entrega Actividad Sumativa S8 - Desarrollo Orientado a Objetos I

## Autor del proyecto

Nombre: Paloma Larraín Pereira

## Descripción general del sistema

Proyecto desarrollado en Java como continuación del sistema de gestión de la agencia turística ficticia Llanquihue Tour.

En esta versión, el sistema amplía sus funcionalidades para gestionar distintas entidades relevantes para las operaciones de la agencia, como guías turísticos, vehículos y colaboradores externos.

La solución aplica herencia, interfaces, polimorfismo, colecciones genéricas y validación de tipos mediante `instanceof`. Además, incorpora una interfaz gráfica básica con `JOptionPane`, que permite ingresar nuevos registros y visualizar su información de forma simple.

## Estructura general del proyecto

El proyecto está organizado en paquetes funcionales:

```text
src/
├── data/
│   └── GestorEntidades.java
├── model/
│   ├── ColaboradorExterno.java
│   ├── GuiaTuristico.java
│   ├── Persona.java
│   ├── Registrable.java
│   └── Vehiculo.java
└── ui/
    ├── Interfaz.java
    └── Main.java
```

## Descripción breve de los paquetes

`data`: contiene la clase GestorEntidades, encargada de almacenar y recorrer las entidades registrables mediante una colección ArrayList<Registrable>.

`model`: contiene las clases que representan las entidades del sistema, la clase base Persona y la interfaz Registrable, que define el comportamiento común mediante el método mostrarResumen().

`ui`: contiene la clase Main, que funciona como punto de entrada de la aplicación, e Interfaz, encargada de gestionar la interacción gráfica mediante JOptionPane.

## Instrucciones para clonar y ejecutar el proyecto

La ejecución de la aplicación se realiza desde:
`src/ui/Main.java`
La clase Main crea una instancia de InterfazUsuario e inicia la interfaz gráfica del sistema.

Clona el repositorio desde GitHub:
```text
git clone https://github.com/lolarrain/LlanquihueTourAppV5.git
```
1. Abre el proyecto en IntelliJ IDEA.

2. Verifica que las clases estén correctamente ubicadas en sus paquetes correspondientes.

3. Ejecuta el archivo Main.java desde el paquete ui.

Repositorio GitHub: [https://github.com/lolarrain/LlanquihueTourAppV5]  Fecha de entrega: [13/07/2026]
