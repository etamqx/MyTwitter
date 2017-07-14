package repo.exception;

public class UNCException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	
	public UNCException(String usuario){
		super("Usuário não cadastrado");
		this.usuario = usuario;
	}
	
	public String getMessage() {
		return "O usuário '" + this.usuario + "' não está cadastrado.";
	}
	
	public String getUsuario() {
		return this.usuario;
	}

}
