package br.com.frota.servico;

import br.com.frota.DAO.ComposicaoDAO;
import br.com.frota.model.Composicao;

import java.sql.SQLException;

public class ServicoComposicao {

    private ComposicaoDAO composicaoDAO = new ComposicaoDAO();

    public Composicao salvar(Composicao entidade) {
        return composicaoDAO.insert(entidade);
    }

    public Composicao buscarPorId(Integer id) {
        return composicaoDAO.findById(id);
    }

    public void update(Composicao composicao) throws SQLException {composicaoDAO.updateComposicao(composicao);}

    public void remover(Integer id) throws SQLException {composicaoDAO.deleteComposicao(id);}
}
