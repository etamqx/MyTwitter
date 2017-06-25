<<<<<<< HEAD
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
=======
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
>>>>>>> cb5eace0f48cf111b1fc9bfa48918417416a0648
