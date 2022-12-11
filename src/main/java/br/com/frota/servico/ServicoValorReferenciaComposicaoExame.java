package br.com.frota.servico;

import br.com.frota.DAO.ValorReferenciaComposicaoExameDAO;
import br.com.frota.model.ValorReferenciaComposicaoExame;

import java.sql.SQLException;

public class ServicoValorReferenciaComposicaoExame {

    private ValorReferenciaComposicaoExameDAO valorReferenciaComposicaoExameDAO = new ValorReferenciaComposicaoExameDAO();

    public ValorReferenciaComposicaoExame salvar(ValorReferenciaComposicaoExame entidade) {return valorReferenciaComposicaoExameDAO.insert(entidade);}

    public ValorReferenciaComposicaoExame buscarPorId(Integer id) {return valorReferenciaComposicaoExameDAO.findById(id);}

    public void update(ValorReferenciaComposicaoExame valorReferenciaComposicaoExame) throws SQLException {valorReferenciaComposicaoExameDAO.updateValorReferenciaComposicaoExame(valorReferenciaComposicaoExame);}

    public void remover(Integer id) throws SQLException { valorReferenciaComposicaoExameDAO.deleteValorReferenciaComposicaoExame(id);}
}
