/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo.d1;

import modelo.Coordenada;
import modelo.excepciones.*;

/**
 * Esta clase permite crear nuevas coordenas poniendo un valor a x que es la abcisa, además permite 
 * saber cuantas coordenadas hay, obtener abcisa, comparar dos coordenadas, sumar dos coordenas e 
 * imprimirlas por pantalla. Hereda de Coordenada
 */
public class Coordenada1D extends Coordenada {
	
	/**
	 * Es el atributo que contiene la abcisa de la coordenada
	 */
	private int x;
	
	/**
	 * Es el método constructor en el cual recibes por parametro el valor que permite crear la 
	 * coordenada
	 * @param x Es la abcisa de la coordenada
	 * @throws ExcepcionCoordenadaIncorrecta Puede lanzar la excepción
	 */
	public Coordenada1D(int x) throws ExcepcionCoordenadaIncorrecta {
		if (x >= 0) {
			this.x = x;
		}
		else {
			throw new ExcepcionCoordenada1DIncorrecta(x);
		}
	}
	
	/**
	 * Es el método constructor en el cual recibes por parametro un objeto coordenada que permite 
	 * crear la coordenada
	 * @param otra Es un objeto de tipo coordenada
	 */
	public Coordenada1D(Coordenada1D otra) {
		if (otra != null) {
			this.x = otra.x;
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es el método en el cual devuelve la coordenada en tipo String
	 * @return Devuelve la coordenada con el formato deseado
	 */
	@Override
	public String toString() {
		return "(" + x + ")";
	}
	
	/**
	 * Es el método en el cual nos pasan por parámetro un objeto de tipo Object y comprobamos si es de 
	 * tipo Coordenada1D, en caso de no serlo devuelve false, en caso de serlo, entonces lo formateamos 
	 * y comprobamos si las coordenadas son iguales, en caso de ser cierto devuelve true, sino false.
	 * @param otro Es un objeto de tipo Object
	 * @return Devuelve un booleano
	 */
	@Override
	public boolean equals(Object otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Coordenada1D elotro = (Coordenada1D) otro;
		if (x != elotro.x)
			return false;
		return true;
	}
	
	/**
	 * Es el método en el cual obtienes la abcisa de la coordenada
	 * @return Devuelve la abcisa de la coordenada
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Es el método en el cual te pasan un objeto de tipo coordenada y devuelves una nueva coordenada1D, 
	 * que es la suma de la coordenada que tienes con la que te pasan
	 * @param otra Parámetro de entrada que es un objeto de tipo coordenada
	 * @return Devuelve un objeto de tipo coordenada el cual es la suma de ambas coordenadas
	 * @throws ExcepcionCoordenadaIncorrecta Puede lanzar la excepción
	 */
	public Coordenada1D suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta {
		Coordenada1D c = (Coordenada1D) otra;
		Coordenada1D coord;
		if (otra != null) {
			coord = new Coordenada1D(x + c.x);
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
		
		return coord;
	}
	
	/**
	 * Es el método en el cual obtenemos un valor a partir de la combinación de campos de la clase en
	 * este caso x
	 * @return Devuelve el resultado de las operaciones realizadas
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}
	
}
