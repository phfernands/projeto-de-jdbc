package br.com.alura.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.alura.conexao.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.recuperaConexao();
		
		PreparedStatement preparedStm = conexao.prepareStatement("DELETE FROM PRODUTO WHERE id > ?");
		preparedStm.setInt(1, 10);
		preparedStm.execute();
		
		Integer linhasDeletadas = preparedStm.getUpdateCount();
		System.out.println("Linhas deletadas: " + linhasDeletadas);
		
				
//		Statement state = conexao.createStatement();
//		state.execute("DELETE FROM PRODUTO WHERE id = 11");
		
		conexao.close();
	}

}
