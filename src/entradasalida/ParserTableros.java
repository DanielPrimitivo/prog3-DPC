/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.txt.*;
import modelo.Tablero;
import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto ParserTableros el cual tiene un constructor vacío y un 
 * método getter que es static y el cual devuelve un objeto de tipo Tablero, este método puede 
 * lanzar algunas excepciones
 */
public class ParserTableros {
	
	/**
	 * Es un método constructor el cual está vacío y permite crear el objeto de la clase para 
	 * posteriormente usar los métodos de este
	 */
	public ParserTableros() {}
	
	/**
	 * Es un método getter que es static y el cual devuelve un objeto de tipo Tablero, pasan por 
	 * parametro un string y crea un tablero con este
	 * @param cadena Es el string con el que vamos a crear el tablero
	 * @return Devuelve un objeto de tipo Tablero
	 * @throws ExcepcionLectura Puede lanzar la excepcion
	 */
	public static Tablero leeTablero(String cadena) throws ExcepcionLectura {
		if (cadena != null) {
			if (cadena.length() == 0) {
				throw new ExcepcionLectura("Cadena vacia");
			}
			else {
				if (cadena.contains("\n")) {
					ParserTablero2D parser2d = new ParserTablero2D();
					return parser2d.leeTablero(cadena);
				}
				else {
					ParserTablero1D parser1d = new ParserTablero1D();
					return parser1d.leeTablero(cadena);
				}
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
}
