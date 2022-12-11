package br.com.frota.servico;

import br.com.frota.DAO.MaterialExameDAO;
import br.com.frota.model.MaterialExame;

import java.sql.SQLException;

public class ServicoMaterialExame {

    private MaterialExameDAO materialExameDAO = new MaterialExameDAO();

    public MaterialExame salvar(MaterialExame entidade) { return materialExameDAO.insert(entidade); }

    public MaterialExame buscarPorId(Integer id) {
        return materialExameDAO.findById(id);
    }

    public void update(MaterialExame materialExame) throws SQLException {materialExameDAO.updateMaterialExame(materialExame);}

    public void remover(Integer id) throws SQLException {materialExameDAO.deleteMaterialExame(id);}
}
