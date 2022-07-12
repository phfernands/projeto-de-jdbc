package br.com.alura.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.conexao.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection conexao = factory.recuperaConexao()) {

			conexao.setAutoCommit(false);

			try (PreparedStatement preStm = conexao.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionarProduto("Smart TV", "Smart TV - 45 polegadas", preStm);
				adicionarProduto("Radio", "Radio-relógio Bluetooth", preStm);

				conexao.commit();

			} catch (Exception e) {

				e.printStackTrace();
				System.out.println("Executando ROLLBACK");
				conexao.rollback();

			}

		}

	}

	private static void adicionarProduto(String nome, String descricao, PreparedStatement preStm) throws SQLException {
		preStm.setString(1, nome);
		preStm.setString(2, descricao);

		if (nome.equals("Radio")) {
			throw new RuntimeException("Não é possivel adicionar este produto.");
		}

		preStm.execute();

		try (ResultSet rst = preStm.getGeneratedKeys()) {

			while (rst.next()) {

				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}

		}
	}

}
