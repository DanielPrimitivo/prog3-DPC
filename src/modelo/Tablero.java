/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import java.util.*;
import modelo.excepciones.*;

/**
 * Esta clase permite crear un HashMap (que es una matriz de celdas) en la cual se inicializa rellena con 
 * unas dimensiones, tiene getters y setters los cuales permiten modificar los estados de las celdas, 
 * obtener coordenas y los estados, además de poder preguntar cierta información y mostrar errores
 */
public abstract class Tablero {
	
	/**
	 * Es un atributo el cual es una mapa que contiene una clave que es la coordenada y un valor asociado 
	 * a la clave que es el estado en el que se encuentra esa coordenada
	 */
	protected HashMap<Coordenada,EstadoCelda> celdas;
	
	/**
	 * Es un atributo el cual es de tipo coordenada y contiene el tamaño del tablero
	 */
	protected Coordenada dimensiones;
	
	/**
	 * Es el método constructor en el cual recibes por parametro las dimensiones que lo guardamos en el 
	 * atributo
	 * @param dimensiones Es el tamaño del tablero
	 */
	protected Tablero(Coordenada dimensiones) {
		if (dimensiones != null) {
			celdas = new HashMap<Coordenada,EstadoCelda>();
			this.dimensiones = dimensiones;
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es un método getter que devuelve las dimensiones del tablero que es de tipo coordenada
	 * @return devuelve una copia del campo dimensiones
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	
	/**
	 * Es un método getter en el cual el HashMap lo pasamos a un collection con el método keySet() de la 
	 * clase HashMap con el cual obtenemos todas las coordenadas que contiene
	 * @return devuelve un collection que contiene todas las coordenadas del tablero
	 */
	public Collection<Coordenada> getPosiciones() {
		Collection<Coordenada> coordenadas = celdas.keySet();
		
		return coordenadas;
	}
	
	/**
	 * Es un método getter en el cual nos pasan una posición, consultamos si está dentro de tablero, si 
	 * está entonces obtenemos el estado asociado a la coordenada, en caso contrario mostramos un error 
	 * y devolvemos null
	 * @param posicion Es la posicion la cual debes obtener su estado
	 * @return Devuelve un objeto de tipo EstadoCelda o en caso de no existir entonces devuelve null
	 * @throws ExcepcionPosicionFueraTablero Puede lanzar la excepción
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if (posicion != null) {
			if (contiene(posicion)) {
				EstadoCelda valorEstado = celdas.get(posicion);
				return valorEstado;
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
	 * Es un método setter en el cual nos pasan una posicion y un estado, debemos comprobar si existe esa 
	 * posición en tablero, si es así entonces ponemos el nuevo estado a esa coordenada, en caso contrario
	 * llamamos al método que muestra por pantalla el error
	 * @param posicion Es la coordenada la cual queremos actualizarle su estado asociado
	 * @param e Es el estado que queremos poner a la coordenada indicada
	 * @throws ExcepcionPosicionFueraTablero Puede lanzar la excepción
	 */
	public void setCelda(Coordenada posicion, EstadoCelda e) throws ExcepcionPosicionFueraTablero {
		if(posicion != null && e != null) {
			if (contiene(posicion)) {
				celdas.put(posicion, e);
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
	 * Es un método getter en el cual nos pasan una posición, pero es un método abstracto, por lo que debe 
	 * estar implementado en las subclases
	 * @param posicion Es la coordenada central a partir de la cual se va a obtener información
	 * @return No devuelve nada ya que es un método abstracto
	 * @throws ExcepcionPosicionFueraTablero Puede lanzar la excepción
	 */
	public abstract ArrayList <Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero;
		
	
	/**
	 * Es un método en el cual nos pasan un patron y una coordenada inicial, hay que comprobar si el patron 
	 * pasado a partir de la coordenada cabe en el tablero que tenemos, en caso de que no quepa hay que mostrar 
	 * la primera coordenada que se salga, en caso contrario lo cargamos
	 * @param patron Es un objeto de tipo Patron el cual queremos cargar (meter actualizando) en tablero
	 * @param coordenadaInicial Es un objeto de tipo coordenada que pasa la coordenada superior izquierda de patron
	 * @throws ExcepcionPosicionFueraTablero Puede lanzar la excepción
	 */
	public void cargaPatron(Patron patron, Coordenada coordenadaInicial) throws ExcepcionPosicionFueraTablero {
		if (patron != null && coordenadaInicial != null) {
			
			for (Coordenada coord : patron.getPosiciones()) {
				try {
					Coordenada coordenada = coord.suma(coordenadaInicial);
					
					if (!contiene(coordenada)) {
						throw new ExcepcionPosicionFueraTablero(dimensiones, coordenada);
					}
				}
				catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
				
			}
			
			for (Coordenada coord : patron.getPosiciones()) {
				try {
					Coordenada coordenada = coord.suma(coordenadaInicial);
					setCelda(coordenada, patron.getCelda(coord));
				}
				catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Es un método en el cual nos pasan una posición y evaluamos si está contenida en tablero o no, devolviendo 
	 * true si se puede cargar o false en caso contrario
	 * @param posicion Es la coordenada la cual queremos saber si existe en el tablero
	 * @return Devuelve un valor de tipo booleano de si la contiene o no
	 */
	public boolean contiene(Coordenada posicion) {
		if (posicion != null) {
			if (celdas.containsKey(posicion)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
}
