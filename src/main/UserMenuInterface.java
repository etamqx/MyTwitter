package main;

import java.util.Scanner;
import java.util.Vector;
import profile.*;
import main.exception.*;

public final class UserMenuInterface {

	Scanner leitor;
	
	public UserMenuInterface() {
		this.leitor = new Scanner(System.in);
	}
	
	/** Método apresentacao()
	 * Apenas uma breve apresentação do sistema.
	 * 
	 */
	public void apresentacao() {
		System.out.println("=======================================================");
//		System.out.println("-------------------------------------------------------");
		System.out.println("--------------------My Twitter-------------------------");
//		System.out.println("-------------------------------------------------------");
		System.out.println("=======================================================");
		System.out.println("                       Olá =) 						   ");
		System.out.println("-------------------------------------------------------");
		System.out.println("                                                       ");
	}
	
	
	/** Os seguintes métodos são responsáveis por gerenciar a interface do usuário do sistema.
	 * 
	 * 
	 */
	
	/** Método sistema()
	 * Mostra as opções de gerenciamento geral, além de retornar um inteiro que representa
	 * essa opção.
	 */
	public int sistema() throws OIException {
		int opcao;
		int i;
		boolean retorna = false;
		
		System.out.println("=======================================================");
		System.out.println("-----------Menu de Configuração do Sistema-------------");
		System.out.println("                                                       ");
		System.out.println("Selecione a opção desejada. 	          			   ");
		System.out.println("1 - Inscrever um novo perfil            			   ");
		System.out.println("2 - Desativar perfil                  				   ");
		System.out.println("3 - Fazer login (acessar um perfil)        			   ");
		System.out.println("0 - Fechar                   		            	   ");
		System.out.println("                                                       ");
		System.out.print("Opção desejada: ");
		opcao = this.leitor.nextInt();
		System.out.println("=======================================================");
		
		i = 0;
		while(i<=3) {
			if (opcao == i) {
				retorna = true;
			}
			i++;
		}
		
		if(retorna) {
			return opcao;
		}
		
		else {
			throw new OIException(opcao);
		}
		
	}
	
	public int tipoPerfil() throws OIException {
		int opcao; 
		int i;
		boolean retorna = false;
		
		System.out.println("-------------------------------------------------------");
		System.out.println("Escolha o tipo de perfil.                              ");
		System.out.println("1 - Pessoa Física									   ");
		System.out.println("2 - Pessoa Jurídica                                    ");
		System.out.print("Opção desejada: ");
		opcao = this.leitor.nextInt();
		System.out.println("-------------------------------------------------------");
		System.out.println("                                                       ");
		
		i = 1;
		while(i<=2) {
			if (opcao == i) {
				retorna = true;
			}
			i++;
		}
		
		if(retorna) {
			return opcao;
		}
		
		else {
			throw new OIException(opcao);
		}
		
	}
	
	public void inscreverPerfil(int opcaoPerfil) {
		if(opcaoPerfil == 1) {
			System.out.println("");
			
		}
		
		else {
			
		}
	}
	

	
	public int usuario(String usuario) throws OIException {
		int opcao;
		int i;
		boolean retorna = false;
		
		System.out.println("=======================================================");
		System.out.println("--------------------My Twitter-------------------------");
		System.out.println("=======================================================");
		System.out.println("Bem vindo, " + usuario + ". O que deseja fazer?");
		System.out.println("1 - Novo Tweet										   ");
		System.out.println("2 - Ver sua timeline								   ");
		System.out.println("3 - Ver seus tweets									   ");
		System.out.println("4 - Seguir alguém									   ");
		System.out.println("5 - Mostrar número de seguidores					   ");
		System.out.println("6 - Deslogar 										   ");
		System.out.println("0 - Fechar											   ");
		System.out.println("                                                       ");
		System.out.println("Opção escolhida: ");
		opcao = this.leitor.nextInt();
		System.out.println("=======================================================");
		System.out.println("                                                       ");
				
		i = 0;
		while(i<=6) {
			if (opcao == i) {
				retorna = true;
			}
			i++;
		}
		
		if(retorna) {
			return opcao;
		}
		
		else {
			throw new OIException(opcao);
		}
		
	}
	
	public void showTimeline(Vector<Tweet> timeline) {
		System.out.println("=======================================================");
		System.out.println("                    Timeline                           ");
		System.out.println("                                                       ");
		for (Tweet tweet: timeline) {
			System.out.println("-------------------------------------------------------");
			System.out.println(tweet.getUsuario());
			System.out.println(tweet.getHora() + "	" + tweet.getData());
			System.out.println("                                                       ");
			System.out.println(tweet.getMensagem());
			System.out.println("-------------------------------------------------------");
			System.out.println("                                                       ");
		}
	}
	
	public void showTweets(Vector<Tweet> tweets) {
		System.out.println("=======================================================");
		System.out.println("                      Tweets                           ");
		System.out.println("                                                       ");
		for (Tweet tweet: tweets) {
			System.out.println("-------------------------------------------------------");
			System.out.println(tweet.getUsuario());
			System.out.println(tweet.getHora() + "	" + tweet.getData());
			System.out.println("                                                       ");
			System.out.println(tweet.getMensagem());
			System.out.println("-------------------------------------------------------");
			System.out.println("                                                       ");
		}
	}
	

	
	public void logoff() {
		System.out.println("Deslogando...");
	}
	
	public void turnOff() {
		System.out.println("Saindo do sistema...");
	}
	
	public void despedida() {
		System.out.println("Até a próxima!");
	}
	
	public void imprimirLinha() {
		System.out.println("-------------------------------------------------------");
		
	}
	
	public void imprimirEspaco() {
		System.out.println("                                                       ");
	}
	
}

