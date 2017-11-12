/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo.excepciones;

/**
 * Es una clase excepción, la cual tiene un método constructor que guarda los parametros, 
 * además tiene 3 getters, puede devolver un mensaje, el atributo x o el atributo y. 
 * Hereda de ExcepcionCoordenadaIncorrecta
 */
public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Es un atributo que contiene el valor de la abcisa
	 */
	private int x;
	
	/**
	 * Es un atributo que contiene el valor de la ordenada
	 */
	private int y;

	/**
	 * Es un método constructor en el cual nos pasan por parámetros dos enteros y los 
	 * guardamos en los atributos
	 * @param x Es el valor de la abcisa
	 * @param y Es el valor de la ordenada
	 */
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		super();
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Es un método getter el cual devuelve un mensaje de error
	 * @return devuelve un string que contiene el mensaje
	 */
	public String getMessage() {
		return "Error, coordenada 2D incorrecta";
	}
	
	/**
	 * Es un método getter el cual devuelve el atributo x
	 * @return devuelve el atributo x que es un entero
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Es un método getter el cual devuelve el atributo y
	 * @return devuelve el atributo y que es un entero
	 */
	public int getY() {
		return y;
	}
}
