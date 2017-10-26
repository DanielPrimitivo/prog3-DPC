package modelo.excepciones;

public class ExcepcionEjecucion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionEjecucion(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionEjecucion(Throwable causa) {
		super(causa);
	}
}
