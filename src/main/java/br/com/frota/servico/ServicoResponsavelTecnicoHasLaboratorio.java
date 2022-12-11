package br.com.frota.servico;

import br.com.frota.DAO.ResponsavelTecnicoHasLaboratorioDAO;
import br.com.frota.model.ResponsavelTecnicoHasLaboratorio;

import java.sql.SQLException;

public class ServicoResponsavelTecnicoHasLaboratorio {

    private ResponsavelTecnicoHasLaboratorioDAO responsavelTecnicoHasLaboratorioDAO = new ResponsavelTecnicoHasLaboratorioDAO();

    public ResponsavelTecnicoHasLaboratorio salvar(ResponsavelTecnicoHasLaboratorio entidade) {return responsavelTecnicoHasLaboratorioDAO.insert(entidade);}

    public ResponsavelTecnicoHasLaboratorio buscarPorId(Integer id) {return responsavelTecnicoHasLaboratorioDAO.findById(id);}

    public void update(ResponsavelTecnicoHasLaboratorio responsavelTecnicoHasLaboratorio) throws SQLException {responsavelTecnicoHasLaboratorioDAO.updateResponsaveltecnicohaslaboratorio(responsavelTecnicoHasLaboratorio);}

    public void remover(Integer id) throws SQLException {responsavelTecnicoHasLaboratorioDAO.deleteResponsavelTecnicoHasLaboratorio(id);}
}

