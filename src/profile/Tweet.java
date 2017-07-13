package profile;

import time.MyTime;

public class Tweet {
	
	private String usuario;
	
	private String mensagem;
	
	/* Atributos data e hora
	 * Registram o momento da publicação.
	 * O atributo instante apenas é usado para registrar o momento.
	 * */
	private String data; 
	
	private String hora;
	
	private MyTime instante;
	
	
	/* Método construtor Tweet()
	 * Define o usuário, a mensagem e o momento da publicação no ato de instanciação.
	 * */
	public Tweet(String usuario, String mensagem) {
		this.setUsuario(usuario);
		this.instante = new MyTime("Momento do Tweet");
		this.setMensagem(mensagem);
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
		this.setData();
		this.setHora();
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	public void setData() {
		this.data = this.instante.getCurrentDate();
	}
	
	public void setHora() {
		this.hora = this.instante.getCurrentTime();
	}
	
	public String getData() {
		return this.data;
	}
	
	public String getHora() {
		return this.hora;
	}
	
}
