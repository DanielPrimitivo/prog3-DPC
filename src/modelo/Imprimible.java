/**
 * @author Daniel Primitivo Cano - DNI: 53979721D
 */

package modelo;

/**
 * Esta interfaz permite generar cadenas en los objetos que la implementen, el método que tiene 
 * devuelve un tipo String y las clases que implementen esta interfaz están obligadas a crear 
 * este método
 */
public interface Imprimible {
	
	/**
	 * Es un método abstracto por lo tanto no está implementado aquí pero si debe implementarse 
	 * en cada clase que implemente a la interfaz y deberá generar una cadena
	 * @return No devuelve nada porque es un método abstracto
	 */
	public abstract String generaCadena();
}
