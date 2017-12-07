/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida;

import java.io.File;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;

/**
 * Esta interfaz permite generar ficheros en los objetos que la implementen, el método que tiene 
 * no devuelve nada y las clases que implementen esta interfaz están obligadas a crear este 
 * método
 */
public interface IGeneradorFichero {
	
	/**
	 * Es un método abstracto por lo tanto no está implementado aquí pero si debe implementarse 
	 * en cada clase que implemente a la interfaz
	 * @param file Es el archivo en el cual luego se debe de guardar el contenido
	 * @param juego Es el objeto que contiene el tablero
	 * @param iteraciones Te pasan un entero que tiene una cantidad
	 * @throws ExcepcionGeneracion Puede lanzar una excepcion
	 */
	public abstract void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion;
}
