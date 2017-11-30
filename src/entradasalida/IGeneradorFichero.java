/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida;

import java.io.File;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;

public interface IGeneradorFichero {
	public abstract void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion;
}
