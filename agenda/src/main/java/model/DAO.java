package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	// Modulo de conexao

	// Parametro de conexao

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "Hericles12345678";

// Metodo de conexao	

	private Connection conectar() {
		Connection con = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

//   CRUD CREATE

	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,phone,email) values (?,?,?)";

		try {

			// abrir a conexao com a BD
			Connection con = conectar(); 
 
			// recurso do JDBC (preparar a query para executar na BD)
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir os ??? parametros pelos conteudo das variaveis javabeans

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getPhone());
			pst.setString(3, contato.getEmail());

			// Executar a query
			pst.executeUpdate();

			// Encerrar a conexao com o BD
			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}
	}

	// Teste de conexao

	/*
	 * public void testeConexao() { try {
	 * 
	 * Connection con = conectar(); System.out.println(con); con.close();
	 * 
	 * } catch (Exception e) { System.out.println(e); } }
	 */
}
