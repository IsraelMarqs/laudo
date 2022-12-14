package br.com.frota.util;

import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.model.Laboratorio;
import br.com.frota.servico.ServicoLaboratorio;

import java.sql.SQLException;
import java.util.List;

public class TesteLaboratorio {

    static LaboratorioDAO laboratorioDAO = new LaboratorioDAO();

    static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();

    public static void main(String[] args) throws SQLException {

        System.out.println(laboratorioDAO.count());


        Laboratorio Lab1 = new Laboratorio("Lab", "8129028", "12345678", "252352", "Labz");
        Laboratorio Lab2 = new Laboratorio("Lab2", "690844", "901234567", "2525353", "Labx");
        //servicoLaboratorio.salvar(Lab2);

        Laboratorio LabID = laboratorioDAO.findById(3);
        System.out.println(servicoLaboratorio.buscarPorId(1));


        //LabID.setDescricao("Lab");
        //LabID.setCNES("123454");
        //LabID.setCNPJ("124125");
        //LabID.setCRBM("12312141");
        //LabID.setNomeFantasia("Labv");
        LabID.setId(2);
        servicoLaboratorio.update(LabID);

        LabID = laboratorioDAO.findById(1);
        System.out.println(LabID);

        List<Laboratorio> laboratorios = laboratorioDAO.selectAllLaboratorios();
        laboratorios.forEach(System.out::println);

        //laboratorioDAO.deleteLaboratorio(2);
    }
}
