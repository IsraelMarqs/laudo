package br.com.frota.util;

import br.com.frota.DAO.MedicoDAO;
import br.com.frota.model.Medico;
import br.com.frota.servico.ServicoMedico;

import java.sql.SQLException;

public class Teste {
    static MedicoDAO Med = new MedicoDAO();

    static ServicoMedico servMed = new ServicoMedico();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(Med.count());

        //salvar
        Medico medi = new Medico(1,"123","Fred");
        servMed.salvar(medi);

        //buscar por ID
        Med = medi.findById(1);
        //System.out.println(marca);

        //Update
       // marca.setDescricao("Volt");
       // marcaDAO.updateMarca(marca);
        //marca = marcaDAO.findById(2);
        //System.out.println(marca);

        //Select all
       // List<Marca> marcas = marcaDAO.selectAllMarcas();
        //marcas.forEach(System.out::println());

        //Delete
       // marcaDAO.deleteMarca(2);
        //marcaDAO.selectAllMarcas().forEach(System.out::println);
    }
}
