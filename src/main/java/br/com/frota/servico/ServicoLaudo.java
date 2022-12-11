package br.com.frota.servico;

import br.com.frota.DAO.LaudoDAO;
import br.com.frota.model.Laudo;

import java.sql.SQLException;

public class ServicoLaudo {

    private LaudoDAO laudoDAO = new LaudoDAO();

    public Laudo salvar(Laudo entidade) {
        return laudoDAO.insert(entidade);
    }

    public Laudo buscarPorId(Integer id) {
        return laudoDAO.findById(id);
    }

    public void update(Laudo laudo) throws SQLException {laudoDAO.updateLaudo(laudo);}

    public void remover(Integer id) throws SQLException {laudoDAO.deleteLaudo(id);}
}

