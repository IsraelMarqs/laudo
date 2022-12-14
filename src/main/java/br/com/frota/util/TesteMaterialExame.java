package br.com.frota.util;

import br.com.frota.DAO.MaterialExameDAO;
import br.com.frota.model.MaterialExame;
import br.com.frota.servico.ServicoMaterialExame;

import java.sql.SQLException;
import java.util.List;

public class TesteMaterialExame {

    static MaterialExameDAO materialExameDAO = new MaterialExameDAO();

    static ServicoMaterialExame servicoMaterialExame = new ServicoMaterialExame();

    public static void main(String[] args) throws SQLException {

        System.out.println(materialExameDAO.count());


        MaterialExame MatE1 = new MaterialExame("Sangue");
        MaterialExame MatE2 = new MaterialExame("Urina", "2 unidades");
        servicoMaterialExame.salvar(MatE1);

        MaterialExame MatEID = materialExameDAO.findById(1);
        System.out.println(servicoMaterialExame.buscarPorId(1));
        System.out.println(MatEID);



        MatEID.setObservacao("O+");
        servicoMaterialExame.update(MatEID);

        MatEID = materialExameDAO.findById(1);
        System.out.println(MatEID);

        List<MaterialExame> materialExames = materialExameDAO.selectAllMateriaisExames();
        materialExames.forEach(System.out::println);

        //materialExameDAO.deleteMaterialExame(2);
    }
}
