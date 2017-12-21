/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

import modelo.excepciones.*;

/**
 * Esta clase permite crear un objeto Regla el cual tiene un constructor vacío y un getter que es 
 * un método abstracto
 */
public abstract class Regla<TipoCoordenada extends Coordenada> {
	
	/**
	 * Es un método constructor que en este caso está vacío
	 */
	public Regla() {}
	
	/**
	 * Es un método en el cual nos pasan un tablero y una coordenada, pero es abstracto, por lo que 
	 * debe estar implementado en las subclases
	 * @param tablero Es el tablero en el cual vas a consultar los estados para aplicar las reglas
	 * @param posicion Es la coordenada la cual quieres saber cual va a ser su siguiente estado
	 * @return No devuelve nada ya que es un método abstracto
	 * @throws ExcepcionPosicionFueraTablero Puede lanzar la excepción
	 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero<TipoCoordenada> tablero, TipoCoordenada posicion) throws ExcepcionPosicionFueraTablero;
}
