package br.com.frota.util;

import br.com.frota.DAO.MedicoDAO;
import br.com.frota.model.Medico;
import br.com.frota.servico.ServicoMedico;

import java.sql.SQLException;
import java.util.List;

public class Teste {
    static MedicoDAO Med = new MedicoDAO();

    static ServicoMedico servMed = new ServicoMedico();

    public static void main(String[] args) throws SQLException{

        //count
        System.out.println(Med.count());

        //salvar
        Medico medi = new Medico(1,"123","Fred");
        Medico medi2 = new Medico(3,"321","Pedro");
        //servMed.salvar(medi2);

        //buscar por ID
        Medico a = servMed.buscarPorId(1);
        //System.out.println(servMed.buscarPorId(1));
        //System.out.println(a);

        //Update
        //try {
      //      a.setNome("Paulo");
       //     a.setCRM("897");
            servMed.update(a);
       // Medico a2 = servMed.buscarPorId(1);

       // System.out.println(a2);
        Medico medico = Med.findById(1);
        System.out.println(medico);
//
////      Update
        medico.setNome("Nome novo");
        medico.setCRM("930842093");
        Med.updateMedico(medico);
//
        medico = Med.findById(1);
        System.out.println(medico);
//
       // } catch (SQLException e) {
        //    throw new RuntimeException(e);
        //}

        //marca = marcaDAO.findById(2);
        //System.out.println(marca);

        //Select all
        //List<Medico> medicos = Med.selectAllMedicos();
        //System.out.println(medicos);

        //Delete
        //Med.deleteMedico(2);

    }
}
