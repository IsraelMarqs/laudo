package br.com.frota.util;

import br.com.frota.DAO.ResultadoExameDAO;
import br.com.frota.model.ResultadoExame;
import br.com.frota.servico.ServicoResultadoExame;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TesteResultadoExame {

    static ResultadoExameDAO resultadoExameDAO = new ResultadoExameDAO();

    static ServicoResultadoExame servicoResultadoExame = new ServicoResultadoExame();

    public static void main(String[] args) throws SQLException, ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse("23/12/2020");
        long time=date.getTime();
        new Timestamp(time);
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2021-12-10 10:10:10.0");
        System.out.println(resultadoExameDAO.count());

        ResultadoExame ResE1 = new ResultadoExame(new Timestamp(time), "123", 1, 1);
        ResultadoExame ResE2 = new ResultadoExame(timestamp, "321", 1, 1);

        servicoResultadoExame.salvar(ResE2);

        //ResultadoExame ResEID = resultadoExameDAO.findById(1);
        //System.out.println(servicoResultadoExame.buscarPorId(1));
        //System.out.println(ResEID);

        List<ResultadoExame> resultadoExames = resultadoExameDAO.selectAllResultadosExames();
        resultadoExames.forEach(System.out::println);

        //resultadoExameDAO.deleteResultadoExame(2);
    }
}
