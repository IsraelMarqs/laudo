package br.com.frota.util;

import br.com.frota.DAO.PacienteDAO;
import br.com.frota.model.Paciente;
import br.com.frota.servico.ServicoPaciente;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestePaciente {
    static PacienteDAO pacienteDAO = new PacienteDAO();

    static ServicoPaciente servicoPaciente = new ServicoPaciente();

    public static void main(String[] args) throws SQLException, ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse("23/12/2021");
        long time=date.getTime();
        new Timestamp(time);

        System.out.println(pacienteDAO.count());

        Paciente Pac1 = new Paciente("Felipe", new Timestamp(time));
        //Paciente Pac2 = new Paciente("Castro", 857);
        servicoPaciente.salvar(Pac1);

        Paciente PacID = pacienteDAO.findById(1);
        System.out.println(servicoPaciente.buscarPorId(1));
        System.out.println(PacID);

        PacID.setNome("João");
       // PacID.setDtNascimento(985);
        servicoPaciente.update(PacID);

        PacID = pacienteDAO.findById(1);
        System.out.println(PacID);

        List<Paciente> pacientes = pacienteDAO.selectAllPacientes();
        pacientes.forEach(System.out::println);

        //pacienteDAO.deletePaciente(2);
    }
}
