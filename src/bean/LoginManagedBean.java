package bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.Usuario;
import dao.UsuarioDAO;

@Named(value = "loginMb")
@SessionScoped
public class LoginManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;
	private Usuario usuario;
	private String user;
	private String pass;
	List<Usuario> usuarios;
	private boolean logado = false;
	private boolean admin = false;

	public void isValido() throws SQLException, IOException {
		dao = new UsuarioDAO();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			logado = dao.isValido(user, pass);

			if (logado) {

				this.usuario = dao.informacaoUsuario(user);

				context.addMessage(null, new FacesMessage(
						"Login efetuado com sucesso!",
						"Login efetuado com sucesso."));
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("mensagem.xhtml");
			} else {
				context.addMessage(null, new FacesMessage(
						"Login e/ou senha incorretos!",
						"Login e/ou senha incorretos."));
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					"Não foi possível realizar o Login!",
					"Não foi possível realizar o Login." + e));
		}

	}
	
	public Usuario usuarioLogado() throws SQLException {
		this.dao.informacaoUsuario(user);
		return usuario;
	}

	public boolean isLogado() {
		return logado;
	}

	public boolean isAdmin() {
		return admin;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUsuarioDAO() {
		return dao;
	}

	public void setUsuarioDAO(UsuarioDAO dao) {
		this.dao = dao;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public UsuarioDAO getDao() {
		return dao;
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
