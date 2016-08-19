package model;

import java.sql.Timestamp;

public class Mensagem {

	private Long idMensagem;
	private String mensagem;
	private String usuario;
	private String senha;
	private Timestamp dataEnvio;

	public Mensagem() {

	}

	public Mensagem(Long idMensagem, String mensagem, String usuario,
			String senha, Timestamp dataEnvio) {
		super();
		this.idMensagem = idMensagem;
		this.mensagem = mensagem;
		this.usuario = usuario;
		this.senha = senha;
		this.dataEnvio = dataEnvio;
	}

	public Long getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Timestamp getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Timestamp dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

}