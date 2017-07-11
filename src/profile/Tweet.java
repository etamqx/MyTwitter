package profile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tweet {
	
	private String usuario;
	
	private String mensagem;
	
	private String data;
	
	
	public Tweet(String usuario, String mensagem) {
		this.setUsuario(usuario);
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
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		this.setData(df.format(calobj.getTime()));	
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return this.data;
	}
	
}
