package br.com.frota.DAO;

import br.com.frota.model.ConsultaMedica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ConsultaMedicaDAO extends ConexaoDB{

    private static final String INSERT_CONSULTAMEDICA_SQL = "INSERT INTO consulta_medica (dt_consulta, medico_id, paciente_id, nm_atendimento) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CONSULTAMEDICA_BY_ID = "SELECT id, dt_consulta, medico_id, paciente_id, nm_atendimento FROM consulta_medica WHERE id = ?";
    private static final String SELECT_ALL_CONSULTAMEDICA = "SELECT * FROM consulta_medica;";
    private static final String DELETE_CONSULTAMEDICA_SQL = "DELETE FROM consulta_medica WHERE id = ?;";
    private static final String UPDATE_CONSULTAMEDICA_SQL = "UPDATE consulta_medica SET dt_consulta = ?, medico_id = ?, paciente_id = ?, nm_atendimento = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM consulta_medica;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    public ConsultaMedica insert(ConsultaMedica entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONSULTAMEDICA_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setTimestamp(1, entidade.getDtConsulta());
            preparedStatement.setInt(2, entidade.getMedicoId());
            preparedStatement.setInt(3, entidade.getPacienteId());
            preparedStatement.setString(4, entidade.getNmAtendimento());

            preparedStatement.executeUpdate();

            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                entidade.setId(result.getInt(1));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return entidade;
    }

    public ConsultaMedica findById(Integer id) {
        ConsultaMedica entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONSULTAMEDICA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Timestamp dtConsulta = rs.getTimestamp("dt_consulta");
                Integer medicoId = rs.getInt("medico_id");
                Integer pacienteId = rs.getInt("paciente_id");
                String nmAtendimento = rs.getString("nm_atendimento");
                entidade = new ConsultaMedica(id, dtConsulta, medicoId, pacienteId, nmAtendimento);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ConsultaMedica> selectAllConsultasMedicas() {
        List<ConsultaMedica> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONSULTAMEDICA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                Timestamp dtConsulta = rs.getTimestamp("dt_consulta");
                Integer medicoId = rs.getInt("medico_id");
                Integer pacienteId = rs.getInt("paciente_id");
                String nmAtendimento = rs.getString("nm_atendimento");;
                entidades.add(new ConsultaMedica(id, dtConsulta, medicoId, pacienteId, nmAtendimento));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteConsultaMedica(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CONSULTAMEDICA_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateConsultaMedica(ConsultaMedica entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CONSULTAMEDICA_SQL)) {
            statement.setTimestamp(1, entidade.getDtConsulta());
            statement.setInt(2, entidade.getMedicoId());
            statement.setInt(3, entidade.getPacienteId());
            statement.setString(4, entidade.getNmAtendimento());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
