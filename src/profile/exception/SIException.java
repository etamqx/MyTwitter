package profile.exception;

public class SIException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	
	public SIException(String usuario) {
		super("Seguidor e seguido iguais");
		this.usuario = usuario;
	}
	
	public String alert() {
		return "Não é possível seguir a si próprio!";
	}
	
	public String getUsuario() {
		return this.usuario;
	}
}
