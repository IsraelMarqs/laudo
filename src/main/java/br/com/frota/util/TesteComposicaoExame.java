package br.com.frota.util;

import br.com.frota.DAO.ComposicaoExameDAO;
import br.com.frota.model.ComposicaoExame;
import br.com.frota.servico.ServicoComposicaoExame;

import java.sql.SQLException;
import java.util.List;

public class TesteComposicaoExame {

    static ComposicaoExameDAO composicaoExameDAO = new ComposicaoExameDAO();

    static ServicoComposicaoExame servicoComposicaoExame = new ServicoComposicaoExame();

    public static void main(String[] args) throws SQLException {

        System.out.println(composicaoExameDAO.count());

        ComposicaoExame CompE1 = new ComposicaoExame("Plaquetas", 1);

        servicoComposicaoExame.salvar(CompE1);

        ComposicaoExame ComEID = composicaoExameDAO.findById(1);
        System.out.println(servicoComposicaoExame.buscarPorId(1));
        System.out.println(ComEID);

        List<ComposicaoExame> composicaoExames = composicaoExameDAO.selectAllComposicoesExames();
        composicaoExames.forEach(System.out::println);

        //composicaoExameDAO.deleteComposicaoExame(2);
    }
}
