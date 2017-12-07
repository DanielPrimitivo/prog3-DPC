/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.textoplano;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.Tablero1D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public class GeneradorFicheroPlano implements IGeneradorFichero{
	public GeneradorFicheroPlano() {}
	
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if (file != null && juego != null) {
			if (iteraciones > 0) {
				if (juego.getTablero() instanceof Imprimible) {
					try {
						PrintWriter pW = new PrintWriter(file);
						
						if (juego.getTablero() instanceof Tablero1D) {
							Tablero1D tablero1d = (Tablero1D) juego.getTablero();
							
							for (int i = 0;i < iteraciones;i++) {
								juego.actualiza();
								
								pW.print(tablero1d.generaCadena());
							}
						}
						
						if (juego.getTablero() instanceof TableroCeldasCuadradas) {
							TableroCeldasCuadradas tablerocc = (TableroCeldasCuadradas) juego.getTablero();
							
							for (int i = 0;i < iteraciones;i++) {
								juego.actualiza();
								
								pW.print(tablerocc.generaCadena());
							}
						}
						
						pW.close();
					}
					catch (FileNotFoundException e) {
						throw new ExcepcionGeneracion(e);
					}
				}
				else {
					throw new ExcepcionGeneracion("No instancia Imprimible");
				}
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
