package profile.exception;

public class PIException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	
	public PIException(String usuario) {
		super("Perfil inexistente");
		this.usuario = usuario;
	}
		
	public String getMessage() {
		return "O(s) usuário(s) "+ this.usuario +" não existe(m).";
	}
	
	public String getUsuario() {
		return this.usuario;
	}

}
