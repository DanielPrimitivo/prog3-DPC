/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import java.util.*;
import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto Juego el cual tiene un ArrayList de los patrones que se introducen 
 * al juego, un tablero y una regla, además tiene un constructor que inicializa tablero y regla, getter 
 * que devuelven el tablero y el ArrayList de patronesUsados y setters para añadir patrones y actualizar 
 * el tablero
 */
public class Juego<TipoCoordenada extends Coordenada> {
	
	/**
	 * Es un atributo que es una lista la cual inicializamos y que contendrá objetos de tipo Patron
	 */
	private ArrayList<Patron<TipoCoordenada>> patronesUsados = new ArrayList<Patron<TipoCoordenada>>();
	
	/**
	 * Es un atributo que es un objeto de tipo Tablero en el cual se harán todas las modificaciones
	 */
	private Tablero<TipoCoordenada> tablero;
	
	/**
	 * Es un atributo que es un objeto de tipo Regla
	 */
	private Regla<TipoCoordenada> regla;
	
	/**
	 * Es un método constructor en el cual nos pasan un tablero y una regla y tenemos que asignarlos a 
	 * los atributos
	 * @param tablero Es el tablero el cual vamos a asignar al atributo
	 * @param regla Es la regla la cual la vamos a asignar al atributo
	 */
	public Juego(Tablero<TipoCoordenada> tablero, Regla<TipoCoordenada> regla) {
		if (tablero != null && regla != null) {
			this.tablero = tablero;
			this.regla = regla;
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es un método setter el cual nos pasan un patron y una posicion inicial, tenemos que ver si se puede 
	 * cargar el patron, en caso de que si, entonces lo añadimos al array de patronesUsados, en caso contrario 
	 * mostramos un error
	 * @param p Es el patron el cual tenemos que comprobar si se puede cargar
	 * @param posicionInicial Es la coordenada superior izquierda del patron
	 * @throws ExcepcionPosicionFueraTablero Puede lanzar la excepción
	 */
	public void cargaPatron(Patron<TipoCoordenada> p, TipoCoordenada posicionInicial) throws ExcepcionPosicionFueraTablero {
		if(p != null && posicionInicial != null) {
			tablero.cargaPatron(p, posicionInicial);
			patronesUsados.add(p);
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es un método en el cual creamos un HashMap el cual vamos a rellenar con las coordenadas y su EstadoCelda 
	 * asociado que hemos obtenido ejecutando las reglas y una vez tenemos el HashMap entonces lo recorremos y 
	 * actualizamos el tablero con los nuevos estados
	 */
	public void actualiza() {
		HashMap<TipoCoordenada,EstadoCelda> celdas = new HashMap<TipoCoordenada,EstadoCelda>();
		
		for (TipoCoordenada coord : tablero.getPosiciones()) {
			try {
				celdas.put(coord, regla.calculaSiguienteEstadoCelda(tablero,coord));
			}
			catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		
		for (TipoCoordenada coord : celdas.keySet()) {
			try {
				tablero.setCelda(coord, celdas.get(coord));
			}
			catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion(e);
			}
		}
	}
	
	/**
	 * Es un método getter el cual devuelve el atributo tablero
	 * @return Devuelve un objeto de tipo Tablero que es el atributo tablero
	 */
	public Tablero<TipoCoordenada> getTablero() {
		return tablero;
	}
	
	/**
	 * Es un método getter el cual devolvemos la lista (ArrayList) que tiene los patrones que se han usado
	 * @return Devuelve un objeto de tipo ArrayList que contiene objetos de tipo patron
	 */
	public ArrayList<Patron<TipoCoordenada>> getPatrones() {
		return patronesUsados;
	}
	
}
