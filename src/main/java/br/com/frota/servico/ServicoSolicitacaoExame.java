package br.com.frota.servico;

import br.com.frota.DAO.SolicitacaoExameDAO;
import br.com.frota.model.SolicitacaoExame;

import java.sql.SQLException;

public class ServicoSolicitacaoExame {

    private SolicitacaoExameDAO solicitacaoExameDAO = new SolicitacaoExameDAO();

    public SolicitacaoExame salvar(SolicitacaoExame entidade) {
        return solicitacaoExameDAO.insert(entidade);
    }

    public SolicitacaoExame buscarPorId(Integer id) {
        return solicitacaoExameDAO.findById(id);
    }

    public void update(SolicitacaoExame solicitacaoExame) throws SQLException {solicitacaoExameDAO.updateSolicitacaoExame(solicitacaoExame);}

    public void remover(Integer id) throws SQLException {solicitacaoExameDAO.deleteSolicitacaoExame(id);}
}
