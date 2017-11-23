/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;

public interface IParserTablero {
	public abstract Tablero leeTablero(String tablero) throws ExcepcionLectura;
}
