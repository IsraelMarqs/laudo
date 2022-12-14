package br.com.frota.util;

import br.com.frota.DAO.EnderecoDAO;
import br.com.frota.model.Endereco;
import br.com.frota.servico.ServicoEndereco;

import java.sql.SQLException;
import java.util.List;

public class TesteEndereco {

    static EnderecoDAO enderecoDAO = new EnderecoDAO();

    static ServicoEndereco servicoEndereco = new ServicoEndereco();

    public static void main(String[] args) throws SQLException {

        System.out.println(enderecoDAO.count());

        Endereco End1 = new Endereco(1,"19","50", "B", "Oriente", "61921200", "Maracanau", 1);
        Endereco End2 = new Endereco(2,"Franklin","681", "C", "Serrona", "60741070", "Base", 3);
        servicoEndereco.salvar(End2);

        Endereco EndID = enderecoDAO.findById(1);
        System.out.println(servicoEndereco.buscarPorId(1));
        System.out.println(EndID);

        EndID.setRua("Rossa");
        EndID.setNumero("968");
        EndID.setComplemento("Resort");
        EndID.setBairro("Serra");
        EndID.setCEP("60458703");
        EndID.setCidade("Forte");
        EndID.setLaboratorio_id(741);
        //servicoEndereco.update(EndID);

        EndID = enderecoDAO.findById(1);
        System.out.println(EndID);

        List<Endereco> enderecos = enderecoDAO.selectAllEnderecos();
        enderecos.forEach(System.out::println);

        //enderecoDAO.deleteEndereco(2);
    }
}
