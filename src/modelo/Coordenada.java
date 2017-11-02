/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import modelo.excepciones.*;

/**
 * Esta clase permite crear nuevas coordenas poniendo un valor a x que es la abcisa y un valor a y 
 * que es la ordenada, además permite saber cuantas coordenadas hay, obtener abcisa u ordenada, 
 * comparar dos coordenadas, sumar dos coordenas e imprimirlas por pantalla
 */
public class Coordenada {
	
	/**
	 * Es un atributo que lleva el contador de cuantas coordenas se han creado
	 */
	private static int NUMERO_COORDENADAS = 0;
	
	/**
	 * Es el atributo que contiene la abcisa de la coordenada
	 */
	private int x;
	
	/**
	 * Es el atributo que contiene la ordenada de la coordenada
	 */
	private int y;
	
	/**
	 * Es el método constructor en el cual recibes por parametro los valores que permiten crear la 
	 * coordenada y además actualiza el contador de coordenadas
	 * @param x Es la abcisa de la coordenada
	 * @param y Es la ordenada de la coordenada
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public Coordenada(int x, int y) throws ExcepcionCoordenadaIncorrecta {
		if (x >= 0 && y >= 0) {
			this.x = x;
			this.y = y;
			NUMERO_COORDENADAS++;
		}
		else {
			throw new ExcepcionCoordenadaIncorrecta();
		}
	}
	
	/**
	 * Es el método constructor en el cual recibes por parametro un objeto coordenada que permite 
	 * crear la coordenada y además actualiza el contador de coordenadas
	 * @param otra Es un objeto de tipo coordenada
	 */
	public Coordenada(Coordenada otra) {
		if (otra != null) {
			this.x = otra.x;
			this.y = otra.y;
			NUMERO_COORDENADAS++;
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es el método en el cual obtienes el número de coordenadas que hay
	 * @return Devuelve el número de coordenadas
	 */
	public static int getNumeroCoordenadas() {
		return NUMERO_COORDENADAS;
	}
	
	/**
	 * Es el método en el cual devuelve la coordenada en tipo String
	 * @return Devuelve la coordenada con el formato deseado
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	/**
	 * Es el método en el cual nos pasan por parámetro un objeto de tipo Object y comprobamos si es de 
	 * tipo Coordenada, en caso de no serlo devuelve false, en caso de serlo, entonces lo formateamos 
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
		Coordenada elotro = (Coordenada) otro;
		if (x != elotro.x)
			return false;
		if (y != elotro.y)
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
	 * Es el método en el cual obtienes la ordenada de la coordenada
	 * @return Devuelve la ordenada de la coordenada
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Es el método en el cual te pasan un objeto de tipo coordenada y devuelves una nueva coordenada, 
	 * que es la suma de la coordenada que tienes con la que te pasan
	 * @param otra Parámetro de entrada que es un objeto de tipo coordenada
	 * @return Devuelve un objeto de tipo coordenada el cual es la suma de ambas coordenadas
	 */
	public Coordenada suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta {
		Coordenada coord;
		if (otra != null) {
			coord = new Coordenada(x + otra.x, y + otra.y);
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
		
		return coord;
	}
	
	/**
	 * Es el método en el cual obtenemos un valor a partir de la combinación de campos de la clase en
	 * este caso x e y
	 * @return Devuelve el resultado de las operaciones realizadas
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
}
