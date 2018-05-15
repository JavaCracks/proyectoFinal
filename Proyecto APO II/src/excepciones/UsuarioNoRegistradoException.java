package excepciones;

public class UsuarioNoRegistradoException extends Exception {

	
	public UsuarioNoRegistradoException(String nombre) {
		
	super("El usuario con el nombre "+nombre+ " no se encuentra registrado");	
		
	}
	
}
