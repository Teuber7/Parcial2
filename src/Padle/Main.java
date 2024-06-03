package Padle;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {
    private static GestorEquipos gestorEquipos = new GestorEquipos();

    public static void main(String[] args) {
        String[] Opciones = {"Agregar Jugador", "Buscar Jugador", "Agregar Equipo", "Buscar Equipo", "Jugar Partido", "Mostrar Equipos", "Salir"};
        boolean CorrerAplicacion = true;
        String[][] equipos = {
                {"Boca Juniors", "Buenos Aires"},
                {"River Plate", "Buenos Aires"},
                {"Independiente", "Avellaneda"},
                {"Racing Club", "Avellaneda"},
                {"San Lorenzo", "Buenos Aires"},
                {"Vélez Sarsfield", "Buenos Aires"},
                {"Estudiantes", "La Plata"},
                {"Gimnasia y Esgrima", "La Plata"},
                {"Rosario Central", "Rosario"},
                {"Newell's Old Boys", "Rosario"}
            };

            // Imprimir la matriz de equipos
            for (int i = 0; i < equipos.length; i++) {
            	agregarEquipoRelleno(equipos[i][0],equipos[i][1]);
            	
            }

        while (CorrerAplicacion) {
            String Eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú", JOptionPane.QUESTION_MESSAGE, null, Opciones, Opciones[0]);

            if (Eleccion == null || Eleccion.equals("Salir")) {
            	CorrerAplicacion = false;
            }

            switch (Eleccion) {
                case "Agregar Jugador":
                    agregarJugador();
                    break;
                case "Buscar Jugador":
                    buscarJugador();
                    break;
                case "Agregar Equipo":
                    agregarEquipo();
                    break;
                case "Buscar Equipo":
                    buscarEquipo();
                    break;
                case "Jugar Partido":
                    jugarPartido();
                    break;
                case "Mostrar Equipos":
                    JOptionPane.showMessageDialog(null, gestorEquipos.getEquipos());
                    break;
            }
        }
    }

    private static void agregarJugador() {
        Equipo equipo = seleccionarEquipo("Ingrese el nombre del equipo para agregar un jugador:");
        if (equipo == null)
        	return;

        
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
           
            while (edad > 75) {
				JOptionPane.showMessageDialog(null, "La edad supera los limites");
			}
            Jugador jugador = new Jugador(nombre, edad);
            equipo.agregarJugador(jugador);
            JOptionPane.showMessageDialog(null, "Jugador agregado exitosamente.");
        
            if (equipo.obtenerCantidadJugadores() < 2) {
            	JOptionPane.showMessageDialog(null, "No se pueden agregar más de 2 jugadores a un equipo de pádel.");
			}
           
        }
    

    private static void buscarJugador() {
        Equipo equipo = seleccionarEquipo("Ingrese el nombre del equipo para buscar un jugador:");
        if (equipo == null) 
        	return;

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador a buscar:");
        Jugador jugador = equipo.buscarJugadorPorNombre(nombre);
        JOptionPane.showMessageDialog(null, jugador != null ? jugador : "Jugador no encontrado.");
    }

    private static void agregarEquipo() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo:");
        String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad del equipo:");

        Equipo equipo = new Equipo(nombre, ciudad);
        gestorEquipos.agregarEquipo(equipo);
        JOptionPane.showMessageDialog(null, "Equipo agregado exitosamente.");
    }
    private static void agregarEquipoRelleno(String nombre,String ciudad) {
       

        Equipo equipo = new Equipo(nombre, ciudad);
        gestorEquipos.agregarEquipo(equipo);
    }
    private static void buscarEquipo() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo a buscar:");
        Equipo equipo = gestorEquipos.buscarEquipoPorNombre(nombre);
        JOptionPane.showMessageDialog(null, equipo != null ? equipo : "Equipo no encontrado.");
    }

    private static void jugarPartido() {
        Equipo equipo1 = seleccionarEquipo("Ingrese el nombre del primer equipo:");
        if (equipo1 == null || equipo1.obtenerCantidadJugadores() < 2) {
            JOptionPane.showMessageDialog(null, "El primer equipo no tiene suficientes jugadores.");
            return;
        }

        Equipo equipo2 = seleccionarEquipo("Ingrese el nombre del segundo equipo:");
        if (equipo2 == null || equipo2.obtenerCantidadJugadores() < 2) {
            JOptionPane.showMessageDialog(null, "El segundo equipo no tiene suficientes jugadores.");
            return;
        }

        gestorEquipos.jugarPartido(equipo1, equipo2);
    }

   

    private static Equipo seleccionarEquipo(String mensaje) {
        String nombre = JOptionPane.showInputDialog(mensaje);
        Equipo equipo = gestorEquipos.buscarEquipoPorNombre(nombre);
        if (equipo == null) {
            JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
        }
        return equipo;
    }
}

