package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mensagem;
import controller.ConnectionFactory;

public class MensagemDAO {

	public void enviaMensagem(Mensagem msg) throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO mensagem(nom_mensagem, nom_usuario, data_envio) VALUES (?, ?, ?);";

		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setString(1, msg.getMensagem());
		stmt.setString(2, msg.getUsuario());
		stmt.setTimestamp(3, getCurrentTimeStamp());

		stmt.execute();
		stmt.close();
		con.close();
	}

	public List<Mensagem> listarMensagem() throws SQLException {
		String sql = "SELECT cod_mensagem, nom_mensagem, nom_usuario, data_envio FROM mensagem";

		Connection connection = ConnectionFactory.getConnection();
		List<Mensagem> mensagens = new ArrayList<Mensagem>();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Mensagem mensagem = new Mensagem();
				mensagem.setIdMensagem(rs.getLong("cod_mensagem"));
				mensagem.setMensagem(rs.getString("nom_mensagem"));
				mensagem.setUsuario(rs.getString("nom_usuario"));
				mensagem.setDataEnvio(rs.getTimestamp("data_envio"));

				mensagens.add(mensagem);
			}

			stmt.execute();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mensagens;
	}

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
}
