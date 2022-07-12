package br.com.alura.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.conexao.ConnectionFactory;
import br.com.alura.dataaccessobject.CategoriaDAO;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {

			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> listaCategorias = categoriaDao.listarComProdutos();

			listaCategorias.stream().forEach(cat -> {
				System.out.println(cat.getNome());
				for (Produto produto : cat.getProdutos()) {
					System.out.println(cat.getNome() + " - " + produto.getNome());
				}

			});

		}

	}

}
