package br.com.frota.servico;

import br.com.frota.DAO.EnderecoDAO;
import br.com.frota.model.Endereco;

import java.sql.SQLException;

public class ServicoEndereco {

    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    public Endereco salvar(Endereco entidade) {
        return enderecoDAO.insert(entidade);
    }

    public Endereco buscarPorId(Integer id) {
        return enderecoDAO.findById(id);
    }

    public void update(Endereco endereco) throws SQLException {enderecoDAO.updateEndereco(endereco);}

    public void remover(Integer id) throws SQLException {enderecoDAO.deleteEndereco(id);}
}

