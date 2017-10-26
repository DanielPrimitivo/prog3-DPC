package modelo.excepciones;

public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x;
	
	public ExcepcionCoordenada1DIncorrecta(int x) {
		super();
		
		this.x = x;
	}
	
	public String getMessage() {
		return "Error";
	}
	
	public int getX() {
		return x;
	}
}
