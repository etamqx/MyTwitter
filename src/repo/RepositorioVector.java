package repo;

import profile.*;
import java.util.Vector;
import repo.exception.*;

public class RepositorioVector implements IRepositorioUsuario {
	
	private Vector<Perfil> perfis;
	
	
	public RepositorioVector() {
		this.perfis = new Vector<Perfil>();
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
		}
		//Caso ele já exista
		else {
			throw new UJCException(usuario.getUsuario());
		}
		
	}
	

	
	/** Método atualizar()
	 * Substitui o perfil antigo, se encontrado, por um novo perfil, com as informações já atualizadas.

	 */
	public void atualizar(Perfil usuario) throws UNCException{
		Perfil perfilAntigo = this.buscar(usuario.getUsuario());
	
		if (perfilAntigo != null) {
			perfilAntigo = usuario;
		}
		
		else {
			throw new UNCException(usuario.getUsuario());
		}
	}
}
