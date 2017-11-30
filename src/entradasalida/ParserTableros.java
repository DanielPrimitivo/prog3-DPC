/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.*;
import modelo.Tablero;
import modelo.excepciones.*;

public class ParserTableros {
	public ParserTableros() {}
	
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
