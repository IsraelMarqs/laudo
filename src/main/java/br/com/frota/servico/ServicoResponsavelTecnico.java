package br.com.frota.servico;

import br.com.frota.DAO.ResponsavelTecnicoDAO;
import br.com.frota.model.ResponsavelTecnico;

import java.sql.SQLException;

public class ServicoResponsavelTecnico {

    private ResponsavelTecnicoDAO responsavelTecnicoDAO = new ResponsavelTecnicoDAO();

    public ResponsavelTecnico salvar(ResponsavelTecnico entidade) {
        return responsavelTecnicoDAO.insert(entidade);
    }

    public ResponsavelTecnico buscarPorId(Integer id) {
        return responsavelTecnicoDAO.findById(id);
    }

    public void update(ResponsavelTecnico responsavelTecnico) throws SQLException {responsavelTecnicoDAO.updateResponsavelTecnico(responsavelTecnico);}

    public void remover(Integer id) throws SQLException {responsavelTecnicoDAO.deleteResponsavelTecnico(id);}
}

