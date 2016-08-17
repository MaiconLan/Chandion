package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import exemplos.Mensagem;

public class MensagemDAO {

	public void enviaMsg(Mensagem msg) throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO msg(nom_msg, nom_remet, data_envio) VALUES (?, ?, ?);";
		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setString(1, msg.getMensagem());
		stmt.setString(2, msg.getRemetente());
		stmt.setTimestamp(3, new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));

		stmt.execute();
		stmt.close();
		con.close();
	}

	public List<Mensagem> listarMensagem() throws SQLException {
		List<Mensagem> lista = new ArrayList<Mensagem>();

		String sql = "SELECT cod_msg, nom_msg, nom_remet, data_envio FROM msg;";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Mensagem msg = new Mensagem();

				msg.setId(rs.getInt("cod_msg"));
				msg.setMensagem(rs.getString("nom_msg"));
				msg.setRemetente(rs.getString("nom_remet"));
				msg.setData(rs.getTimestamp("data_envio"));
				lista.add(msg);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();
		}
		return lista;
	}

}
