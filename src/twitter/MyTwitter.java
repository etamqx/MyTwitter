package twitter;

import java.util.Vector;
import profile.*;
import profile.exception.*;
import repo.*;

public class MyTwitter implements ITwitter {
	
	private IRepositorioUsuario repositorio;
	
	
	public MyTwitter(IRepositorioUsuario repositorio) {
		this.repositorio = repositorio;
	}

	
	/* Método criarPerfil() {
	 * Cadastra o Perfil no repositório de usuários.
	 * Obs: só cadastra se não existir perfil com o mesmo nome. 
	 * Caso isso ocorra, a exceção perfil com mesmo nome PEException é lançada.
	 **/
	public void criarPerfil(Perfil usuario) throws PEException {
		String nomeUsuario = usuario.getUsuario();
		
		if (this.repositorio.buscar(nomeUsuario) == null) {
			this.repositorio.cadastrar(usuario);
			System.out.println("Usuário cadastrado com sucesso");
		}
		
		else {
			throw new PEException(nomeUsuario);
		}
	}
	
	/* Método cancelarPerfil()
	 * Desativa o perfil do usuário. Obedece às seguintes condições:
	 * 1) Se o perfil não existir, a exceção perfil inexistente PIException é lançada. 
	 * 2) Se exista mas estiver inativo, a exceção perfil desativado PDException é lançada.
	 * 3) Caso contrário, o perfil é desativado. 
	 * */
	public void cancelarPerfil(String usuario) throws PIException, PDException {
		Perfil perfilAtual = this.repositorio.buscar(usuario);
		
		if (perfilAtual == null) {
			throw new PIException(usuario);
		}
		
		else if (!perfilAtual.isAtivo()) {
			throw new PDException(perfilAtual.getUsuario());
		}
		
		else {
			perfilAtual.setAtivo(false);
		}
	}
	
	
	/* Método tweetar()
	 * Responsável pela postagem de mensagens. Utiliza os argumentos passados para instanciar um Tweet e postá-lo na 
	 * timeline do perfil do usuário e dos seus seguidores.
	 **/
	public void tweetar(String usuario, String mensagem) throws PIException, PDException, MFPException {
		Tweet tweet;
		Perfil perfilAtual;
		Vector<Perfil> seguidores;
		
		//Caso o usuário não esteja no repositório
		if (this.repositorio.buscar(usuario) == null) {
			throw new PIException(usuario);
		}	
		
		else {
			perfilAtual = this.repositorio.buscar(usuario);
			seguidores = perfilAtual.getSeguidores();
			
			//Se o perfil estiver inativo
			if (!perfilAtual.isAtivo()){
				throw new PDException(perfilAtual.getUsuario());
			}
			
			//Se a mensagem estiver fora do padrão
			else if ((mensagem.length() < 1) || (mensagem.length() > 140)) {
				throw new MFPException(perfilAtual.getUsuario());
			}
			
			else {
				tweet = new Tweet(usuario, mensagem);
				perfilAtual.addTweet(tweet);
				
				for(Perfil seguidor: seguidores) {
					seguidor.addTweet(tweet);
				}
			}
		}
		
	}
	
	/** Método timeline()
	 * Recupera todos os tweets	da timeline do perfil do usuario informado.
	 */
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
		Perfil perfilAtual;
		
		//Caso não exista o perfil no repo
		if (this.repositorio.buscar(usuario) == null) {
			throw new PIException(usuario);
		}
		
		else {
			perfilAtual = this.repositorio.buscar(usuario);
			
			if(!perfilAtual.isAtivo()) {
				throw new PDException(usuario);
			}
			
			else {
				return perfilAtual.getTimeline();
			}
		}
		
	}
	
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException {
		//...
	}
	
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException {
		//...
	}
	
	public int numeroSeguidores(String usuario) throws PIException, PDException {
		//...
	}
	
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
		//...
	}
	
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException {
		//...
	}
}
