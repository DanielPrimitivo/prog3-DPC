/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo.excepciones;

/**
 * Es una clase excepción, la cual tiene un método constructor que llama a la 
 * superclase. Hereda de Exception
 */
public class ExcepcionCoordenadaIncorrecta extends Exception {
	
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Es un método constructor en el cual se llama al constructor de la superclase
	 */
	public ExcepcionCoordenadaIncorrecta() {
		super();
	}
}
