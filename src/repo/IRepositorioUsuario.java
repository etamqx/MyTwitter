package repo;

import profile.*;

public interface IRepositorioUsuario {
	
	void cadastrar(Perfil usuario);
	Perfil buscar(String usuario);
	void atualizar(Perfil usuario);
		
}
