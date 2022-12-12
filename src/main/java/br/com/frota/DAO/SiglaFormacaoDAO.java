package br.com.frota.DAO;

import br.com.frota.model.Paciente;
import br.com.frota.model.SiglaFormacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SiglaFormacaoDAO extends ConexaoDB{

    private static final String INSERT_SIGLAFORMACAO_SQL = "INSERT INTO sigla_formacao (silga) VALUES (?);";
    private static final String SELECT_SIGLAFORMACAO_BY_ID = "SELECT id, sigla FROM sigla_formacao WHERE id = ?";
    private static final String SELECT_ALL_SIGLAFORMACAO = "SELECT * FROM sigla_formacao;";
    private static final String DELETE_SIGLAFORMACAO_SQL = "DELETE FROM sigla_formacao WHERE id = ?;";
    private static final String UPDATE_SIGLAFORMACAO_SQL = "UPDATE sigla_formacao SET sigla = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM sigla_formacao;";

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

    public SiglaFormacao insert(SiglaFormacao entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SIGLAFORMACAO_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getSigla());


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

    public SiglaFormacao findById(Integer id) {
        SiglaFormacao entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_SIGLAFORMACAO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String sigla = rs.getString("sigla");
                entidade = new SiglaFormacao(id, sigla);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<SiglaFormacao> selectAllSiglasFormacoes() {
        List<SiglaFormacao> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_SIGLAFORMACAO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String sigla = rs.getString("sigla");
                entidades.add(new SiglaFormacao(id, sigla));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteSiglaFormacao(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_SIGLAFORMACAO_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateSiglaFormacao(SiglaFormacao entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_SIGLAFORMACAO_SQL)) {
            statement.setString(1, entidade.getSigla());
            statement.setInt(2, entidade.getId());
            boolean bool = statement.executeUpdate() > 0;
            statement.getConnection().close();
            return bool;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
