package profile.exception;

public class PIException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	
	public PIException(String usuario) {
		super("Perfil inexistente");
		this.usuario = usuario;
	}
	
	public String alert() {
		return "O usuário "+ this.usuario +" não existe.";
	}
	
	public String getUsuario() {
		return this.usuario;
	}

}
