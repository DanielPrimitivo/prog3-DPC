/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package entradasalida.excepciones;

public class ExcepcionLectura extends Exception{

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
public ExcepcionLectura() {}
	
	public ExcepcionLectura(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionLectura(Throwable causa) {
		super(causa);
	}
}
