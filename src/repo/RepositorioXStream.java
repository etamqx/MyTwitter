package repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import repo.exception.*;
import profile.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



public class RepositorioXStream implements IRepositorioUsuario {
	
	private XStream xstream;
	
	private File arquivo;
	
	private Vector<Perfil> perfis;
	
	
	/** Método construtor RepositorioXStream()
	 * Instancia criando objetos xstream e arquivo
	 * e já "carrega na memória" os dados salvos.
	 * 
	 */
	public RepositorioXStream() {
		this.xstream = new XStream(new DomDriver());
		this.arquivo = new File("persistence.xml");
		this.perfis = this.carregar();
	}
	
	
	public Perfil buscar(String usuario) {	
		for(Perfil perfil: perfis) {
			if (perfil.getUsuario().equals(usuario)) {
				return perfil;
			}
		}
		
		return null;
	}
	
	public void cadastrar(Perfil usuario) throws UJCException {
		//Se o perfil não existir no repositório
		if (this.buscar(usuario.getUsuario()) == null) {
			this.perfis.add(usuario);
			
			this.salvar(this.perfis);
		}
		//Caso ele já exista
		else {
			throw new UJCException(usuario.getUsuario());
		}
		
	}
	
	public void atualizar(Perfil usuario) throws UNCException {
		Perfil perfilAntigo = this.buscar(usuario.getUsuario());
		
		if (perfilAntigo != null) {
			perfilAntigo = usuario;
			
			this.salvar(this.perfis);
		}
		
		else {
			throw new UNCException(usuario.getUsuario());
		}
	}
	
	@SuppressWarnings("unchecked")
	public Vector<Perfil> carregar() {
		Vector<Perfil> perfisTemp;
		
		try {
			if(this.arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				perfisTemp = (Vector<Perfil>) xstream.fromXML(fis);
					
				return perfisTemp;
			}
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		
		return new Vector<Perfil>();
	}
	
	public void salvar(Vector<Perfil> perfis) {
		String xml = xstream.toXML(perfis);
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();		
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
