/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.excepciones;

public class ExcepcionGeneracion extends Exception {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcepcionGeneracion() {}
	
	public ExcepcionGeneracion(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionGeneracion(Throwable causa) {
		super(causa);
	}
}
