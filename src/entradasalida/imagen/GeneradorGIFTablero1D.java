/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import modelo.*;
import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto GeneradorGifTablero1D el cual tiene implementada la 
 * interfaz IGeneradorFichero, que obliga a crear el método generaFichero que además puede lanzar 
 * alguna excepción, también tiene un constructor vacío
 */
public class GeneradorGIFTablero1D implements IGeneradorFichero {
	
	/**
	 * Es un método constructor el cual está vacío y permite crear el objeto de la clase para 
	 * posteriormente usar los métodos de este
	 */
	public GeneradorGIFTablero1D() {}
	
	/**
	 * Es un método que tenemos que crear al haber implementado la interfaz y te pasan por argumentos 
	 * los objetos necesarios para realizar una imagen gif y guardarla en un fichero
	 * @param file Es el archivo en el cual luego se debe de guardar el gif
	 * @param juego Es el objeto que contiene el tablero con el que crear el gif
	 * @param iteraciones Es el alto de la imagen gif
	 * @throws ExcepcionGeneracion Puede lanzar la excepción
	 */
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if (file != null && juego != null) {
			if (iteraciones > 0) {
				Tablero1D tablero1d = (Tablero1D) juego.getTablero();
				Coordenada1D coordenada1d = (Coordenada1D) tablero1d.getDimensiones();
				
				ImagenGIF imagenGif = new ImagenGIF(coordenada1d.getX(), iteraciones);
				
				for (int i = 0;i < iteraciones;i++) {
					for (int j = 0;j < coordenada1d.getX();j++) {
						try {
							Coordenada1D coord1d = new Coordenada1D(j);
							
							if (tablero1d.getCelda(coord1d) == EstadoCelda.VIVA) {
								imagenGif.pintaCuadrado(j, i);
							}
						}
						catch (ExcepcionCoordenadaIncorrecta | ExcepcionPosicionFueraTablero e) {
							throw new ExcepcionEjecucion(e);
						}
					}
					
					juego.actualiza();
				}
				
				imagenGif.guardaFichero(file);
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
