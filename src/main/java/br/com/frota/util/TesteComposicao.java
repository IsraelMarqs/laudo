package br.com.frota.util;

import br.com.frota.DAO.ComposicaoDAO;
import br.com.frota.model.Composicao;
import br.com.frota.servico.ServicoComposicao;

import java.sql.SQLException;
import java.util.List;

public class TesteComposicao {

    static ComposicaoDAO composicaoDAO = new ComposicaoDAO();

    static ServicoComposicao servicoComposicao = new ServicoComposicao();

    public static void main(String[] args) throws SQLException {

        System.out.println(composicaoDAO.count());

        Composicao comp1 = new Composicao(1,1,1);
        servicoComposicao.salvar(comp1);

        Composicao compID = composicaoDAO.findById(1);
        System.out.println(servicoComposicao.buscarPorId(1));
        System.out.println(compID);

        List<Composicao> composicaos = composicaoDAO.selectAllComposicoes();
        composicaos.forEach(System.out::println);

        //composicaoDAO.deleteComposicao(2);
    }
}