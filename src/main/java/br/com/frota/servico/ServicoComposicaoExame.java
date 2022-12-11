package br.com.frota.servico;

import br.com.frota.DAO.ComposicaoExameDAO;
import br.com.frota.model.ComposicaoExame;

import java.sql.SQLException;

public class ServicoComposicaoExame {

    private ComposicaoExameDAO composicaoExameDAO = new ComposicaoExameDAO();

    public ComposicaoExame salvar(ComposicaoExame entidade) {
        return composicaoExameDAO.insert(entidade);
    }

    public ComposicaoExame buscarPorId(Integer id) {
        return composicaoExameDAO.findById(id);
    }

    public void update(ComposicaoExame composicaoExame) throws SQLException {composicaoExameDAO.updateComposicaoExame(composicaoExame);}

    public void remover(Integer id) throws SQLException {composicaoExameDAO.deleteComposicaoExame(id);}
}
