/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.imagen.*;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.*;
import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto Factory el cual tiene un constructor vacío y tres métodos 
 * getters que tienen parametros de entrada, estos últimos son métodos static y además pueden 
 * lanzar algunas excepciones
 */
public class Factory {
	
	/**
	 * Es un método constructor el cual está vacío y permite crear el objeto de la clase para 
	 * posteriormente usar los métodos de este
	 */
	public Factory() {}
	
	/**
	 * Es un método getter que es static y el cual devuelve un objeto que tenga implementada la 
	 * interfaz IGeneradorFichero, pasan por parametro un tablero y un string
	 * @param tablero Es un objeto tablero que en función de este crearemos un gif u otro
	 * @param extension Es un string que te indica la extensión
	 * @return Devuelve un objeto que tenga implementada la interfaz IGeneradorFichero
	 * @throws ExcepcionGeneracion Puede lanzar la excepcion
	 */
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) throws ExcepcionGeneracion {
		if (tablero != null && extension != null) {
			if (extension.equals("txt")) {
				return new GeneradorFicheroPlano();
			}
			else if (extension.equals("gif")) {
				if (tablero instanceof Tablero1D) {
					return new GeneradorGIFTablero1D();
				}
				else if (tablero instanceof Tablero2D) {
					return new GeneradorGifAnimadoTablero2D();
				}
				else {
					throw new ExcepcionEjecucion("Tipo tablero incorrecto");
				}
			}
			else {
				throw new ExcepcionGeneracion("Extension incorrecta");
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es un método getter que es static y el cual devuelve un objeto de tipo Regla, pasan por 
	 * parametro un tablero
	 * @param tablero Es un objeto que en función de este crearemos una regla u otra
	 * @return Devuelve un objeto de tipo Regla
	 */
	public static Regla creaRegla(Tablero tablero) {
		if (tablero != null) {
			if (tablero instanceof Tablero1D) {
				return new Regla30();
			}
			else if (tablero instanceof Tablero2D) {
				return new ReglaConway();
			}
			else {
				throw new ExcepcionEjecucion("Tipo tablero incorrecto");
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es un método getter que es static y el cual devuelve un objeto de tipo Tablero, pasan por 
	 * parametro una coordenada
	 * @param dimensiones Es una coordenada la cual indica las dimensiones del tablero a crear
	 * @return Devuelve un objeto de tipo Tablero
	 * @throws ExcepcionCoordenadaIncorrecta Puede lanzar la excepcion
	 */
	public static Tablero creaTablero(Coordenada dimensiones) throws ExcepcionCoordenadaIncorrecta {
		if (dimensiones != null) {
			if (dimensiones instanceof Coordenada1D) {
				int ancho = ((Coordenada1D) dimensiones).getX();
				
				return new Tablero1D(ancho); 
			}
			else if(dimensiones instanceof Coordenada2D) {
				int ancho = ((Coordenada2D) dimensiones).getX();
				int alto = ((Coordenada2D) dimensiones).getY();
				
				return new TableroCeldasCuadradas(ancho, alto);
			}
			else {
				throw new ExcepcionEjecucion("Tipo coordenada incorrecto");
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
}
