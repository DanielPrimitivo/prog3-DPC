package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Regla30 extends Regla {
	public Regla30() {}
	
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
