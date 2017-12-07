/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.*;
import modelo.*;
import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto GeneradorGifAnimadoTablero2D el cual tiene implementada la 
 * interfaz IGeneradorFichero, que obliga a crear el método generaFichero que además puede lanzar 
 * alguna excepción, también tiene un constructor vacío
 */
public class GeneradorGifAnimadoTablero2D implements IGeneradorFichero{
	
	/**
	 * Es un método constructor el cual está vacío y permite crear el objeto de la clase para 
	 * posteriormente usar los métodos de este
	 */
	public GeneradorGifAnimadoTablero2D() {}
	
	/**
	 * Es un método que tenemos que crear al haber implementado la interfaz y te pasan por argumentos 
	 * los objetos necesarios para realizar un gif animado y guardarlo en un fichero
	 * @param file Es el archivo en el cual luego se debe de guardar el gif
	 * @param juego Es el objeto que contiene el tablero con el que crear el gif
	 * @param iteraciones Es la cantidad de imagenes gifs que forman el gif animado
	 * @throws ExcepcionGeneracion Puede lanzar la excepción
	 */
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if (file != null && juego != null) {
			if (iteraciones > 0) {
				ImagenGIFAnimado imagenGifAnimado = new ImagenGIFAnimado(100);
				
				TableroCeldasCuadradas tablerocc = (TableroCeldasCuadradas) juego.getTablero();
				Coordenada2D coordenada2d = (Coordenada2D) tablerocc.getDimensiones();
				
				for (int i = 0;i < iteraciones;i++) {
					ImagenGIF imagenGif = new ImagenGIF(coordenada2d.getX(), coordenada2d.getY());
					
					for (int j = 0;j < coordenada2d.getX();j++) {
						for (int k = 0;k < coordenada2d.getY();k++) {
							try {
								Coordenada2D coord2d = new Coordenada2D(j, k);
								
								if (tablerocc.getCelda(coord2d) == EstadoCelda.VIVA) {
									imagenGif.pintaCuadrado(j, k);
								}
							}
							catch (ExcepcionCoordenadaIncorrecta | ExcepcionPosicionFueraTablero e) {
								throw new ExcepcionEjecucion(e);
							}
						}
					}
					
					imagenGifAnimado.addFotograma(imagenGif);
					juego.actualiza();
				}
				
				imagenGifAnimado.guardaFichero(file);
			}
			else {
				throw new ExcepcionGeneracion("Iteraciones incorrecto");
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
}
