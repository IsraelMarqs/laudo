package br.com.frota.util;

import br.com.frota.DAO.TipoExameDAO;
import br.com.frota.model.TipoExame;
import br.com.frota.servico.ServicoTipoExame;

import java.sql.SQLException;
import java.util.List;

public class TesteTipoExame {

    static TipoExameDAO tipoExameDAO = new TipoExameDAO();

    static ServicoTipoExame servicoTipoExame = new ServicoTipoExame();

    public static void main(String[] args) throws SQLException {

        System.out.println(tipoExameDAO.count());

        TipoExame TipoE1 = new TipoExame("Sangue", "Criança");
        TipoExame TipoE2 = new TipoExame("Urina");
        servicoTipoExame.salvar(TipoE1);

        TipoExame TipoEID = tipoExameDAO.findById(1);
        System.out.println(servicoTipoExame.buscarPorId(1));
        System.out.println(TipoEID);


        TipoEID.setObservacao("Medo de agulhas");
        servicoTipoExame.update(TipoEID);

        TipoEID = tipoExameDAO.findById(1);
        System.out.println(TipoEID);

        List<TipoExame> tipoExames = tipoExameDAO.selectAllTiposMedicos();
        tipoExames.forEach(System.out::println);

        //tipoExameDAO.deleteTipoExame(2);
    }
}
