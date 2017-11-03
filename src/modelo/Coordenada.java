package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

public abstract class Coordenada {
	public Coordenada() {}
	
	public abstract Coordenada suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta;
}
