package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.*;
import modelo.*;
import modelo.excepciones.*;

public class GeneradorGifAnimadoTablero2D implements IGeneradorFichero{
	public GeneradorGifAnimadoTablero2D() {}
	
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
