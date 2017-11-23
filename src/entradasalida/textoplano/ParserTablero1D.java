/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.textoplano;

import entradasalida.IParserTablero;
import entradasalida.excepciones.*;
import modelo.*;
import modelo.excepciones.*;

public class ParserTablero1D implements IParserTablero{
	public ParserTablero1D () {}
	
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
