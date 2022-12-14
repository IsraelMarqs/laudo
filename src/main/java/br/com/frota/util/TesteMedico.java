package br.com.frota.util;

import br.com.frota.DAO.MedicoDAO;
import br.com.frota.model.Medico;
import br.com.frota.servico.ServicoMedico;

import java.sql.SQLException;
import java.util.List;

public class TesteMedico {

    static MedicoDAO medicoDAO = new MedicoDAO();

    static ServicoMedico servicoMedico = new ServicoMedico();

    public static void main(String[] args) throws SQLException {

        System.out.println(medicoDAO.count());

        Medico medico1 = new Medico("123", "Abreu");
        Medico medico2 = new Medico("456", "João");
        servicoMedico.salvar(medico2);

        Medico medID = medicoDAO.findById(1);
        System.out.println(servicoMedico.buscarPorId(1));
        System.out.println(medID);

        medID.setCRM("789");
        medID.setNome("Vitor");
        servicoMedico.update(medID);

        medID = medicoDAO.findById(1);
        System.out.println(medID);

        List<Medico> medicos = medicoDAO.selectAllMedicos();
        medicos.forEach(System.out::println);

        medicoDAO.deleteMedico(2);
    }
}
