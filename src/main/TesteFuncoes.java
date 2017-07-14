package main;

import profile.*;
import profile.exception.*;
import repo.*;
import repo.exception.UJCException;
import twitter.*;

import java.util.Scanner;
//import main.exception.OIException;

public class TesteFuncoes {
	
	public static void main(String args[]) {
		
		RepositorioVector repo = new RepositorioVector();
		
		MyTwitter twitter = new MyTwitter(repo);
		
		Scanner entrada = new Scanner(System.in);
		
		String nomeUsuario1;
		String nomeUsuario2;
		
		System.out.println("Nome usuario 1: ");
		nomeUsuario1 = entrada.next();
		System.out.println("Nome usuario 2: ");
		nomeUsuario2 = entrada.next();

		
		Perfil usuario1 = new PessoaFisica(nomeUsuario1, 677);
		Perfil usuario2 = new PessoaFisica(nomeUsuario2, 677);
		
		try {
 			repo.cadastrar(usuario1);
 			repo.cadastrar(usuario2);
		}
		catch (UJCException ujce) {
			System.out.println("Erro: " + ujce.getMessage());
		}

		
		for (Perfil perfil: repo.getPerfis()) {
			System.out.println(perfil.getUsuario());
		}

	}
}
