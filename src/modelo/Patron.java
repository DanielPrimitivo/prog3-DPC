/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import java.util.*;
import modelo.excepciones.*;

/**
 * Esta clase permite crear un patron en el cual sus atributos son un objeto tablero y un nombre (String), 
 * y tiene métodos getters los cuales devuelven el atributo nombre, el estado de alguna coordenada del 
 * tablero de patron, las posiciones (coordenadas) de este y la estructura con el toString
 */
public class Patron {
	
	/**
	 * Es un atributo el cual es un objeto de tipo Tablero que contendrá las coordenadas y los EstadoCelda
	 */
	private Tablero tablero;
	
	/**
	 * Es un atributo de tipo String el cual es el nombre del patron
	 */
	private String nombre;
	
	/**
	 * Es un método constructor en el cual nos pasan el nombre y el tablero y los asignamos a los atributos
	 * @param nombre Es el nombre del patron que vamos a guardar
	 * @param tablero Es el tablero el cual tiene las coordenadas y los EstadoCelda que vamos a guardar
	 */
	public Patron(String nombre, Tablero tablero) {
		if (nombre != null && tablero != null) {
			this.nombre = nombre;
			this.tablero = tablero;
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es un método getter el cual devuelve el atributo nombre, que es el nombre del patron
	 * @return Devuelve el atributo nombre que es de tipo String
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Es un método getter que nos pasan una coordenada y llamamos a getCelda del objeto tablero para que 
	 * nos devuelva el estado de esa celda que está asociada a la coordenada
	 * @param posicion Es la coordenada la cual debemos obtener el EstadoCelda
	 * @return Devuelve el EstadoCelda asociado a la posicion
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if (posicion != null) {
			return tablero.getCelda(posicion);
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es un método getter en el cual haciendo uso de un método de la clase tablero, obtenemos todas las 
	 * coordenadas del tablero de nuestro patron
	 * @return Devuelve un collection el cual contiene todas las posiciones del tablero de patron
	 */
	public Collection<Coordenada> getPosiciones() {
		return tablero.getPosiciones();
	}
	
	/**
	 * Es un método en el cual formamos una cadena con el nombre y el uso del método toString() de la 
	 * clase tablero
	 * @return Devuelve un String con la cadena formada siguiendo la estructura correspondiente
	 */
	@Override
	public String toString() {
		return nombre + "\n" + tablero.toString();
	}
	
}
