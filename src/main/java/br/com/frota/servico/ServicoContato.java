package br.com.frota.servico;

import br.com.frota.DAO.ContatoDAO;
import br.com.frota.model.Contato;

import java.sql.SQLException;

public class ServicoContato {

    private ContatoDAO contatoDAO = new ContatoDAO();

    public Contato salvar(Contato entidade) {
        return contatoDAO.insert(entidade);
    }

    public Contato buscarPorId(Integer id) {
        return contatoDAO.findById(id);
    }

    public void update(Contato contato) throws SQLException {contatoDAO.updateContato(contato);}

    public void remover(Integer id) throws SQLException {contatoDAO.deleteContato(id);}
}
