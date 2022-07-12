package br.com.alura.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.conexao.ConnectionFactory;
import br.com.alura.dataaccessobject.ProdutoDAO;
import br.com.alura.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto tv = new Produto("TV", "Smart TV - 40 polegadas");

		try (Connection conexao = new ConnectionFactory().recuperaConexao()) {

			ProdutoDAO produtoDao = new ProdutoDAO(conexao);
			produtoDao.salvar(tv);

			List<Produto> lista = produtoDao.listar();

			lista.stream().forEach(produto -> System.out.println(produto));

		}
	}

}
