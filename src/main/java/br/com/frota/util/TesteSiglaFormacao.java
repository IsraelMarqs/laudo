package br.com.frota.util;

import br.com.frota.DAO.SiglaFormacaoDAO;
import br.com.frota.model.SiglaFormacao;
import br.com.frota.servico.ServicoSiglaFormacao;

import java.sql.SQLException;
import java.util.List;

public class TesteSiglaFormacao {

    static SiglaFormacaoDAO siglaFormacaoDAO = new SiglaFormacaoDAO();

    static ServicoSiglaFormacao servicoSiglaFormacao = new ServicoSiglaFormacao();

    public static void main(String[] args) throws SQLException {

        System.out.println(siglaFormacaoDAO.count());

        SiglaFormacao Sigla1 = new SiglaFormacao("Sr.");
        SiglaFormacao Sigla2 = new SiglaFormacao("Dr.");
        servicoSiglaFormacao.salvar(Sigla1);

        SiglaFormacao SiglaFID = siglaFormacaoDAO.findById(1);
        System.out.println(servicoSiglaFormacao.buscarPorId(1));
        System.out.println(SiglaFID);

        SiglaFID.setSigla("Dra.");
        servicoSiglaFormacao.update(SiglaFID);

        SiglaFID = siglaFormacaoDAO.findById(1);
        System.out.println(SiglaFID);

        List<SiglaFormacao> siglaFormacaos = siglaFormacaoDAO.selectAllSiglasFormacoes();
        siglaFormacaos.forEach(System.out::println);

        //siglaFormacaoDAO.deleteSiglaFormacao(2);
    }
}
