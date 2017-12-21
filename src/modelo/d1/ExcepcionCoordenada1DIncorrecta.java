/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo.d1;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * Es una clase excepción, la cual tiene un método constructor que guarda el parametro, 
 * además tiene 2 getters, puede devolver un mensaje o el atributo x. 
 * Hereda de ExcepcionCoordenadaIncorrecta
 */
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Es un atributo que contiene el valor de la abcisa
	 */
	private int x;
	
	/**
	 * Es un método constructor en el cual nos pasan por parámetro un entero y los 
	 * guardamos en el atributo
	 * @param x Es el valor de la abcisa
	 */
	public ExcepcionCoordenada1DIncorrecta(int x) {
		super();
		
		this.x = x;
	}
	
	/**
	 * Es un método getter el cual devuelve un mensaje de error
	 * @return devuelve un string que contiene el mensaje
	 */
	public String getMessage() {
		return "Error, coordenada 1D incorrecta";
	}
	
	/**
	 * Es un método getter el cual devuelve el atributo x
	 * @return devuelve el atributo x que es un entero
	 */
	public int getX() {
		return x;
	}
}
