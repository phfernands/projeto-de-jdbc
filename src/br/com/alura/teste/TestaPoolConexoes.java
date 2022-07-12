package br.com.alura.teste;

import java.sql.SQLException;

import br.com.alura.conexao.ConnectionFactory;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		
		for(int i = 0; i < 20; i++) {
			factory.recuperaConexao();
			System.out.println("Conexão de número: " + i);
		}
		
	}

}
