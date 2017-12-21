/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo.d2;

import java.util.*;

import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto de tipo TableroCeldasCuadradas el cual tiene un constructor para 
 * crear un Tablero y rellenarlo, tiene un getter que devuelve un ArrayList de coordenadas y un método 
 * toString para poder mostrar información, se inicializa a estadocelda muerta. Hereda de Tablero2D
 */
public class TableroCeldasCuadradas extends Tablero2D implements Imprimible{
	
	/**
	 * Es un método constructor en el cual te pasan unos parámetros que sirven para llamar al constructor 
	 * de la superclase y crear un objeto de tipo Tablero2D
	 * @param ancho Es el valor de x la abcisa
	 * @param alto Es el valor de y la ordenada
	 * @throws ExcepcionCoordenadaIncorrecta Puede lanzar la excepción
	 */
	public TableroCeldasCuadradas(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(ancho, alto);
	}
	
	/**
	 * Es un método en el cual nos pasan posicion que es una coordenada, debemos obtener las coordenadas de 
	 * alrededor en sentido contrario a las agujas del reloj metiendola en un ArrayList para devolverlo
	 * @param posicion Es la coordenada central a partir de la cual se obtiene información
	 * @return devuelve un ArrayList de coordenadas
	 * @throws ExcepcionPosicionFueraTablero Puede lanzar la excepción
	 */
	public ArrayList<Coordenada2D> getPosicionesVecinasCCW(Coordenada2D posicion) throws ExcepcionPosicionFueraTablero {
		if (posicion != null) {
			Coordenada2D c = (Coordenada2D) posicion;
			if (contiene(new Coordenada2D(c))) {
				ArrayList<Coordenada2D> coordenadasVecinas = new ArrayList<Coordenada2D>();
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
	
	/**
	 * Es un método en el cual llamamos al toString y va a guardar en un objeto de tipo String todo lo que 
	 * debe mostrar posteriormente por pantalla, en caso de que la coordenada este viva entonces ponemos un 
	 * "*" y en caso de muerta " "
	 * @return Devuelve la cadena (String) rellenada con toda la estructura que luego se mostrará por pantalla
	 */
	public String generaCadena() {
		return toString();
	}
}
