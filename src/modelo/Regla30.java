/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto Regla30 el cual tiene un constructor vacío y un getter que te 
 * calcula el siguiente estado de una coordenada de un tablero en función de unas reglas y te devuelve 
 * si el siguiente estado será viva o muerta. Hereda de Regla
 */
public class Regla30 extends Regla {
	
	/**
	 * Es un método constructor que en este caso está vacío
	 */
	public Regla30() {}
	
	/**
	 * Es un método en el cual nos pasan un tablero y una coordenada y calcula en base a como está el 
	 * estado de esa posición y sus vecinas en el tablero cual va a ser el siguiente estado
	 * @param tablero Es el tablero en el cual vas a consultar los estados para aplicar las reglas
	 * @param posicion Es la coordenada la cual quieres saber cual va a ser su siguiente estado
	 * @return Devuelve un objeto de tipo EstadoCelda de si el siguiente estado está viva o muerta
	 * @throws ExcepcionPosicionFueraTablero Puede lanzar la excepción
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if (tablero != null && posicion != null) {
			EstadoCelda siguienteEstado = EstadoCelda.MUERTA;
			
			if (tablero.getPosicionesVecinasCCW(posicion).size() > 1) {
				EstadoCelda celda0 = tablero.getCelda(tablero.getPosicionesVecinasCCW(posicion).get(0));
				EstadoCelda celda1 = tablero.getCelda(tablero.getPosicionesVecinasCCW(posicion).get(1));
				if (tablero.getCelda(posicion) == EstadoCelda.MUERTA) {
					if ((celda0 == EstadoCelda.VIVA && celda1 == EstadoCelda.VIVA) || (celda0 == EstadoCelda.MUERTA && celda1 == EstadoCelda.MUERTA)) {
						siguienteEstado = EstadoCelda.MUERTA;
					}
					else {
						siguienteEstado = EstadoCelda.VIVA;
					}
				}
				else {
					if (celda0 == EstadoCelda.VIVA) {
						siguienteEstado = EstadoCelda.MUERTA;
					}
					else {
						siguienteEstado = EstadoCelda.VIVA;
					}
				}
				
				return siguienteEstado;
			}
			else {
				return siguienteEstado;
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
}
