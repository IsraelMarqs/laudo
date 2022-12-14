package br.com.frota.util;

import br.com.frota.DAO.ConsultaMedicaDAO;
import br.com.frota.model.ConsultaMedica;
import br.com.frota.servico.ServicoConsultaMedica;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TesteConsultaMedica {

    static ConsultaMedicaDAO consultaMedicaDAO = new ConsultaMedicaDAO();

    static ServicoConsultaMedica servicoConsultaMedica = new ServicoConsultaMedica();

    public static void main(String[] args) throws SQLException, ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse("10/12/2022");
        long time=date.getTime();
        new Timestamp(time);
        System.out.println(consultaMedicaDAO.count());

        ConsultaMedica ConM1 = new ConsultaMedica(new Timestamp(time), 1, 1 , "Luca" );
        ConsultaMedica ConM2 = new ConsultaMedica(new Timestamp(time), 1, 1, "Lira");
        servicoConsultaMedica.salvar(ConM1);

        ConsultaMedica ConMID = consultaMedicaDAO.findById(1);
        System.out.println(servicoConsultaMedica.buscarPorId(1));
        System.out.println(ConMID);



        ConMID.setNmAtendimento("Lauro");
        servicoConsultaMedica.update(ConMID);

        ConMID = consultaMedicaDAO.findById(1);
        System.out.println(ConMID);

        List<ConsultaMedica> consultaMedicas = consultaMedicaDAO.selectAllConsultasMedicas();
        consultaMedicas.forEach(System.out::println);

        //consultaMedicaDAO.deleteConsultaMedica(2);
    }
}
