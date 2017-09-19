package modelo;

public class Coordenada {
	private static int NUMERO_COORDENADAS = 0;
	private int x;
	private int y;
	
	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
		NUMERO_COORDENADAS++;
	};
	public Coordenada(Coordenada otra) {
		this.x = otra.x;
		this.y = otra.y;
		NUMERO_COORDENADAS++;
	};
	public static int getNumeroCoordenadas() {
		return NUMERO_COORDENADAS;
	};
	public String toString() {
		return "(" + x + "," + y + ")";
	};
	public boolean equals(Object otro) {
		if (otro == this) {
			return true;
		}
		if (otro == null) {
			return false;
		}
		if (!(otro instanceof Coordenada)) {
			return false;
		}
		
		Coordenada elotro = (Coordenada) otro;
		
		return (x == elotro.x && y == elotro.y);
	};
	public int getX() {
		return x;
	};
	public int getY() {
		return y;
	};
	public Coordenada suma(Coordenada otra) {
		return new Coordenada(x + otra.x, y + otra.y);
	};
}
