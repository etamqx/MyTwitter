package profile.exception;

public class MFPException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	
	public MFPException(String mensagem) {
		super("Mensagem fora do padrão");
		this.mensagem = mensagem;
	}
	
	public String alert() {
		return "A mensagem possui mais do que 140 caracteres!";
	}
	
	public String getUsuario() {
		return this.mensagem;
	}

}
