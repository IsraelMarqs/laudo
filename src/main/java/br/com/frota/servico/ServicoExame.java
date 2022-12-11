package br.com.frota.servico;

import br.com.frota.DAO.ExameDAO;
import br.com.frota.model.Exame;

import java.sql.SQLException;

public class ServicoExame {

    private ExameDAO exameDAO = new ExameDAO();

    public Exame salvar(Exame entidade) {
        return exameDAO.insert(entidade);
    }

    public Exame buscarPorId(Integer id) {
        return exameDAO.findById(id);
    }

    public void update(Exame exame) throws SQLException {exameDAO.updateExame(exame);}

    public void remover(Integer id) throws SQLException {exameDAO.deleteExame(id);}
}

