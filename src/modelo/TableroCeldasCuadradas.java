package modelo;

import java.util.*;

import modelo.excepciones.*;

public class TableroCeldasCuadradas extends Tablero2D {
	public TableroCeldasCuadradas(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(ancho, alto);
	}
	
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if (posicion != null) {
			Coordenada2D c = (Coordenada2D) posicion;
			if (contiene(new Coordenada2D(c))) {
				ArrayList<Coordenada> coordenadasVecinas = new ArrayList<Coordenada>();
				Coordenada2D coord;
				
				int x = c.getX() - 1;
				int y = c.getY() - 1;
				
				while (x <= c.getX()) {
					if (x >= 0 && y >= 0) {
						try {
							coord = new Coordenada2D(x,y);
						}
						catch (ExcepcionCoordenadaIncorrecta e) {
							throw new ExcepcionEjecucion(e);
						}
						
						if (contiene(coord)) {
							coordenadasVecinas.add(coord);
						}
					}
					
					if (y > c.getY()) {
						x++;
					}
					else {
						y++;
					}
				}
				while (x >= c.getX()) {
					if (x >= 0 && y >= 0) {
						try {
							coord = new Coordenada2D(x,y);
						}
						catch (ExcepcionCoordenadaIncorrecta e) {
							throw new ExcepcionEjecucion(e);
						}
						
						if (contiene(coord)) {
							coordenadasVecinas.add(coord);
						}
					}
					
					if (y < c.getY()) {
						 x--;
					}
					else {
						y--;
					}
				}
				
				return coordenadasVecinas;
			}
			else {
				throw new ExcepcionPosicionFueraTablero(dimensiones, c);
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es un método en el cual vamos a guardar en un objeto de tipo String todo lo que debe mostrar posteriormente 
	 * por pantalla, en caso de que la coordenada este viva entonces ponemos un "*" y en caso de muerta " "
	 * @return Devuelve la cadena (String) rellenada con toda la estructura que luego se mostrará por pantalla
	 */
	@Override
	public String toString() {
		String cadenaTablero = "+";
		Coordenada2D c = (Coordenada2D) dimensiones;
		
		for (int i = 0;i < c.getX();i++) {
			cadenaTablero += "-";
		}
		
		cadenaTablero += "+\n";
		
		for (int i = 0;i < c.getY();i++) {
			cadenaTablero += "|";
			for (int j = 0;j < c.getX();j++) {
				try {
					Coordenada2D coord = new Coordenada2D(j,i);
					
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
		}
		
		cadenaTablero += "+";
		
		for (int i = 0;i < c.getX();i++) {
			cadenaTablero += "-";
		}
		
		cadenaTablero += "+\n";
		
		return cadenaTablero;
	}
}
