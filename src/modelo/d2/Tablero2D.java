/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo.d2;

import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.excepciones.*;

/**
 * Esta clase es abstracta y permite crear un objeto de tipo Tablero2D el cual tiene un constructor para crear 
 * un Tablero y rellenarlo, se inicializa a estadocelda muerta. Hereda de Tablero
 */
public abstract class Tablero2D extends Tablero<Coordenada2D>{
	
	/**
	 * Es el método constructor el cual te pasan por parámetro el ancho y alto para crear el 
	 * tablero llamando a la superclase y rellenandolo
	 * @param ancho Es el valor de x la abcisa
	 * @param alto Es el valor de y la ordenada
	 * @throws ExcepcionCoordenadaIncorrecta Puede lanzar la excepción
	 */
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(new Coordenada2D(ancho,alto));
		
		for (int i = 0;i < ancho;i++) {
			for (int j = 0;j < alto;j++) {
				try {
					Coordenada2D coordenada = new Coordenada2D(i,j);
					celdas.put(coordenada, EstadoCelda.MUERTA);
				}
				catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
		}
	}
}
