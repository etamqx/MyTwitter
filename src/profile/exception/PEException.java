package profile.exception;

public class PEException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	
	public PEException(String usuario) {
		super("Perfil já existe");
		this.usuario = usuario;
	}

	public String alert() {
		return "O usuário " + this.usuario + " já existe.";
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
}
