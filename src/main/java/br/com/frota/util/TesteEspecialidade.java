package br.com.frota.util;

import br.com.frota.DAO.EspecialidadeDAO;
import br.com.frota.model.Especialidade;
import br.com.frota.servico.ServicoEspecialidade;

import java.sql.SQLException;
import java.util.List;

public class TesteEspecialidade {

    static EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

    static ServicoEspecialidade servicoEspecialidade = new ServicoEspecialidade();

    public static void main(String[] args) throws SQLException {

        System.out.println(especialidadeDAO.count());


        Especialidade Esp1 = new Especialidade("Oftamologia");
        Especialidade Esp2 = new Especialidade("Neurologia");
        servicoEspecialidade.salvar(Esp1);

        Especialidade EspID = especialidadeDAO.findById(1);
        System.out.println(servicoEspecialidade.buscarPorId(1));
        System.out.println(EspID);

        EspID.setDescricao("Endocrinologia");
        EspID.setObservacao("Em treinamento");
        servicoEspecialidade.update(EspID);

        EspID = especialidadeDAO.findById(1);
        System.out.println(EspID);

        List<Especialidade> especialidades = especialidadeDAO.selectAllEspecialidades();
        especialidades.forEach(System.out::println);

        //especialidadeDAO.deleteEspecialidade(2);
    }
}
