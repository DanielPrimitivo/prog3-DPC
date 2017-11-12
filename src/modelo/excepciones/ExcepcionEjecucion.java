/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo.excepciones;

/**
 * Es una clase excepción, la cual tiene un método constructor que llama a la superclase. 
 * Hereda de RuntimeException
 */
public class ExcepcionEjecucion extends RuntimeException {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Es un método constructor en el cual nos pasan un string y llamamos al constructor 
	 * de la superclase pasandole ese string
	 * @param mensaje Es el parámetro que se va a pasar al constructor de la superclase
	 */
	public ExcepcionEjecucion(String mensaje) {
		super(mensaje);
	}
	
	/**
	 * Es un método constructor en el cual nos pasan un throwable y llamamos al constructor 
	 * de la superclase pasandole ese throwable
	 * @param causa Es el parámetro que se va a pasar al constructor de la superclase
	 */
	public ExcepcionEjecucion(Throwable causa) {
		super(causa);
	}
}
