/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import java.util.*;

public class Tablero {
	
	private HashMap<Coordenada,EstadoCelda> celdas;
	
	public Tablero(Coordenada dimensiones) {
		celdas = new HashMap<Coordenada,EstadoCelda>();
		for (int i = 0;i < dimensiones.getX();i++) {
			for (int j = 0;j < dimensiones.getY();j++) {
				Coordenada coordenada = new Coordenada(i,j);
				celdas.put(coordenada, EstadoCelda.MUERTA);
			}
		}
	}
	
}