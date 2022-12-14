package br.com.frota.util;

import br.com.frota.DAO.SolicitacaoExameDAO;
import br.com.frota.model.SolicitacaoExame;
import br.com.frota.servico.ServicoSolicitacaoExame;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TesteSolicitacaoExame {

    static SolicitacaoExameDAO solicitacaoExameDAO = new SolicitacaoExameDAO();

    static ServicoSolicitacaoExame servicoSolicitacaoExame = new ServicoSolicitacaoExame();

    public static void main(String[] args) throws SQLException, ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse("10/12/2021");
        long time=date.getTime();
        new Timestamp(time);
        System.out.println(solicitacaoExameDAO.count());

        SolicitacaoExame SolE1 = new SolicitacaoExame("Sangue",1, new Timestamp(time), 1, 1);
        //servicoSolicitacaoExame.salvar(SolE1);

        SolicitacaoExame SolEID = solicitacaoExameDAO.findById(1);
        System.out.println(servicoSolicitacaoExame.buscarPorId(1));
        System.out.println(SolEID);


        List<SolicitacaoExame> solicitacaoExames = solicitacaoExameDAO.selectAllSolicitacaoExame();
        solicitacaoExames.forEach(System.out::println);

        //solicitacaoExameDAO.deleteSolicitacaoExame(2);
    }
}
