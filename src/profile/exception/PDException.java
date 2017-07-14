package profile.exception;

public class PDException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	
	public PDException(String usuario) {
		super("Perfil inativo");
		this.usuario = usuario;
	}
	
	public String getMessage() {
		return "O usuário " + this.usuario + "está atualmente desativado";
	}
	
	public String getUsuario() {
		return this.usuario;
	}

}
