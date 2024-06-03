package Padle;
import java.util.LinkedList;
import javax.swing.JOptionPane;
public class GestorEquipos {
    private LinkedList<Equipo> equipos;
    

    public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public GestorEquipos() {
        this.equipos = new LinkedList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public Equipo buscarEquipoPorNombre(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    public LinkedList<Equipo> obtenerListaEquipos() {
        return equipos;
    }

    public void jugarPartido(Equipo equipo1, Equipo equipo2) {
        int setsEquipo1 = 0;
        int setsEquipo2 = 0;
        

        while (setsEquipo1 < 3 && setsEquipo2 < 3) {
        	//while de sets son 3 sets
            int juegosEquipo1 = 0;
            int juegosEquipo2 = 0;

            while (juegosEquipo1 < 6 && juegosEquipo2 < 6) {//el 6 corresponde a los games el 3 corresponde a los sets
                int puntoEquipo1 = (int) (Math.random() * 5);
                int puntoEquipo2 = (int) (Math.random() * 5);

                if (puntoEquipo1 > puntoEquipo2) {
                    juegosEquipo1++;
                } else {
                    juegosEquipo2++;
                }
            }

            if (juegosEquipo1 > juegosEquipo2) {
                setsEquipo1++;
            } else {
                setsEquipo2++;
            }

        }
        
        if (setsEquipo2 < setsEquipo1) {
			JOptionPane.showMessageDialog(null, "El ganador es el equipo: " +equipo1);
		} else if (setsEquipo1 < setsEquipo2) {
			JOptionPane.showMessageDialog(null, "El ganador es el equipo: " +equipo2);
		} 

       
    }

	@Override
	public String toString() {
		return "GestorEquipos [equipos=" + equipos + "]";
	}
}
	

