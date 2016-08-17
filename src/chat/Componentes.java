//package chat;
//
//import javax.swing.*;
//import java.awt.event.*;
//
//public class Componentes extends JFrame implements ActionListener {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	JFrame frame = new JFrame();
//	JLabel lbl1 = new JLabel("Login:");
//	JLabel lbl2 = new JLabel("Senha:");
//	JTextField us = new JTextField(20);
//	JPasswordField psw = new JPasswordField(20);
//	JButton btLogin = new JButton("Login");
//	JButton btClear = new JButton("Clear");
//	JPanel panel = new JPanel();
//
//	public Componentes() {
//		super("Login");
//		panel.add(lbl1);
//		panel.add(us);
//		panel.add(lbl2);
//		panel.add(psw);
//		panel.add(btLogin);
//		panel.add(btClear);
//		frame.add(panel);
//		frame.setTitle("Window Login");
//		frame.setSize(300, 120);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//
//	public void ValidateLogin() {
//		String user = "teste";
//		String pass = "teste";
//		if ((us.getText() == user) || (psw.getText() == pass)) {
//			JOptionPane.showMessageDialog(null, "Login Aceito");
//		} else {
//			JOptionPane.showMessageDialog(null, "Dados invalidos");
//		} // end else
//	}// end validateLogin
//
//	public void actionPerformed(ActionEvent e) {
//		this.ValidateLogin();
//	}
//
//	public static void main(String[] args) {
//		new Componentes().setVisible(true);
//	}
//}