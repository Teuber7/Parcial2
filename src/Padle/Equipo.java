package Padle;
import java.util.LinkedList;
import javax.swing.JOptionPane;


public class Equipo {
    private String nombre;
    private String ciudad;
    private LinkedList<Jugador> jugadores;

    public Equipo(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.jugadores = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }
    

    public LinkedList<Jugador> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() < 2) {
            jugadores.add(jugador);
        } else {
           JOptionPane.showMessageDialog(null, "No se pueden agregar más de 2 jugadores a un equipo de pádel.");;
        }
    }

    public Jugador buscarJugadorPorNombre(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    public int obtenerCantidadJugadores() {
        return jugadores.size();
    }

    @Override
    public String toString() {
        return "\nEquipo{" + "nombre='" + nombre +"  \nciudad='" + ciudad +"  \njugadores=" + jugadores +'}';
    }
	}

