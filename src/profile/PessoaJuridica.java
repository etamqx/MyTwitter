package profile;

public class PessoaJuridica extends Perfil {
	
	private long cpnj;
	
	public PessoaJuridica(String usuario, long cpnj) {
		super(usuario);
		this.cpnj = cpnj;
	}

	long getCpnj() {
		return this.cpnj;
	}
	
	void setCpnj(long cpnj) {
		this.cpnj = cpnj;
	}
}
