package br.com.frota.servico;

import br.com.frota.DAO.TipoExameDAO;
import br.com.frota.model.TipoExame;

import java.sql.SQLException;

public class ServicoTipoExame {

    private TipoExameDAO tipoExameDAO = new TipoExameDAO();

    public TipoExame salvar(TipoExame entidade) {
        return tipoExameDAO.insert(entidade);
    }

    public TipoExame buscarPorId(Integer id) {
        return tipoExameDAO.findById(id);
    }

    public void update(TipoExame tipoExame) throws SQLException {tipoExameDAO.updateTipoExame(tipoExame);}

    public void remover(Integer id) throws SQLException {tipoExameDAO.deleteTipoExame(id);}
}
