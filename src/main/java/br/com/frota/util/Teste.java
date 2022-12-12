package br.com.frota.util;

import br.com.frota.DAO.MedicoDAO;
import br.com.frota.model.Medico;
import br.com.frota.servico.ServicoMedico;

import java.sql.SQLException;
import java.util.List;

public class Teste {
    static MedicoDAO Med = new MedicoDAO();

    static ServicoMedico servMed = new ServicoMedico();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(Med.count());

        //salvar
        Medico medi = new Medico(1,"123","Fred");
        Medico medi2 = new Medico(2,"321","Pedro");
        //servMed.salvar(medi2);

        //buscar por ID
        //Med.findById(2);
        System.out.println(Med.findById(2));

        //Update
        medi.setNome("Paulo");
        Med.updateMedico(medi);

        //marca = marcaDAO.findById(2);
        //System.out.println(marca);

        //Select all
        List<Medico> medicos = Med.selectAllMedicos();
        System.out.println(medicos);

        //Delete
        //Med.deleteMedico(2);

    }
}
