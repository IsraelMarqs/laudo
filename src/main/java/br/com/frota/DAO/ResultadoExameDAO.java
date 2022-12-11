package br.com.frota.DAO;

import br.com.frota.model.ConsultaMedica;
import br.com.frota.model.ResultadoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ResultadoExameDAO extends ConexaoDB{

    private static final String INSERT_RESULTADOEXAME_SQL = "INSERT INTO resultado_exame (dt_exame, valor, composicao_id, laudo_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_RESULTADOEXAME_BY_ID = "SELECT id, dt_exame, valor, composicao_id, laudo_id FROM resultado_exame WHERE id = ?";
    private static final String SELECT_ALL_RESULTADOEXAME = "SELECT * FROM resultado_exame;";
    private static final String DELETE_RESULTADOEXAME_SQL = "DELETE FROM resultado_exame WHERE id = ?;";
    private static final String UPDATE_RESULTADOEXAME_SQL = "UPDATE resultado_exame SET dt_exame = ?, valor = ?, composicao_id = ?, laudo_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM resultado_exame;";

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

    public ResultadoExame insert(ResultadoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESULTADOEXAME_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setTimestamp(1, entidade.getDtExame());
            preparedStatement.setString(2, entidade.getValor());
            preparedStatement.setInt(3, entidade.getComposicaoId());
            preparedStatement.setInt(4, entidade.getLaudoId());

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

    public ResultadoExame findById(Integer id) {
        ResultadoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESULTADOEXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Timestamp dtExame = rs.getTimestamp("dt_exame");
                String valor = rs.getString("valor");
                Integer composicaoId = rs.getInt("composicao_id");
                Integer laudoId = rs.getInt("laudo_id");
                entidade = new ResultadoExame(id, dtExame, valor, composicaoId, laudoId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ResultadoExame> selectAllResultadosExames() {
        List<ResultadoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESULTADOEXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                Timestamp dtExame = rs.getTimestamp("dt_exame");
                String valor = rs.getString("valor");
                Integer composicaoId = rs.getInt("composicao_id");
                Integer laudoId = rs.getInt("laudo_id");
                entidades.add(new ResultadoExame(id, dtExame, valor, composicaoId, laudoId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteResultadoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RESULTADOEXAME_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateResultadoExame(ResultadoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RESULTADOEXAME_SQL)) {
            statement.setInt(1, entidade.getLaudoId());
            statement.setString(2, entidade.getValor());
            statement.setInt(3, entidade.getComposicaoId());
            statement.setInt(4, entidade.getLaudoId());
            statement.setInt(5, entidade.getId());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

