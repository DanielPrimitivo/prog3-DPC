/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import java.util.ArrayList;

import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto de tipo Tablero1D el cual tiene un constructor para crear 
 * un Tablero y rellenarlo, tiene un getter que devuelve un ArrayList de coordenadas y un método 
 * toString para poder mostrar información, se inicializa a estadocelda muerta. Hereda de Tablero
 */
public class Tablero1D extends Tablero {
	
	/**
	 * Es un método constructor en el cual te pasan uno parámetro que sirve para llamar al constructor 
	 * de la superclase y crear un objeto de tipo Tablero2D
	 * @param ancho Es el valor de x la abcisa
	 * @throws ExcepcionCoordenadaIncorrecta Puede lanzar la excepción
	 */
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
	
	/**
	 * Es un método en el cual nos pasan posicion que es una coordenada, debemos obtener la coordenada 
	 * de la izquierda y la derecha metiendola en un ArrayList para devolverlo
	 * @param posicion Es la coordenada central a partir de la cual se obtiene información
	 * @return devuelve un ArrayList de coordenadas
	 * @throws ExcepcionPosicionFueraTablero Puede lanzar la excepción
	 */
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
				}
					
				x = c.getX() + 1;
				
				if(x >= 0) {
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
	
	/**
	 * Es un método en el cual vamos a guardar en un objeto de tipo String todo lo que debe mostrar posteriormente 
	 * por pantalla, en caso de que la coordenada este viva entonces ponemos un "*" y en caso de muerta " "
	 * @return Devuelve la cadena (String) rellenada con toda la estructura que luego se mostrará por pantalla
	 */
	@Override
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
