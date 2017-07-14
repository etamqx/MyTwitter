package profile;

import java.util.Vector;

import profile.exception.SIException;

public abstract class Perfil {
	
	private String usuario;
	
	private Vector<Perfil> seguidos;
	
	private Vector<Perfil> seguidores;
	
	private Vector<Tweet> timeline;
	
	private boolean ativo;
	
	
	/* Método contrutor Perfil()
	 * Recebe o nome do usuário, inicializa os vetores e torna o perfil ativo.
	 * */
	public Perfil(String usuario) {
		this.usuario = usuario;
		this.seguidos = new Vector<Perfil>();
		this.seguidores = new Vector<Perfil>();
		this.timeline = new Vector<Tweet>();
		this.setAtivo(true);
	}
	
	
	/* Método addSeguidor()
	 * Adiciona seguidores(objetos do tipo Perfil) no atributo seguidores(Vector de Perfil)
	 * (Considera que a condição de nome diferente já foi atendida.)
	 * */
	public void addSeguidor(Perfil usuario) throws SIException {
		if (!this.usuario.equals(usuario)) {	
			this.seguidores.add(usuario);
		}
		
		else {
			throw new SIException(usuario.getUsuario());
		}
	}
	
	public void addSeguido(Perfil usuario) {
		this.seguidos.add(usuario);
	}

	/* Método addTweet()
	 * Adiciona tweets no atributo timeline (vector de Tweet)
	 * */
	public void addTweet(Tweet tweet) {
		this.timeline.add(tweet);
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public Vector<Perfil> getSeguidores() {
		return this.seguidores;
	}

	public Vector<Perfil> getSeguidos() {
		return this.seguidos;
	}
	
	public Vector<Tweet> getTimeline() {
		return this.timeline;
	}
	
	public void setAtivo(boolean valor) {
		this.ativo = valor;
	}
	
	public boolean isAtivo() {
		if(this.ativo == true) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
}
