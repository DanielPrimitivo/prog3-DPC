package modelo.excepciones;

public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x;
	
	private int y;

	
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		super();
		
		this.x = x;
		this.y = y;
	}
	
	public String getMessage() {
		return "Error";
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
