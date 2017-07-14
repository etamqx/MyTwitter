package profile.exception;

public class MFPException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	
	public MFPException(String mensagem) {
		super("Mensagem fora do padrão");
		this.mensagem = mensagem;
	}
	
	public String getMessage() {
		return "A mensagem possui um número de caracteres inválido!";
	}
	
	public String getMensagem() {
		return this.mensagem;
	}

}
