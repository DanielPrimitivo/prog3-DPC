package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import modelo.*;
import modelo.excepciones.*;

public class GeneradorGIFTablero1D implements IGeneradorFichero {
	public GeneradorGIFTablero1D() {}
	
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
