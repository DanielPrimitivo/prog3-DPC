/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo.excepciones;

/**
 * Es una clase excepción, la cual tiene un método constructor que llama a la superclase. 
 * Hereda de ExcepcionEjecucion
 */
public class ExcepcionArgumentosIncorrectos extends ExcepcionEjecucion {
	
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Es un método constructor en el cual se llama al constructor de la superclase pasandole 
	 * un string
	 */
	public ExcepcionArgumentosIncorrectos() {
		super("Error, argumentos incorrectos");
	}
}
