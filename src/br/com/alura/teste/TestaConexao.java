package br.com.alura.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.conexao.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conexao = new ConnectionFactory();
		Connection connection = conexao.recuperaConexao();
		
		System.out.println("Fechando conexão!");
		
		connection.close();
		
	}

}
