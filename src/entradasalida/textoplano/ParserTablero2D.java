/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.textoplano;

import java.util.ArrayList;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.*;
import modelo.excepciones.*;

public class ParserTablero2D implements IParserTablero{
	public ParserTablero2D () {}
	
	public Tablero leeTablero(String cadena) throws ExcepcionLectura {
		if (cadena != null) {
			if (cadena.length() == 0) {
				throw new ExcepcionLectura("Cadena vacia");
			}
			else {
				for (int i = 0;i < cadena.length();i++) {
					if (cadena.charAt(i) != '*' && cadena.charAt(i) != ' ' && cadena.charAt(i) != '\n') {
						throw new ExcepcionLectura("Caracter incorrecto");
					}
				}
			}
			
			ArrayList<String> array = new ArrayList<String>();
			
			String fila = "";
			
			if (cadena.charAt(cadena.length()-1) != '\n') {
				cadena += '\n';
			}
			
			for (int i = 0;i < cadena.length();i++) {
				if (cadena.charAt(i) != '\n') {
					fila += cadena.charAt(i);
				}
				else {
					array.add(fila);
					fila = "";
				}
			}
			
			int medida = array.get(0).length();
			
			for (String c : array) {
				if (medida != c.length()) {
					throw new ExcepcionLectura("Numero de columnas diferente");
				}
			}
			
			try {
				TableroCeldasCuadradas tablerocc = new TableroCeldasCuadradas(array.get(0).length(),array.size());
				
				for (int i = 0;i < array.size();i++) {
					for (int j = 0;j < array.get(i).length();j++) {
						if (array.get(i).charAt(j) == '*') {
							Coordenada2D coord2d = new Coordenada2D(j,i);
							try {
								tablerocc.setCelda(coord2d, EstadoCelda.VIVA);
							}
							catch (ExcepcionPosicionFueraTablero e) {
								throw new ExcepcionEjecucion(e);
							}
						}
					}
				}
				
				return tablerocc;
			}
			catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
}
