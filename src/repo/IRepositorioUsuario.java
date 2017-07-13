package repo;

import profile.*;
import repo.exception.*;

public interface IRepositorioUsuario {
		
	Perfil buscar(String usuario);
	
	void cadastrar(Perfil usuario) throws UJCException;
	
	void atualizar(Perfil usuario) throws UNCException;
		
}
