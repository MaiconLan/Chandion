package exemplos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Mensagem {

	private int id;
	private String mensagem, remetente;
	private Date data;
	private List<Mensagem> listaMsg;

	public Mensagem() {

	}

	public Mensagem(int id, String mensagem, String remetente, Date data, List<Mensagem> listaMsg) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.remetente = remetente;
		this.data = data;
		this.listaMsg = listaMsg;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Mensagem> getListaMsg() {
		return listaMsg;
	}

	public void setListaMsg(List<Mensagem> listaMsg) {
		this.listaMsg = listaMsg;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return "\n\n" + remetente + " [" + sdf.format(data) + "] : \n" + mensagem;
	}
}
