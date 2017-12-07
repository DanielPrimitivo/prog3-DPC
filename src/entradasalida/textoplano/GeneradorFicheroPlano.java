/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.textoplano;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.*;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/**
 * Esta clase permite crear un objeto GeneradorFicheroPlano el cual tiene implementada la 
 * interfaz IGeneradorFichero, que obliga a crear el método generaFichero que además puede lanzar 
 * alguna excepción, también tiene un constructor vacío
 */
public class GeneradorFicheroPlano implements IGeneradorFichero{
	
	/**
	 * Es un método constructor el cual está vacío y permite crear el objeto de la clase para 
	 * posteriormente usar los métodos de este
	 */
	public GeneradorFicheroPlano() {}
	
	/**
	 * Es un método que tenemos que crear al haber implementado la interfaz y te pasan por argumentos 
	 * los objetos necesarios para realizar actualizar el tablero y guardarlo en un fichero
	 * @param file Es el archivo en el cual luego se deben de guardar los tableros
	 * @param juego Es el objeto que contiene el tablero el cual debe actualizarse
	 * @param iteraciones Es la cantidad de actualizaciones del tablero
	 * @throws ExcepcionGeneracion Puede lanzar la excepcion
	 */
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
