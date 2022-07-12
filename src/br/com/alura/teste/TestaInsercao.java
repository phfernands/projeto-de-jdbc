package br.com.alura.teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.conexao.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connect = new ConnectionFactory();
		Connection conexao = connect.recuperaConexao();
		
		Statement state = conexao.createStatement();
		state.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('Teclado Gamer', 'Teclado Gamer RGB - Switch Azul')",
				Statement.RETURN_GENERATED_KEYS);
		
		
		ResultSet result = state.getGeneratedKeys();
		while(result.next()) {
			Integer id = result.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		
		
	}

}
