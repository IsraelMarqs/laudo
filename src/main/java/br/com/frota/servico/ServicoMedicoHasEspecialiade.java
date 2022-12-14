package br.com.frota.servico;

import br.com.frota.DAO.MedicoHasEspecialidadeDAO;
import br.com.frota.model.MedicoHasEspecialidade;

import java.sql.SQLException;

public class ServicoMedicoHasEspecialiade {

    private MedicoHasEspecialidadeDAO medicoHasEspecialidadeDAO = new MedicoHasEspecialidadeDAO();

    public MedicoHasEspecialidade salvar(MedicoHasEspecialidade entidade) { return medicoHasEspecialidadeDAO.insert(entidade); }

    public MedicoHasEspecialidade buscarPorId(Integer id) { return medicoHasEspecialidadeDAO.findById(id); }

    public void update(MedicoHasEspecialidade medicoHasEspecialidade) throws SQLException { medicoHasEspecialidadeDAO.updateMedicoHasEspecialidade(medicoHasEspecialidade); }

    public void remover(Integer id) throws SQLException { medicoHasEspecialidadeDAO.deleteMedicoHasEspecialidade(id); }
}
