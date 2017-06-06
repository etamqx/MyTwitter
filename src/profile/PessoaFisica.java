package profile;

public class PessoaFisica extends Perfil {
	
	private long cpf;
	
	public PessoaFisica(String usuario, long cpf) {
		super(usuario);
		this.cpf = cpf;
	}
	
	long getCpf() {
		return this.cpf;
	}

	void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
