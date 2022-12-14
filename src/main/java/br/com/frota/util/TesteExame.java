package br.com.frota.util;

import br.com.frota.DAO.ExameDAO;
import br.com.frota.model.Exame;
import br.com.frota.servico.ServicoExame;

import java.sql.SQLException;
import java.util.List;

public class TesteExame {

    static ExameDAO exameDAO = new ExameDAO();

    static ServicoExame servicoExame = new ServicoExame();

    public static void main(String[] args) throws SQLException {

        System.out.println(exameDAO.count());

        Exame Exa1 = new Exame(1, "Sangue", 1, "Injeção");

        servicoExame.salvar(Exa1);

        Exame ExaID = exameDAO.findById(1);
        System.out.println(servicoExame.buscarPorId(1));
        System.out.println(ExaID);


        List<Exame> exames = exameDAO.selectAllExames();
        exames.forEach(System.out::println);

        //exameDAO.deleteExame(2);
    }
}
