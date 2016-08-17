package exemplos;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.MensagemDAO;

public class Painel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	MensagemDAO dao = new MensagemDAO();
	Mensagem msg = new Mensagem();
	DefaultTableModel listaMsg;
	JLabel lb_nome, lb_mensagem, lb_listMsg;
	JTextField tf_nome;
	JTextArea ta_mensagem, ta_listMsg;
	JButton bt_salvar, bt_limpar, bt_fechar;
	JTable jTable;

	public Painel() {
		Components();
		Layout();
		Eventos();
	}

	// Componentes
	private void Components() {
		jTable = new JTable(listaMsg);
		listaMsg = new DefaultTableModel();

		lb_listMsg = new JLabel("Mensagens");
		ta_listMsg = new JTextArea("");

		lb_nome = new JLabel("Remetente");
		lb_mensagem = new JLabel("Mensagem");

		tf_nome = new JTextField("");
		ta_mensagem = new JTextArea("");

		bt_salvar = new JButton("Salvar");
		bt_limpar = new JButton("Limpar");
		bt_fechar = new JButton("Mostrar");
	}

	// Define Layout
	private void Layout() {
		setTitle("Mensagem");
		setSize(300, 450);

		// -------------------- PosV/PosH/Larg/Altu
		// Campos
		lb_nome.setBounds(20, 20, 100, 15);
		tf_nome.setBounds(20, 40, 80, 25);
		lb_mensagem.setBounds(20, 220, 100, 50);
		ta_mensagem.setBounds(20, 260, 250, 50);
		// Botões
		bt_salvar.setBounds(20, 330, 80, 30);
		bt_limpar.setBounds(105, 330, 80, 30);
		bt_fechar.setBounds(190, 330, 80, 30);
		// Mensagens
		jTable.setBounds(20, 80, 250, 150);
	}

	// Adiciona Eventos
	public void Eventos() {
		getContentPane().setLayout(null);
		getContentPane().add(lb_nome);
		getContentPane().add(lb_mensagem);
		getContentPane().add(tf_nome);
		getContentPane().add(ta_mensagem);
		getContentPane().add(bt_salvar);
		getContentPane().add(bt_limpar);
		getContentPane().add(bt_fechar);
		getContentPane().add(ta_listMsg);
		getContentPane().add(jTable);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bt_salvar.addActionListener(al);
		bt_fechar.addActionListener(al);
		bt_limpar.addActionListener(al);
	}

	// Tabela de Mensagens
	public JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(listaMsg);
			jTable.setFont(new Font("Dialog", Font.PLAIN, 12));
			listaMsg.addColumn("Remetente");
			listaMsg.addColumn("Destinatário");
			listaMsg.addColumn("Mensagem");
		}
		return jTable;
	}

	/**
	 * Realiza o tratamento dos eventos dos botões.
	 */

	public void limparMensagem() {
		ta_mensagem.setText("");
	}

	public void limparCampos() {
		ta_mensagem.setText("");
		tf_nome.setText("");
		
	}

	// public void mensagens(){
	// listaMsg = dao.listarMensagem();
	// }

	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// trata os eventos para o botao "botao1"
			if (e.getSource() == bt_salvar) {
				msg.setRemetente(tf_nome.getText());
				msg.setMensagem(ta_mensagem.getText());

				try {
					dao.enviaMsg(msg);
					limparMensagem();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			// trata os eventos para o botao "botao2"
			if (e.getSource() == bt_limpar) {
				limparCampos();
			}

			if (e.getSource() == bt_fechar) {
				try {
					JOptionPane.showMessageDialog(null, dao.listarMensagem());

				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};

	public static void main(String[] args) throws SQLException {
		Painel painel = new Painel();
		// Timer timer = new Timer();

		painel.setVisible(true);

		// int delay = 1000, interval = 1000;
		// timer.scheduleAtFixedRate(new TimerTask() {
		// public void run() {
		// MensagemDAO dao = new MensagemDAO();
		// colocar tarefas aqui ...
		//
		// try {
		// System.out.println(dao.listarMensagem());
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }, delay, interval);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

}