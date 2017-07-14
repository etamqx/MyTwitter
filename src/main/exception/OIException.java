package main.exception;

public class OIException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int opcao;
	
	public OIException(int opcao) {
		super("Opção inválida");
		this.opcao = opcao;
	}
	
	public int getOpcao() {
		return this.opcao;
	}

	public String getMessage() {
		return "Opção inválida! Tente novamente.";
	}
}
