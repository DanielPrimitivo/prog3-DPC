/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import modelo.excepciones.*;

/**
 * Esta clase permite crear nuevas coordenadas, pero es de tipo abstracta, tiene un constructor 
 * y el método suma que es abstracto
 */
public abstract class Coordenada {
	
	/**
	 * Es el método constructor el cual está vacío
	 */
	public Coordenada() {}
	
	/**
	 * Es un método abstracto en el cual te pasan otra que es una coordenada para realizar una 
	 * suma, al ser un método abstracto se debe implementar en las subclases
	 * @param otra Parámetro de entrada que es un objeto de tipo coordenada
	 * @return No devuelve nada ya que es un método abstracto
	 * @throws ExcepcionCoordenadaIncorrecta Puede lanzar la excepción
	 */
	public abstract Coordenada suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta;
}
