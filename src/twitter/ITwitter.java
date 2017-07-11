package twitter;

import profile.*;

import java.util.Vector;

public interface ITwitter {
	
	void criarPerfil(Perfil usuario);
	
	void cancelarPerfil(String usuario);
	
	void tweetar(String usuario, String mensagem);
	
	Vector<Tweet> timeline(String usuario);
	
	Vector<Tweet> tweets(String usuario);
	
	void seguir(String seguidor, String seguido);
	
	int numeroSeguidores(String usuario);
	
	Vector<Perfil> seguidores(String usuario);
	
	Vector<Perfil> seguidos(String usuario);

}
