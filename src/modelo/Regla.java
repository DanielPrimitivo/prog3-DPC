package modelo;

import modelo.excepciones.*;

public abstract class Regla {
	public Regla() {}
	
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero;
}
