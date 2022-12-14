package br.com.frota.util;

import br.com.frota.DAO.*;
import br.com.frota.model.*;
import br.com.frota.servico.*;

import java.sql.SQLException;
import java.util.List;

public class Teste {
    static MedicoDAO Med = new MedicoDAO();
    static ServicoMedico servMed = new ServicoMedico();
    static LaboratorioDAO Lab = new LaboratorioDAO();
    static ServicoLaboratorio servLab = new ServicoLaboratorio();
    static ComposicaoDAO composicaoDAO = new ComposicaoDAO();
    static ServicoComposicao servicoComposicao = new ServicoComposicao();
    static ComposicaoExameDAO composicaoExameDAO = new ComposicaoExameDAO();
    static ServicoComposicaoExame servicoComposicaoExame = new ServicoComposicaoExame();
    static ContatoDAO contatoDAO = new ContatoDAO();
    static ServicoContato servicoContato = new ServicoContato();
    static EnderecoDAO enderecoDAO = new EnderecoDAO();
    static ServicoEndereco servicoEndereco = new ServicoEndereco();
    static EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
    static ServicoEspecialidade servicoEspecialidade = new ServicoEspecialidade();





    public static void main(String[] args) throws SQLException{

        //count
        System.out.println(Med.count());

        //salvar
        Medico medi = new Medico(1,"123","Fred");
        Medico medi2 = new Medico(3,"321","Pedro");
        //servMed.salvar(medi2);

        //buscar por ID
       // Medico a = servMed.buscarPorId(1);
        //System.out.println(servMed.buscarPorId(1));
        //System.out.println(a);

        //Update

        //Medico medico = Med.findById(1);
        //System.out.println(medico);
//
////      Update
        //medico.setNome("Nome novo");
        //medico.setCRM("930842093");
        //Med.updateMedico(medico);
//
        //medico = Med.findById(1);
        //System.out.println(medico);
//
       //

        //Select all
        //List<Medico> medicos = Med.selectAllMedicos();
        //System.out.println(medicos);

        //Delete
        //Med.deleteMedico(2);

        Laboratorio l = new Laboratorio("teste","1234","1234","1234","Lab");
        //servLab.salvar(l);

        Laboratorio la = servLab.buscarPorId(1);
        System.out.println(la);

        //la.setCNES("98754");
        //servLab.update(la);
        //System.out.println(la);

        List<Laboratorio> labs = Lab.selectAllLaboratorios();
        System.out.println(labs);
//
        Composicao comp1 = new Composicao(24,879,1001);
        Composicao comp2 = new Composicao(48,978, 2002);
        servicoComposicao.salvar(comp2);

        Composicao compID = composicaoDAO.findById(1);
        System.out.println(servicoComposicao.buscarPorId(1));
        System.out.println(compID);

        compID.setExameId(72);
        compID.setComposicaoExameId(8547);
        compID.setValorReferenciaComposicaoExameId(3003);
        servicoComposicao.update(compID);

        compID = composicaoDAO.findById(1);
        System.out.println(compID);

        List<Composicao> composicaos = composicaoDAO.selectAllComposicoes();
        composicaos.forEach(System.out::println);

        composicaoDAO.deleteComposicao(2);
//
        ComposicaoExame ComE1 = new ComposicaoExame("Sangue", 547 );
        ComposicaoExame ComE2 = new ComposicaoExame("Plasma", 985);
        servicoComposicaoExame.salvar(ComE2);

        ComposicaoExame ComEID = composicaoExameDAO.findById(1);
        System.out.println(servicoComposicaoExame.buscarPorId(1));
        System.out.println(ComEID);

        ComEID.setDescricao("Nucleo");
        ComEID.setUnidadeMedidaId(8547);
        servicoComposicaoExame.update(ComEID);

        ComEID = composicaoExameDAO.findById(1);
        System.out.println(ComEID);

        List<ComposicaoExame> composicaoExames = composicaoExameDAO.selectAllComposicoesExames();
        composicaoExames.forEach(System.out::println);

        composicaoExameDAO.deleteComposicaoExame(2);
//
        Contato Con1 = new Contato("85987412570", 748);
        Contato Con2 = new Contato("85987412572", 924);
        servicoContato.salvar(Con2);

        Contato ConID = contatoDAO.findById(1);
        System.out.println(servicoContato.buscarPorId(1));
        System.out.println(ConID);

        ConID.setTelefone("85987412586");
        ConID.setLaboratorioId(821);
        servicoContato.update(ConID);

        ConID = contatoDAO.findById(1);
        System.out.println(ConID);

        List<Contato> contatoes = contatoDAO.selectAllContatos();
        contatoes.forEach(System.out::println);

        contatoDAO.deleteContato(2);
//
        Endereco End1 = new Endereco(75,"Benjamin","186", "Casa", "Serrinha", "60741080", "Fortaleza", 74);
        Endereco End2 = new Endereco(85,"Franklin","681", "Apt", "Serrona", "60741070", "Base", 96);
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
        servicoEndereco.update(EndID);

        EndID = enderecoDAO.findById(1);
        System.out.println(EndID);

        List<Endereco> enderecos = enderecoDAO.selectAllEnderecos();
        enderecos.forEach(System.out::println);

        enderecoDAO.deleteEndereco(2);
//
        Especialidade Esp1 = new Especialidade("Dermatologia", "Nenhuma");
        Especialidade Esp2 = new Especialidade("Odontologia", "");
        servicoEspecialidade.salvar(Esp2);

        Especialidade EspID = especialidadeDAO.findById(1);
        System.out.println(servicoEspecialidade.buscarPorId(1));
        System.out.println(EspID);

        EspID.setDescricao("Endocrinologia");
        EspID.setObservacao("Barriga");
        servicoEspecialidade.update(EspID);

        EspID = especialidadeDAO.findById(1);
        System.out.println(EspID);

        List<Especialidade> especialidades = especialidadeDAO.selectAllEspecialidades();
        especialidades.forEach(System.out::println);

        especialidadeDAO.deleteEspecialidade(2);
    }
}
