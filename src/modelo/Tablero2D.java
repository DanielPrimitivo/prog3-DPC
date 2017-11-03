package modelo;

import modelo.excepciones.*;

public abstract class Tablero2D extends Tablero{
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(new Coordenada2D(ancho,alto));
		
		for (int i = 0;i < ancho;i++) {
			for (int j = 0;j < alto;j++) {
				try {
					Coordenada2D coordenada = new Coordenada2D(i,j);
					celdas.put(coordenada, EstadoCelda.MUERTA);
				}
				catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
		}
	}
}
