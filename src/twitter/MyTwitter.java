package twitter;

import java.util.Vector;
import profile.Perfil;
import profile.Tweet;

public class MyTwitter implements ITwitter {
	
	private IRepositorio repositorio;
	
	public MyTwitter(IRepositorioUsuario repositorio) {
		this.repositorio = repositorio;
	}

	public void criarPerfil(Perfil usuario) {
		//...
	}
	
	public void cancelarPerfil(String usuario) {
		//...
	}
	
	public void tweetar(String usuario, String mensagem) {
		//...
	}
	
	public Vector<Tweet> timeline(String usuario) {
		//...
	}
	
	public Vector<Tweet> tweets(String usuario) {
		//...
	}
	
	public void seguir(String seguidor, String seguido) {
		//...
	}
	
	public int numeroSeguidores(String usuario) {
		//...
	}
	
	public Vector<Perfil> seguidores(String usuario) {
		//...
	}
	
	public Vector<Perfil> seguidos(String usuario) {
		//...
	}
}
