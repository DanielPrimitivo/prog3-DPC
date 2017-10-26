package modelo.excepciones;

import modelo.*;

public class ExcepcionPosicionFueraTablero extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Coordenada dimensiones;
	
	private Coordenada coordenada;
	
	public ExcepcionPosicionFueraTablero(Coordenada dimensiones, Coordenada coordenada) {
		super();
		
		this.dimensiones = dimensiones;
		this.coordenada = coordenada;
	}
	
	public String getMessage() {
		return "Error";
	}
	
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	
	public Coordenada getCoordenada() {
		return coordenada;
	}
}
