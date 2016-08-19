package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.Mensagem;
import dao.MensagemDAO;

@Named
@SessionScoped
public class MensagemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Mensagem mensagem;
	private List<Mensagem> lista;
	private MensagemDAO dao;

	@PostConstruct
	public void postConstruct() {
		this.dao = new MensagemDAO();
		this.mensagem = new Mensagem();
		try {
			this.lista = dao.listarMensagem();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void enviarMensagem() {
		try {
			if (this.mensagem.getIdMensagem() == null) {
				this.dao.enviaMensagem(mensagem);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						"Mensagem enviada com sucesso!"));
			}

			else {
				// this.dao.editar(mensagem);
				// FacesContext context = FacesContext.getCurrentInstance();
				// context.addMessage(null,new
				// FacesMessage("Cadastrado com sucesso!"));
			}
			this.mensagem = new Mensagem();
			this.lista = dao.listarMensagem();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public List<Mensagem> getLista() {
		return lista;
	}

	public void setLista(List<Mensagem> lista) {
		this.lista = lista;
	}

	public MensagemDAO getDao() {
		return dao;
	}

	public void setDao(MensagemDAO dao) {
		this.dao = dao;
	}
}
