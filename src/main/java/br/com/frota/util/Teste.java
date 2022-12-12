package br.com.frota.util;

import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.DAO.MedicoDAO;
import br.com.frota.model.Laboratorio;
import br.com.frota.model.Medico;
import br.com.frota.servico.ServicoLaboratorio;
import br.com.frota.servico.ServicoMedico;

import java.sql.SQLException;
import java.util.List;

public class Teste {
    static MedicoDAO Med = new MedicoDAO();

    static ServicoMedico servMed = new ServicoMedico();
    static LaboratorioDAO Lab = new LaboratorioDAO();
    static ServicoLaboratorio servLab = new ServicoLaboratorio();
    public static void main(String[] args) throws SQLException{

        //count
        System.out.println(Med.count());

        //salvar
        Medico medi = new Medico(1,"123","Fred");
        Medico medi2 = new Medico(3,"321","Pedro");
        //servMed.salvar(medi2);

        //buscar por ID
       // Medico a = servMed.buscarPorId(1);
        //System.out.println(servMed.buscarPorId(1));
        //System.out.println(a);

        //Update

        //Medico medico = Med.findById(1);
        //System.out.println(medico);
//
////      Update
        //medico.setNome("Nome novo");
        //medico.setCRM("930842093");
        //Med.updateMedico(medico);
//
        //medico = Med.findById(1);
        //System.out.println(medico);
//
       //

        //Select all
        //List<Medico> medicos = Med.selectAllMedicos();
        //System.out.println(medicos);

        //Delete
        //Med.deleteMedico(2);

        Laboratorio l = new Laboratorio("teste","1234","1234","1234","Lab");
        //servLab.salvar(l);

        Laboratorio la = servLab.buscarPorId(1);
        System.out.println(la);

        //la.setCNES("98754");
        //servLab.update(la);
        //System.out.println(la);

        List<Laboratorio> labs = Lab.selectAllLaboratorios();
        System.out.println(labs);


    }
}
