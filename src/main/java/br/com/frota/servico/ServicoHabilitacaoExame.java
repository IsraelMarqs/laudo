package br.com.frota.servico;

import br.com.frota.DAO.HabilitacaoExameDAO;
import br.com.frota.model.HabilitacaoExame;

import java.sql.SQLException;

public class ServicoHabilitacaoExame {

    private HabilitacaoExameDAO habilitacaoExameDAO = new HabilitacaoExameDAO();

    public HabilitacaoExame salvar(HabilitacaoExame entidade) {
        return habilitacaoExameDAO.insert(entidade);
    }

    public HabilitacaoExame buscarPorId(Integer id) {
        return habilitacaoExameDAO.findById(id);
    }

    public void update(HabilitacaoExame habilitacaoExame) throws SQLException {habilitacaoExameDAO.updateHabilitacaoExame(habilitacaoExame);}

    public void remover(Integer id) throws SQLException {habilitacaoExameDAO.deleteHabilitacaoExame(id);}
}

