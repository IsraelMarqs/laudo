package br.com.frota.util;

import br.com.frota.DAO.LaudoDAO;
import br.com.frota.model.Laudo;
import br.com.frota.servico.ServicoLaudo;

import java.sql.SQLException;
import java.util.List;

public class TesteLaudo {

    static LaudoDAO laudoDAO = new LaudoDAO();

    static ServicoLaudo servicoLaudo = new ServicoLaudo();

    public static void main(String[] args) throws SQLException {

        System.out.println(laudoDAO.count());

        Laudo Lau1 = new Laudo("Israel", "Teste", "819", 1);
        servicoLaudo.salvar(Lau1);

        Laudo LauID = laudoDAO.findById(1);
        System.out.println(servicoLaudo.buscarPorId(1));
        System.out.println(LauID);


        List<Laudo> laudos = laudoDAO.selectAllLaudos();
        laudos.forEach(System.out::println);

        //laudoDAO.deleteLaudo(2);
    }
}
