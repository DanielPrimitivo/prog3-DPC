/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto ReglaConway el cual tiene un constructor vacío y un getter que te 
 * calcula el siguiente estado de una coordenada de un tablero en función de unas reglas y te devuelve 
 * si el siguiente estado será viva o muerta
 */
public class ReglaConway {
	
	/**
	 * Es un método constructor que en este caso está vacío
	 */
	public ReglaConway() {}
	
	/**
	 * Es un método en el cual nos pasan un tablero y una coordenada y calcula en base a como está el 
	 * estado de esa posición en el tablero cual va a ser el siguiente estado
	 * @param tablero Es el tablero en el cual vas a consultar los estados para aplicar las reglas
	 * @param posicion Es la coordenada la cual quieres saber cual va a ser su siguiente estado
	 * @return Devuelve un objeto de tipo EstadoCelda de si el siguiente estado está viva o muerta
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if (tablero != null && posicion != null) {
			EstadoCelda siguienteEstado = EstadoCelda.MUERTA;
			int numeroVivas = 0;
			
			if (tablero.getCelda(posicion) == EstadoCelda.MUERTA) {
				for (Coordenada coord : tablero.getPosicionesVecinasCCW(posicion)) {
					if (tablero.getCelda(coord) == EstadoCelda.VIVA) {
						numeroVivas++;
					}
				}
				
				if (numeroVivas == 3) {
					siguienteEstado = EstadoCelda.VIVA;
				}
			}
			else {
				for (Coordenada coord : tablero.getPosicionesVecinasCCW(posicion)) {
					if (tablero.getCelda(coord) == EstadoCelda.VIVA) {
						numeroVivas++;
					}
				}
				
				if (numeroVivas == 2 || numeroVivas == 3) {
					siguienteEstado = EstadoCelda.VIVA;
				}
			}
			
			return siguienteEstado;
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
}
