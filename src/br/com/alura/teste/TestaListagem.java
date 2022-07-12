package br.com.alura.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.conexao.ConnectionFactory;

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conexao = new ConnectionFactory();
		Connection conect = conexao.recuperaConexao();
		
		PreparedStatement stm = conect.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		
		ResultSet resultado = stm.getResultSet();
		
//		Statement state = conect.createStatement();
//		state.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
//		
//		ResultSet resultado = state.getResultSet();
		
		while(resultado.next()) {
			Integer id = resultado.getInt("ID");
			System.out.println(id);
			String nome = resultado.getString("NOME");
			System.out.println(nome);
			String descricao = resultado.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		conect.close();
	}

}
