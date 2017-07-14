package main;

import profile.*;
import profile.exception.*;
import repo.*;
import twitter.*;
import java.util.Scanner;
import main.exception.OIException;



public class Main {
	// AMAIN \O/

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/** Instancia as classes básicas para a execução do sistema
		 *
		 * 
		 */
		UserMenuInterface interfaceUsuario = new UserMenuInterface();
		
		RepositorioVector repo = new RepositorioVector();
		
		MyTwitter twitter = new MyTwitter(repo);
		
		Scanner entrada = new Scanner(System.in);
		
		//Variável que mantém o loop principal do sistema.
		boolean continuaSistema = true;
		boolean continuaUsuario = true;
		
		//Variáveis responsáveis por representar as opções do usuário.
		int opcaoSistema, opcaoUsuario;
		int opcaoPerfil;
		
		
		//Mostra a apresentação do sistema.
		interfaceUsuario.apresentacao();
		
		while(continuaSistema) {
			try {
 				//Se o usuário não digitar zero, o menu do sistema aparece a cada ciclo.
				opcaoSistema = interfaceUsuario.sistema();
				
				switch(opcaoSistema) {
					//Inscrever um novo perfil
					case 1:
						try {
							opcaoPerfil = interfaceUsuario.tipoPerfil();
							Perfil perfil;
							
							//Pessoa física
							if(opcaoPerfil == 1) {
								String nome;
								long cpf;
								
								System.out.println("Nome de usuário: ");
								nome = entrada.next();
								System.out.println("CPF: ");
								cpf = entrada.nextInt();
								
								nome = "@" + nome;
								perfil = new PessoaFisica(nome, cpf);
								
								try {
									twitter.criarPerfil(perfil);
								} catch (PEException pee) {
									System.out.println("Erro: " + pee.getMessage());						
								}				
							}
							
							//Pessoa jurídica
							if(opcaoPerfil == 2) {
								String nome;
								long cpnj;
								
								System.out.println("Nome de usuário: ");
								nome = entrada.next();
								System.out.println("CPNJ: ");
								cpnj = entrada.nextInt();
								
								nome = "@" + nome;
								perfil = new PessoaJuridica(nome, cpnj);
								
								try {
									twitter.criarPerfil(perfil);
								} catch (PEException pee) {
									System.out.println("Erro: " + pee.getMessage());						
								}
								
							}
						
						} catch (OIException oie) {
							System.out.println("Erro: " + oie.getMessage());
						}
						
						break;
						
					//Desativar um perfil	
					case 2:
						System.out.println("Digite o @nome do usuário que deseja desativar: ");
						String usuario = entrada.next();				
						
						try {
							twitter.cancelarPerfil(usuario);
						}
						catch(PIException pie) {
							System.out.println("Erro: " + pie.getMessage());
							
						}
						catch(PDException pde) {
							System.out.println("Erro: " + pde.getMessage());			
						}
						break;
						
					//"Fazer login"	
					case 3:
						continuaUsuario = true;
						interfaceUsuario.imprimirLinha();
						System.out.println("Digite o @nome do usuário para fazer login.");
						String nomeLogin; 
						nomeLogin = entrada.next();
						interfaceUsuario.imprimirEspaco();
						
						while(continuaUsuario) {
							try {
								opcaoUsuario = interfaceUsuario.usuario(nomeLogin);
								
								switch(opcaoUsuario) {
									//Novo Tweet
									case 1:
										interfaceUsuario.imprimirLinha();
										System.out.println("Novo Tweet: ");
										entrada.nextLine();
										String mensagem = entrada.nextLine();
										interfaceUsuario.imprimirLinha();
										try {
											twitter.tweetar(nomeLogin, mensagem);
										} 
										
										catch(PIException pie) {
											System.out.println("Erro: " + pie.getMessage());
										}
										catch(PDException pde) {
											System.out.println("Erro: " + pde.getMessage());
										}
										catch(MFPException mfpe) {
											mfpe.getMessage();
										}								
										break;
										
									//Ver timeline
									case 2:
										try {
											interfaceUsuario.showTimeline((twitter.timeline(nomeLogin)));
										}
										catch (PIException pie) {
											System.out.println("Erro: " + pie.getMessage());
										}
										catch (PDException pde) {
											System.out.println("Erro: " + pde.getMessage());
										}								
										break;
									
									//Ver seus tweets
									case 3:
										try {
											interfaceUsuario.showTweets(twitter.tweets(nomeLogin));
										}
										catch (PIException pie) {
											System.out.println("Erro: " + pie.getMessage());
										}
										catch (PDException pde) {
											System.out.println("Erro: " + pde.getMessage());
										}									
										break;
										
									//Seguir alguém
									case 4:
										String seguido;
										
										interfaceUsuario.imprimirLinha();
										System.out.println("Digite o @nome do usuário que deseja seguir: ");
										seguido = entrada.next();
										
										try {
											twitter.seguir(nomeLogin, seguido);
										}
										catch (PIException pie) {
											System.out.println("Erro: " + pie.getMessage());
										}
										catch (PDException pde) {
											System.out.println("Erro: " + pde.getMessage());
										}
										catch (SIException sie) {
											sie.getMessage();
										}											
										break;
									
									//Mostrar número de seguidores
									case 5:
										try {
											int n = twitter.numeroSeguidores(nomeLogin);
											interfaceUsuario.imprimirLinha();
											System.out.println("Número atual de seguidores:");
											System.out.println(n);
											interfaceUsuario.imprimirLinha();
											
										}
										catch (PIException pie) {
											System.out.println("Erro: " + pie.getMessage());
										}
										catch (PDException pde) {
											System.out.println("Erro: " + pde.getMessage());
										}										
										break;
										
									
									//Listar seguidores	
									case 6:
										try {
											for(Perfil seguidor: twitter.seguidores(nomeLogin)) {
												System.out.println(seguidor.getUsuario());
											}
											interfaceUsuario.imprimirLinha();
										
										break;
										} 
										catch (PIException pie) {
											System.out.println("Erro: " + pie.getMessage());
										}
										catch (PDException pde) {
											System.out.println("Erro: " + pde.getMessage());
										}
										break;
										
									//Deslogar
									case 7:
										interfaceUsuario.imprimirLinha();
										interfaceUsuario.despedida();
										interfaceUsuario.imprimirEspaco();
										interfaceUsuario.logoff();
										interfaceUsuario.imprimirEspaco();
										continuaUsuario = false;
										break;
										
									//Fechar
									case 0:
										interfaceUsuario.imprimirLinha();
										interfaceUsuario.turnOff();																				
										interfaceUsuario.imprimirEspaco();
										continuaUsuario = false;
										continuaSistema = false;								
										break;
										
									default:
										//Não é nem pra chegar aqui
										System.out.println("Erro crítico!");
										
								}
							} catch (OIException oie) {
								System.out.println("Erro: " + oie.getMessage());
							}
						}
						break;
					
					//Fechar
					case 0:
						interfaceUsuario.imprimirLinha();
						interfaceUsuario.turnOff();																				
						interfaceUsuario.imprimirEspaco();
						continuaSistema = false;
						
						break;
						
					default:
						//Não é nem pra chegar aqui
						System.out.println("Erro crítico!");
								
				}
			} 
			catch (OIException oie) {
				System.out.println("Erro: " + oie.getMessage());
			}
		}
		
		entrada.close();
		
	}
}