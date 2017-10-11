/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import java.util.*;

public class Tablero {
	
	private HashMap<Coordenada,EstadoCelda> celdas;
	
	private Coordenada dimensiones;
	
	public Tablero(Coordenada dimensiones) {
		celdas = new HashMap<Coordenada,EstadoCelda>();
		this.dimensiones = new Coordenada(dimensiones);
		
		for (int i = 0;i < dimensiones.getX();i++) {
			for (int j = 0;j < dimensiones.getY();j++) {
				Coordenada coordenada = new Coordenada(i,j);
				celdas.put(coordenada, EstadoCelda.MUERTA);
			}
		}
	}
	
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	
	public Collection<Coordenada> getPosiciones() {
		Collection<Coordenada> coordenadas = celdas.keySet();
		
		return coordenadas;
	}
	
	public EstadoCelda getCelda(Coordenada posicion) {
		if (contiene(posicion)) {
			EstadoCelda valorEstado = celdas.get(new Coordenada(posicion));
			return valorEstado;
		}
		else {
			muestraErrorPosicionInvalida(posicion);
			return null;
		}
	}
	
	private void muestraErrorPosicionInvalida(Coordenada c) {
		System.err.println("Error: La celda " + c.toString() + " no existe");
	}
	
	public void setCelda(Coordenada posicion, EstadoCelda e) {
		if (contiene(posicion)) {
			celdas.put(new Coordenada(posicion), e);
		}
		else {
			muestraErrorPosicionInvalida(posicion);
		}
	}
	
	public ArrayList <Coordenada> getPosicionesVecinasCCW(Coordenada posicion) {
		ArrayList<Coordenada> coordenadasVecinas = new ArrayList<Coordenada>();
		
		int x = posicion.getX() - 1;
		int y = posicion.getY() - 1;
		
		while (x <= posicion.getX()) {
			if (contiene(new Coordenada(x,y))) {
				coordenadasVecinas.add(new Coordenada(x,y));
			}
			
			if (y > posicion.getY()) {
				x++;
			}
			else {
				y++;
			}
		}
		while (x >= posicion.getX()) {
			if (contiene(new Coordenada(x,y))) {
				coordenadasVecinas.add(new Coordenada(x,y));
			}
			
			if (y < posicion.getY()) {
				 x--;
			}
			else {
				y--;
			}
		}
		
		return coordenadasVecinas;
	}
	
	public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial) {
		boolean existe = true;
		
		for (Coordenada coord : patron.getPosiciones()) {
			Coordenada coordenada = coord.suma(coordenadaInicial);
			if (!contiene(coordenada) && existe == true) {
				existe = false;
				muestraErrorPosicionInvalida(coordenada);
			}
		}
		
		if (existe == true) {
			for (Coordenada coord : patron.getPosiciones()) {
				Coordenada coordenada = coord.suma(coordenadaInicial);
				setCelda(coordenada, patron.getCelda(coord));
			}
		}
		
		return existe;
	}
	
	public boolean contiene(Coordenada posicion) {
		if (celdas.containsKey(new Coordenada(posicion))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		String cadenaTablero = "+";
		
		for (int i = 0;i < dimensiones.getX();i++) {
			cadenaTablero += "-";
		}
		
		cadenaTablero += "+\n";
		
		for (int i = 0;i < dimensiones.getY();i++) {
			cadenaTablero += "|";
			for (int j = 0;j < dimensiones.getX();j++) {
				Coordenada coord = new Coordenada(j,i);
				
				if (EstadoCelda.VIVA == getCelda(coord)) {
					cadenaTablero += "*";
				}
				else {
					cadenaTablero += " ";
				}
			}
			cadenaTablero += "|\n";
		}
		
		cadenaTablero += "+";
		
		for (int i = 0;i < dimensiones.getX();i++) {
			cadenaTablero += "-";
		}
		
		cadenaTablero += "+";
		
		return cadenaTablero;
	}
	
}
