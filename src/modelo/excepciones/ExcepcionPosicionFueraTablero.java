/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo.excepciones;

import modelo.*;

/**
 * Es una clase excepción, la cual tiene un método constructor que guarda los parametros, 
 * además tiene 3 getters, puede devolver un mensaje, el atributo dimensiones o la coordenada. 
 * Hereda de Exception
 */
public class ExcepcionPosicionFueraTablero extends Exception {
	
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Es un atributo el cual es de tipo coordenada y contiene el tamaño del tablero
	 */
	private Coordenada dimensiones;
	
	/**
	 * Es un atributo el cual es de tipo coordenada y contiene la coordenada que hace lanzar esta excepción
	 */
	private Coordenada coordenada;
	
	/**
	 * Es un método constructor en el cual nos pasan por parámetro dos objetos de tipo Coordenada y 
	 * los guardamos en los atributos
	 * @param dimensiones Es el tamaño del tablero
	 * @param coordenada Es la coordenada que provoca la excepción
	 */
	public ExcepcionPosicionFueraTablero(Coordenada dimensiones, Coordenada coordenada) {
		super();
		
		this.dimensiones = dimensiones;
		this.coordenada = coordenada;
	}
	
	/**
	 * Es un método getter el cual devuelve un mensaje de error
	 * @return devuelve un string que contiene el mensaje
	 */
	public String getMessage() {
		return "Error, posicion fuera de tablero";
	}
	
	/**
	 * Es un método getter el cual devuelve el atributo dimensiones
	 * @return devuelve el atributo dimensiones que es de tipo Coordenada
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	
	/**
	 * Es un método getter el cual devuelve el atributo coordenada
	 * @return devuelve el atributo coordenada que es de tipo Coordenada
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}
}
