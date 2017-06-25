<<<<<<< HEAD
package profile;

import java.util.Vector;

public abstract class Perfil {
	
	private String usuario;
	private Vector<Perfil> seguidos;
	private Vector<Perfil> seguidores;
	private Vector<Perfil> timeline;
	private boolean ativo;
	
	
	public Perfil(String usuario) {
		this.usuario = usuario;
		this.seguidos = new Vector<Perfil>();
		this.seguidores = new Vector<Perfil>();
		this.timeline = new Vector<Perfil>();
		this.setAtivo(true);
	}
	
	
	public void addSeguido() {
		//...
	}
	
	public void addSeguidor() {
		//...
	}
	
	public void addTweet() {
		//...
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	

	public Vector<Perfil> getSeguidos() {
		//...
		return null;
		
	}
	
	public Vector<Perfil> getSeguidores() {
		//...
		return null;
		
	}
	
	
	public void getTimeline() {
		//...
		
	}
	
	public void setAtivo(boolean valor) {
		this.ativo = valor;
	}
	
	public boolean isAtivo() {
		if(this.ativo == true) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
}
=======
package profile;

import java.util.Vector;

public abstract class Perfil {
	
	private String usuario;
	private Vector<Perfil> seguidos;
	private Vector<Perfil> seguidores;
	private Vector<Perfil> timeline;
	private boolean ativo;
	
	
	public Perfil(String usuario) {
		this.usuario = usuario;
		this.seguidos = new Vector<Perfil>();
		this.seguidores = new Vector<Perfil>();
		this.timeline = new Vector<Perfil>();
		this.setAtivo(true);
	}
	
	
	public void addSeguido() {
		//...
	}
	
	public void addSeguidor() {
		//...
	}
	
	public void addTweet() {
		//...
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	

	public Vector<Perfil> getSeguidos() {
		//...
		return null;
		
	}
	
	public Vector<Perfil> getSeguidores() {
		//...
		return null;
		
	}
	
	
	public void getTimeline() {
		//...
		
	}
	
	public void setAtivo(boolean valor) {
		this.ativo = valor;
	}
	
	public boolean isAtivo() {
		if(this.ativo == true) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
}
>>>>>>> cb5eace0f48cf111b1fc9bfa48918417416a0648
