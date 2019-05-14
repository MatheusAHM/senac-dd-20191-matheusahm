package model.entity.exercicio7.model.bo;

import java.util.ArrayList;
import java.util.List;

import model.entity.exercicio7.model.dao.ProdutoDAO;
import model.entity.exercicio7.model.seletor.ProdutoSeletor;
import model.entity.exercicio7.model.vo.Produto;

public class ProdutoBO {

	ProdutoDAO dao = new ProdutoDAO();

	public boolean inserir(Produto produto) {
		int idGerado = dao.inserir(produto);
		return idGerado > 0;
	}

	public model.entity.exercicio7.model.vo.Produto buscarProdutoPorId(String textoId) {
		Produto produtoBuscado = dao.obterPorId(Integer.parseInt(textoId));
		return produtoBuscado;
	}

	public boolean atualizar(Produto produto) {
		boolean sucesso = dao.atualizar(produto);
		return sucesso;
	}

	public List<Produto> listarProdutos() {
		ArrayList<Produto> produtos = dao.listarTodos();
		return produtos;
	}

	public List<Produto> listarProdutosPorFaixaDePreco(double precoMax) {
		ArrayList<Produto> produtos = dao.listarPorFaixaDePreco(precoMax);
		return produtos;
	}

	public void gerarPlanilha(List<Produto> produtos, String caminhoEscolhido) {
		// TODO
	}

	public List<Produto> listarProdutos(ProdutoSeletor seletor) {
		return dao.listarComSeletor(seletor);
	}
}