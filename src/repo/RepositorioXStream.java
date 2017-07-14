package repo;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import repo.exception.*;
import profile.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.*;


public class RepositorioXStream implements IRepositorioUsuario {
	
	XStream xstream;
	PersistenceStrategy strategy;
	List<Perfil> list;

	public RepositorioXStream() {
		this.xstream = new XStream();
		this.strategy = new FilePersistenceStrategy(new File("/user/tales/workspace/tmp"));
		this.list = new XmlArrayList(strategy);
	}
	
	public Perfil buscar(String usuario) {
		Perfil perfilAtual;
		
		for(Iterator<Perfil> it = list.iterator(); it.hasNext();) {
			
		}
		
		return null;
	}
	
	public void cadastrar(Perfil usuario) throws UJCException {
		list.add(usuario);

		
	}
	
	public void atualizar(Perfil usuario) throws UNCException {
		//...
	}

}
