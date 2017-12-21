/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.txt;

import entradasalida.IParserTablero;
import entradasalida.excepciones.*;
import modelo.*;
import modelo.d1.Coordenada1D;
import modelo.d1.Tablero1D;
import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto ParserTablero1D el cual tiene implementada la 
 * interfaz IParserTablero, que obliga a crear el método leeTablero que además puede lanzar 
 * alguna excepción, también tiene un constructor vacío
 */
public class ParserTablero1D implements IParserTablero{
	
	/**
	 * Es un método constructor el cual está vacío y permite crear el objeto de la clase para 
	 * posteriormente usar los métodos de este
	 */
	public ParserTablero1D () {}
	
	/**
	 * Es un método que tenemos que crear al haber implementado la interfaz y te pasan por argumentos 
	 * los objetos necesarios para crear un tablero con las celdas pasadas
	 * @param cadena Contiene en un string las celdas del tablero que actualiza
	 * @return Devuelve un objeto de tipo tablero
	 * @throws ExcepcionLectura Puede lanzar la excepcion
	 */
	public Tablero leeTablero(String cadena) throws ExcepcionLectura {
		if (cadena != null) {
			if (cadena.length() == 0) {
				throw new ExcepcionLectura("Cadena vacia");
			}
			else {
				for (int i = 0;i < cadena.length();i++) {
					if (cadena.charAt(i) != '*' && cadena.charAt(i) != ' ') {
						throw new ExcepcionLectura("Caracter incorrecto");
					}
				}
			}
			
			try {
				Tablero1D tablero1d = new Tablero1D(cadena.length());
				
				for (int i = 0;i < cadena.length();i++) {
					if (cadena.charAt(i) == '*') {
						Coordenada1D coord1d = new Coordenada1D(i);
						try {
							tablero1d.setCelda(coord1d, EstadoCelda.VIVA);
						}
						catch (ExcepcionPosicionFueraTablero e) {
							throw new ExcepcionEjecucion(e);
						}
					}
				}
				
				return tablero1d;
			}
			catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
}
