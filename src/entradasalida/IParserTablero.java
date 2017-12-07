/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;

/**
 * Esta interfaz permite generar parser en los objetos que la implementen, el método que devuelve 
 * un string y las clases que implementen esta interfaz están obligadas a crear este método
 */
public interface IParserTablero {
	
	/**
	 * Es un método abstracto por lo tanto no está implementado aquí pero si debe implementarse 
	 * en cada clase que implemente a la interfaz
	 * @param tablero Es la cadena que contiene el tablero
	 * @return No devuelve nada porque es un método abstracto
	 * @throws ExcepcionLectura Puede lanzar la excepcion
	 */
	public abstract Tablero leeTablero(String tablero) throws ExcepcionLectura;
}
