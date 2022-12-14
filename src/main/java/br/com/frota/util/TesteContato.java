package br.com.frota.util;

import br.com.frota.DAO.ContatoDAO;
import br.com.frota.model.Contato;
import br.com.frota.servico.ServicoContato;

import java.sql.SQLException;
import java.util.List;

public class TesteContato {

    static ContatoDAO contatoDAO = new ContatoDAO();
    static ServicoContato servicoContato = new ServicoContato();
    public static void main(String[] args) throws SQLException {

        System.out.println(contatoDAO.count());

        Contato Con1 = new Contato("85986822601", 1);
        Contato Con2 = new Contato("85986822602", 3);
        servicoContato.salvar(Con2);

        Contato ConID = contatoDAO.findById(1);
        System.out.println(servicoContato.buscarPorId(1));
        System.out.println(ConID);

        ConID.setTelefone("85986822603");

       // servicoContato.update(ConID);

        ConID = contatoDAO.findById(1);
        System.out.println(ConID);

        List<Contato> contatoes = contatoDAO.selectAllContatos();
        contatoes.forEach(System.out::println);

       // contatoDAO.deleteContato(2);
    }
}
