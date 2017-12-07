/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.excepciones;

/**
 * Es una clase excepción, la cual tiene un método constructor que llama a la superclase. 
 * Hereda de Exception
 */
public class ExcepcionLectura extends Exception{

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Es un método constructor vacío, lo único que realiza es crear un objeto de la clase
	 */
	public ExcepcionLectura() {}
	
	/**
	 * Es un método constructor en el cual nos pasan un string y llamamos al constructor 
	 * de la superclase pasandole ese string
	 * @param mensaje Es el parámetro que se va a pasar al constructor de la superclase
	 */
	public ExcepcionLectura(String mensaje) {
		super(mensaje);
	}
	
	/**
	 * Es un método constructor en el cual nos pasan un throwable y llamamos al constructor 
	 * de la superclase pasandole ese throwable
	 * @param causa Es el parámetro que se va a pasar al constructor de la superclase
	 */
	public ExcepcionLectura(Throwable causa) {
		super(causa);
	}
}
