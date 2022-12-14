package br.com.frota.util;

import br.com.frota.DAO.ResponsavelTecnicoHasLaboratorioDAO;
import br.com.frota.model.ResponsavelTecnicoHasLaboratorio;
import br.com.frota.servico.ServicoResponsavelTecnicoHasLaboratorio;

import java.sql.SQLException;
import java.util.List;

public class TesteResponsavelTecnicoHasLaboratorio {

    static ResponsavelTecnicoHasLaboratorioDAO responsavelTecnicoHasLaboratorioDAO = new ResponsavelTecnicoHasLaboratorioDAO();

    static ServicoResponsavelTecnicoHasLaboratorio servicoResponsavelTecnicoHasLaboratorio = new ServicoResponsavelTecnicoHasLaboratorio();

    public static void main(String[] args) throws SQLException {

        System.out.println(responsavelTecnicoHasLaboratorioDAO.count());

        ResponsavelTecnicoHasLaboratorio ResTHL1 = new ResponsavelTecnicoHasLaboratorio(974, 744);
        ResponsavelTecnicoHasLaboratorio ResTHL2 = new ResponsavelTecnicoHasLaboratorio(852, 674);
        servicoResponsavelTecnicoHasLaboratorio.salvar(ResTHL2);

        ResponsavelTecnicoHasLaboratorio ResTHLID = responsavelTecnicoHasLaboratorioDAO.findById(1);
        System.out.println(servicoResponsavelTecnicoHasLaboratorio.buscarPorId(1));
        System.out.println(ResTHLID);

        ResTHLID.setResponsavelTecnicoId(4741);
        ResTHLID.setLaboratorioId(720);
        servicoResponsavelTecnicoHasLaboratorio.update(ResTHLID);

        ResTHLID = responsavelTecnicoHasLaboratorioDAO.findById(1);
        System.out.println(ResTHLID);

        List<ResponsavelTecnicoHasLaboratorio> responsavelTecnicoHasLaboratorios = responsavelTecnicoHasLaboratorioDAO.selectAllResponsaveisTecnicosHasLaboratorios();
        responsavelTecnicoHasLaboratorios.forEach(System.out::println);

        responsavelTecnicoHasLaboratorioDAO.deleteResponsavelTecnicoHasLaboratorio(2);
    }
}
