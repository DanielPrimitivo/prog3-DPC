/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.*;
import modelo.excepciones.*;

public class Factory {
	public Factory() {}
	
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) throws ExcepcionGeneracion {
		if (tablero != null && extension != null) {
			if (extension.equals("txt")) {
				return new GeneradorFicheroPlano();
			}
			else {
				throw new ExcepcionGeneracion("Extension incorrecta");
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
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
