package br.com.frota.DAO;

import br.com.frota.model.SolicitacaoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoExameDAO extends ConexaoDB{

    private static final String INSERT_SOLICITACAOEXAME_SQL = "INSERT INTO solicitacao_exame (nmPrescito, consultaMedicaId, dtSolicitacao, habilitacaoExameId, exameId) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_SOLICITACAOEXAME_BY_ID = "SELECT id, nmPrescito, consultaMedicaId, dtSolicitacao, habilitacaoExameId, exameId FROM solicitacao_exame WHERE id = ?";
    private static final String SELECT_ALL_SOLICITACAOEXAME = "SELECT * FROM solicitacao_exame;";
    private static final String DELETE_SOLICITACAOEXAME_SQL = "DELETE FROM solicitacao_exame WHERE id = ?;";
    private static final String UPDATE_SOLICITACAOEXAME_SQL = "UPDATE solicitacao_exame SET nmPrescito = ?, consultaMedicaId = ?, dtSolicitacao = ?, habilitacaoExameId = ?, exameId = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM solicitacao_exame;";

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

    public SolicitacaoExame insert(SolicitacaoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SOLICITACAOEXAME_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getNmPrescito());
            preparedStatement.setInt(2, entidade.getConsultaMedicaId());
            preparedStatement.setTimestamp(3, entidade.getDtSolicitacao());
            preparedStatement.setInt(4, entidade.getHabilitacaoExameId());
            preparedStatement.setInt(5, entidade.getExameId());

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

    public SolicitacaoExame findById(Integer id) {
        SolicitacaoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_SOLICITACAOEXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nmPrescito = rs.getString("nm_prescito");
                Integer consultaMedicaId = rs.getInt("consulta_medica_id");
                Timestamp dtSolicitacao = rs.getTimestamp("dt_solicitacao");
                Integer habilitacaoExameId = rs.getInt("habilitacao_exame_id");
                Integer exameId = rs.getInt("exame_id");
                entidade = new SolicitacaoExame(id, nmPrescito, consultaMedicaId, dtSolicitacao, habilitacaoExameId, habilitacaoExameId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<SolicitacaoExame> selectAllSolicitacaoExame() {
        List<SolicitacaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_SOLICITACAOEXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nmPrescito = rs.getString("nm_prescito");
                Integer consultaMedicaId = rs.getInt("consulta_medica_id");
                Timestamp dtSolicitacao = rs.getTimestamp("dt_solicitacao");
                Integer habilitacaoExameId = rs.getInt("habilitacao_exame_id");
                Integer exameId = rs.getInt("exame_id");
                entidades.add(new SolicitacaoExame(id, nmPrescito, consultaMedicaId, dtSolicitacao, habilitacaoExameId,exameId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteSolicitacaoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_SOLICITACAOEXAME_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateSolicitacaoExame(SolicitacaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_SOLICITACAOEXAME_SQL)) {
            statement.setString(1, entidade.getNmPrescito());
            statement.setInt(2, entidade.getConsultaMedicaId());
            statement.setTimestamp(3, entidade.getDtSolicitacao());
            statement.setInt(4, entidade.getHabilitacaoExameId());
            statement.setInt(5, entidade.getExameId());
            statement.setInt(6, entidade.getId());
            boolean bool = statement.executeUpdate() > 0;
            statement.getConnection().close();
            return bool;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
