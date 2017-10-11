/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import java.util.*;

public class Patron {
	Tablero tablero;
	
	private String nombre;
	
	public Patron(String nombre, Tablero tablero) {
		this.nombre = nombre;
		this.tablero = tablero;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public EstadoCelda getCelda(Coordenada posicion) {
		return tablero.getCelda(posicion);
	}
	
	public Collection<Coordenada> getPosiciones() {
		return tablero.getPosiciones();
	}

	@Override
	public String toString() {
		return "nombre\n" + tablero.toString();
	}
	
}
