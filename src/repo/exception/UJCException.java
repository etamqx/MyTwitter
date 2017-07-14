package repo.exception;

public class UJCException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	
	public UJCException(String usuario){
		super("Usuário já cadastrado");
		this.usuario = usuario;
	}
	
	public String getMessage() {
		return "O usuário '" + this.usuario + "' já está cadastrado.";
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
}
