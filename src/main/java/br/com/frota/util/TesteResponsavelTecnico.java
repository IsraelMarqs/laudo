package br.com.frota.util;

import br.com.frota.DAO.ResponsavelTecnicoDAO;
import br.com.frota.model.ResponsavelTecnico;
import br.com.frota.servico.ServicoResponsavelTecnico;

import java.sql.SQLException;
import java.util.List;

public class TesteResponsavelTecnico {

    static ResponsavelTecnicoDAO responsavelTecnicoDAO = new ResponsavelTecnicoDAO();

    static ServicoResponsavelTecnico servicoResponsavelTecnico = new ServicoResponsavelTecnico();

    public static void main(String[] args) throws SQLException {

        System.out.println(responsavelTecnicoDAO.count());

        ResponsavelTecnico ResT1 = new ResponsavelTecnico("Igor", "A", "Oftamologia", "OD", 1);
        ResponsavelTecnico ResT2 = new ResponsavelTecnico("Marcos", "B", "Endocrinologia", "EN", 1);
        servicoResponsavelTecnico.salvar(ResT1);

        ResponsavelTecnico ResTID = responsavelTecnicoDAO.findById(1);
        System.out.println(servicoResponsavelTecnico.buscarPorId(1));
        System.out.println(ResTID);

        ResTID.setNome("Sergio");
        ResTID.setConselho("C");
        ResTID.setFormacao("Psicologia");
        ResTID.setSiglaFormacao("DE");
        ResTID.setSiglaFormacaoId(2);
        //servicoResponsavelTecnico.update(ResTID);

        ResTID = responsavelTecnicoDAO.findById(1);
        System.out.println(ResTID);

        List<ResponsavelTecnico> responsavelTecnicos = responsavelTecnicoDAO.selectAllResponsaveisTecnicos();
        responsavelTecnicos.forEach(System.out::println);

       // responsavelTecnicoDAO.deleteResponsavelTecnico(2);
    }
}
