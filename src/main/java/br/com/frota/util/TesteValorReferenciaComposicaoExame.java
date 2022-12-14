package br.com.frota.util;

import br.com.frota.DAO.ValorReferenciaComposicaoExameDAO;
import br.com.frota.model.ValorReferenciaComposicaoExame;
import br.com.frota.servico.ServicoValorReferenciaComposicaoExame;

import java.sql.SQLException;
import java.util.List;

public class TesteValorReferenciaComposicaoExame {

    static ValorReferenciaComposicaoExameDAO valorReferenciaComposicaoExameDAO = new ValorReferenciaComposicaoExameDAO();

    static ServicoValorReferenciaComposicaoExame servicoValorReferenciaComposicaoExame = new ServicoValorReferenciaComposicaoExame();

    public static void main(String[] args) throws SQLException {

        System.out.println(valorReferenciaComposicaoExameDAO.count());

        ValorReferenciaComposicaoExame ValorRCE1 = new ValorReferenciaComposicaoExame(1,"33", "60", "2", "7", 1);
        servicoValorReferenciaComposicaoExame.salvar(ValorRCE1);


        ValorReferenciaComposicaoExame ValorRCEID = valorReferenciaComposicaoExameDAO.findById(1);
        System.out.println(servicoValorReferenciaComposicaoExame.buscarPorId(1));
        System.out.println(ValorRCEID);

        List<ValorReferenciaComposicaoExame> valorReferenciaComposicaoExames = valorReferenciaComposicaoExameDAO.selectAllValoresReferenciasComposicoesExame();
        valorReferenciaComposicaoExames.forEach(System.out::println);

        //valorReferenciaComposicaoExameDAO.deleteValorReferenciaComposicaoExame(2);
    }
}
