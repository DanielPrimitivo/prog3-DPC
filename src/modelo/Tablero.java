/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import java.util.*;

/**
 * Esta clase permite crear un HashMap (que es una matriz de celdas) en la cual se inicializa rellena con 
 * unas dimensiones, tiene getters y setters los cuales permiten modificar los estados de las celdas, 
 * obtener coordenas y los estados, además de poder preguntar cierta información y mostrar errores
 */
public class Tablero {
	
	/**
	 * Es un atributo el cual es una mapa que contiene una clave que es la coordenada y un valor asociado 
	 * a la clave que es el estado en el que se encuentra esa coordenada
	 */
	private HashMap<Coordenada,EstadoCelda> celdas;
	
	/**
	 * Es un atributo el cual es de tipo coordenada y contiene el tamaño del tablero
	 */
	private Coordenada dimensiones;
	
	/**
	 * Es el método constructor en el cual recibes por parametro las dimensiones que lo guardamos en el 
	 * atributo y rellenamos el HashMap con esas dimensiones y con estado de cada coordenada a muerta
	 * @param dimensiones Es el tamaño del tablero
	 */
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
	
	/**
	 * Es un método getter que devuelve las dimensiones del tablero que es de tipo coordenada
	 * @return devuelve una copia del campo dimensiones
	 */
	public Coordenada getDimensiones() {
		return new Coordenada(dimensiones);
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
	 */
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
	
	/**
	 * Es un método en el cual se imprime un mensaje por la salida de error indicando que la coordenada 
	 * que te pasan no existe en el tablero
	 * @param c Es la coordenada la cual no existe y debes mostrar en el error
	 */
	private void muestraErrorPosicionInvalida(Coordenada c) {
		System.err.println("Error: La celda " + c.toString() + " no existe");
	}
	
	/**
	 * Es un método setter en el cual nos pasan una posicion y un estado, debemos comprobar si existe esa 
	 * posición en tablero, si es así entonces ponemos el nuevo estado a esa coordenada, en caso contrario
	 * llamamos al método que muestra por pantalla el error
	 * @param posicion Es la coordenada la cual queremos actualizarle su estado asociado
	 * @param e Es el estado que queremos poner a la coordenada indicada
	 */
	public void setCelda(Coordenada posicion, EstadoCelda e) {
		if (contiene(posicion)) {
			celdas.put(new Coordenada(posicion), e);
		}
		else {
			muestraErrorPosicionInvalida(posicion);
		}
	}
	
	/**
	 * Es un método getter en el cual nos pasan una posición y recorremos su alrededor en sentido contrario 
	 * a las agujas del reloj para ver si existen esas posiciones y meterlas en un ArrayList
	 * @param posicion Es la coordenada central la cual se va a obtener sus coordenas de alrededor
	 * @return Devuelve un ArrayList con las posiciones de alrededor a la pasada por parámetro
	 */
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
	
	/**
	 * Es un método en el cual nos pasan un patron y una coordenada inicial, hay que comprobar si el patron 
	 * pasado a partir de la coordenada cabe en el tablero que tenemos, en caso de que no quepa hay que mostrar 
	 * la primera coordenada que se salga y devolver false, en caso contrario lo cargamos y devolvemos true
	 * @param patron Es un objeto de tipo Patron el cual queremos cargar (meter actualizando) en tablero
	 * @param coordenadaInicial Es un objeto de tipo coordenada que pasa la coordenada superior izquierda de patron
	 * @return Devuelve un valor booleano en función de si se puede cargar o no
	 */
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
	
	/**
	 * Es un método en el cual nos pasan una posición y evaluamos si está contenida en tablero o no, devolviendo 
	 * true si se puede cargar o false en caso contrario
	 * @param posicion Es la coordenada la cual queremos saber si existe en el tablero
	 * @return Devuelve un valor de tipo booleano de si la contiene o no
	 */
	public boolean contiene(Coordenada posicion) {
		if (celdas.containsKey(new Coordenada(posicion))) {
			return true;
		}
		else {
			return false;
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
