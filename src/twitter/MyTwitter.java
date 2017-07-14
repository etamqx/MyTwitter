package twitter;

import java.util.Vector;
import profile.*;
import profile.exception.*;
import repo.*;
import repo.exception.*;

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
		
		try {
			this.repositorio.cadastrar(usuario);
			System.out.println("Usuário cadastrado com sucesso.");
			
		} catch (UJCException ujce){
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
			System.out.println("Perfil desativado.");
		}
	}
	
	
	/* Método tweetar()
	 * Responsável pela postagem de mensagens. Utiliza os argumentos passados para instanciar um Tweet e postá-lo na 
	 * timeline do perfil do usuário e dos seus seguidores.
	 **/
	public void tweetar(String usuario, String mensagem) throws PIException, PDException, MFPException {
		Perfil perfilAtual = this.repositorio.buscar(usuario);
		Tweet tweet;
		Vector<Perfil> seguidores;
		
		//Caso o usuário não esteja no repositório
		if (perfilAtual == null) {
			throw new PIException(usuario);
		}	
		
		else {
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
				
				System.out.println("Tweet realizado.");
			}
		}
		
	}
	
	/** Método timeline()
	 * Recupera todos os tweets	da timeline do perfil do usuario informado.
	 */
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
		Perfil perfilAtual = this.repositorio.buscar(usuario);
		
		//Caso não exista o perfil no repo
		if (perfilAtual == null) {
			throw new PIException(usuario);
		}
		
		else {
			if(!perfilAtual.isAtivo()) {
				throw new PDException(perfilAtual.getUsuario());
			}
			
			else {
				return perfilAtual.getTimeline();
			}
		}
		
	}
	
	/** Método tweets()
	 *  Recupera todos os tweets que um determinado usuário postou.
	 */
	
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException {
		Perfil perfilAtual = this.repositorio.buscar(usuario);
		Vector<Tweet> tweets = new Vector<Tweet>();
		
		if (perfilAtual == null) {
			throw new PIException(usuario);
		}
		
		else if (!perfilAtual.isAtivo()) {
			throw new PDException(perfilAtual.getUsuario());
		}
		
		else {
			for (Tweet tweet: perfilAtual.getTimeline()) {
				if(tweet.getUsuario().equals(usuario)) {
					tweets.add(tweet);
				}
			}
			
			return tweets;
		}
		
	}
	
	/** Método seguir()
	 * Inclui o perfil do usuário seguidor na lista de seguidores do usuário seguido,
	 * e também inclui o usuário seguido na lista de seguidos do usuário seguidor. 
	 */	
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException {
		Perfil perfilSeguidor = this.repositorio.buscar(seguidor); 
		Perfil perfilSeguido = this.repositorio.buscar(seguido);
		
		//Se os nomes são diferentes
		if(!seguidor.equals(seguido)) {
			//Se ambos existem
			if ((perfilSeguidor != null) && (perfilSeguido != null)){
				//Se ambos estão ativos, adiciona normalmente
				if ((perfilSeguidor.isAtivo()) && (perfilSeguido.isAtivo())) {
					perfilSeguidor.addSeguido(perfilSeguido);
					perfilSeguido.addSeguidor(perfilSeguidor);
					
					System.out.println("Você agora está seguindo " + seguido +" e seus tweets \naparecerão na sua timeline a partir de agora.");
				}
				
				//Um deles no mínimo está desativado
				else {
					if (!perfilSeguidor.isAtivo()){
						throw new PDException(seguidor);
					}
					else {
						throw new PDException(seguido);
					}
				}
				
			}
			//Um deles no mínimo não existe
			else {
				if (perfilSeguidor == null) {
					throw new PIException(seguidor);
				}
				else {
					throw new PIException(seguido);
				}
			}
		}
		
		//No caso de nomes iguais
		else {
			throw new SIException(seguido);
		}
		
	}
	
	/** Método numeroSeguidores()
	 * Devolve o número de seguidores do perfil do usuário informado.
	 */
	public int numeroSeguidores(String usuario) throws PIException, PDException {
		Perfil perfilAtual = this.repositorio.buscar(usuario);
		int numeroSeguidores;
		
		if (perfilAtual != null) {
			if (perfilAtual.isAtivo()) {
				numeroSeguidores = 0;
				for (Perfil perfil: perfilAtual.getSeguidores()){
					if ((perfil != null) && (perfil.isAtivo())) {
						numeroSeguidores++;
					}
				}
				
				return numeroSeguidores;
			}
			
			else {
				throw new PDException(perfilAtual.getUsuario());
			}
		}
		
		else {
			throw new PIException(usuario);
		}
	}
	
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
		Perfil perfilAtual = this.repositorio.buscar(usuario);
		Vector<Perfil> listaSeguidores = new Vector<Perfil>();
		
		if (perfilAtual != null) {
			if (perfilAtual.isAtivo()) {
				for (Perfil perfil: perfilAtual.getSeguidores()) {
					if ((perfil != null) && (perfil.isAtivo())) {
						listaSeguidores.add(perfil);
					}
				}
				return listaSeguidores;
			}
			else {
				throw new PDException(perfilAtual.getUsuario());
			}
		}	
		else {
			throw new PIException(usuario);
		}
		
	}
	
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException {
		Perfil perfilAtual = this.repositorio.buscar(usuario);
		Vector<Perfil> listaSeguidos = new Vector<Perfil>();
		
		if (perfilAtual != null) {
			if (perfilAtual.isAtivo()) {
				for (Perfil perfil: perfilAtual.getSeguidos()) {
					if ((perfil != null) && (perfil.isAtivo())) {
						listaSeguidos.add(perfil);
					}
				}
				return listaSeguidos;
			}
			else {
				throw new PDException(perfilAtual.getUsuario());
			}
		}	
		else {
			throw new PIException(usuario);
		}		
	}
}
