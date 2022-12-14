package br.com.frota.util;

import br.com.frota.DAO.HabilitacaoExameDAO;
import br.com.frota.model.HabilitacaoExame;
import br.com.frota.servico.ServicoHabilitacaoExame;

import java.sql.SQLException;
import java.util.List;

public class TesteHabilitacaoExame {

    static HabilitacaoExameDAO habilitacaoExameDAO = new HabilitacaoExameDAO();

    static ServicoHabilitacaoExame servicoHabilitacaoExame = new ServicoHabilitacaoExame();

    public static void main(String[] args) throws SQLException {

        System.out.println(habilitacaoExameDAO.count());

        HabilitacaoExame HabE1 = new HabilitacaoExame("Teste", 100, 1, 1);
        HabilitacaoExame HabE2 = new HabilitacaoExame("Teste2", 102, 1, 1);
        servicoHabilitacaoExame.salvar(HabE1);

        HabilitacaoExame HabEID = habilitacaoExameDAO.findById(1);
        System.out.println(servicoHabilitacaoExame.buscarPorId(1));
        System.out.println(HabEID);

        HabEID.setObservacao("Teste3");
        HabEID.setCusto(101);

        servicoHabilitacaoExame.update(HabEID);

        HabEID = habilitacaoExameDAO.findById(1);
        System.out.println(HabEID);

        List<HabilitacaoExame> habilitacaoExames = habilitacaoExameDAO.selectAllHabilitacoesExames();
        habilitacaoExames.forEach(System.out::println);

       // habilitacaoExameDAO.deleteHabilitacaoExame(2);
    }
}
