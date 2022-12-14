package br.com.frota.util;

import br.com.frota.DAO.MedicoHasEspecialidadeDAO;
import br.com.frota.model.MedicoHasEspecialidade;
import br.com.frota.servico.ServicoMedicoHasEspecialiade;

import java.sql.SQLException;
import java.util.List;

public class TesteMedicoHasEspecialidade {

    static MedicoHasEspecialidadeDAO medicoHasEspecialidadeDAO = new MedicoHasEspecialidadeDAO();

    static ServicoMedicoHasEspecialiade servicoMedicoHasEspecialiade = new ServicoMedicoHasEspecialiade();

    public static void main(String[] args) throws SQLException {

        System.out.println(medicoHasEspecialidadeDAO.count());

        MedicoHasEspecialidade MedHE1 = new MedicoHasEspecialidade(1,1);
        MedicoHasEspecialidade MedHE2 = new MedicoHasEspecialidade(3, 741);
        //servicoMedicoHasEspecialiade.salvar(MedHE1);

        MedicoHasEspecialidade MedHEID = medicoHasEspecialidadeDAO.findById(1);
        //System.out.println(servicoMedicoHasEspecialiade.buscarPorId(1));
        //System.out.println(MedHEID);

        MedHEID.setMedicoId(2);
        MedHEID.setEspecialidadeId(2);
        //servicoMedicoHasEspecialiade.update(MedHEID);

        MedHEID = medicoHasEspecialidadeDAO.findById(1);
        System.out.println(MedHEID);

        List<MedicoHasEspecialidade> medicoHasEspecialidades = medicoHasEspecialidadeDAO.selectAllMedicosHasEspecialidades();
        medicoHasEspecialidades.forEach(System.out::println);

        medicoHasEspecialidadeDAO.deleteMedicoHasEspecialidade(1);
    }
}
