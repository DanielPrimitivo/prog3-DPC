package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Tablero1D extends Tablero {
	public Tablero1D(int ancho) throws ExcepcionCoordenadaIncorrecta {
		super(new Coordenada1D(ancho));
		
		for (int i = 0;i < ancho;i++) {
			try {
				Coordenada1D coordenada = new Coordenada1D(i);
				celdas.put(coordenada, EstadoCelda.MUERTA);
			}
			catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
	}
	
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if (posicion != null) {
			Coordenada1D c = (Coordenada1D) posicion;
			if (contiene(new Coordenada1D(c))) {
				ArrayList<Coordenada> coordenadasVecinas = new ArrayList<Coordenada>();
				
				Coordenada1D coord;
				
				int x = c.getX() - 1;
				
				if (x >= 0) {
					try {
						coord = new Coordenada1D(x);
					}
					catch (ExcepcionCoordenadaIncorrecta e) {
						throw new ExcepcionEjecucion(e);
					}
					
					if (contiene(coord)) {
						coordenadasVecinas.add(coord);
					}
					
					x = c.getX() + 1;
					
					try {
						coord = new Coordenada1D(x);
					}
					catch (ExcepcionCoordenadaIncorrecta e) {
						throw new ExcepcionEjecucion(e);
					}
					
					if (contiene(coord)) {
						coordenadasVecinas.add(coord);
					}
				}
				
				return coordenadasVecinas;
			}
			else {
				throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	public String toString() {
		String cadenaTablero = "|";
		Coordenada1D c = (Coordenada1D) dimensiones;
		
		for (int i = 0;i < c.getX();i++) {
			try {
				Coordenada1D coord = new Coordenada1D(i);
				
				try {
					if (EstadoCelda.VIVA == getCelda(coord)) {
						cadenaTablero += "*";
					}
					else {
						cadenaTablero += " ";
					}
				}
				catch (ExcepcionPosicionFueraTablero e) {
					throw new ExcepcionEjecucion(e);
				}
			}
			catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		
		cadenaTablero += "|\n";
		
		return cadenaTablero;
	}
}
