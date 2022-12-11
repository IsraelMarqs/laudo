package br.com.frota.DAO;

import br.com.frota.model.Endereco;
import br.com.frota.model.ResponsavelTecnico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsavelTecnicoDAO extends ConexaoDB{

    private static final String INSERT_RESPONSAVELTECNICO_SQL = "INSERT INTO responsavel_tecnico (nome, conselho, formacao, sigla_formacao, sigla_formacao_id) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_RESPONSAVELTECNICO_BY_ID = "SELECT id, nome, conselho, formacao, sigla_formacao, sigla_formacao_id FROM responsavel_tecnico WHERE id = ?";
    private static final String SELECT_ALL_RESPONSAVELTECNICO = "SELECT * FROM responsavel_tecnico;";
    private static final String DELETE_RESPONSAVELTECNICO_SQL = "DELETE FROM responsavel_tecnico WHERE id = ?;";
    private static final String UPDATE_RESPONSAVELTECNICO_SQL = "UPDATE responsavel_tecnico SET nome = ?, conselho = ?, formacao = ?, sigla_formacao = ?, sigla_formacao_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM responsavel_tecnico;";

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

    public ResponsavelTecnico insert(ResponsavelTecnico entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESPONSAVELTECNICO_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getConselho());
            preparedStatement.setString(3, entidade.getFormacao());
            preparedStatement.setString(4, entidade.getSiglaFormacao());
            preparedStatement.setInt(5, entidade.getSiglaFormacaoId());

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

    public ResponsavelTecnico findById(Integer id) {
        ResponsavelTecnico entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESPONSAVELTECNICO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String conselho = rs.getString("conselho");
                String formacao = rs.getString("formacao");
                String siglaFormacao = rs.getString("sigla_formacao");
                Integer siglaFormacaoId = rs.getInt("sigla_formacao_id");
                entidade = new ResponsavelTecnico(id, nome, conselho, formacao, siglaFormacao, siglaFormacaoId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ResponsavelTecnico> selectAllResponsaveisTecnicos() {
        List<ResponsavelTecnico> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESPONSAVELTECNICO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String conselho = rs.getString("conselho");
                String formacao = rs.getString("formacao");
                String siglaFormacao = rs.getString("sigla_formacao");
                Integer siglaFormacaoId = rs.getInt("sigla_formacao_id");
                entidades.add(new ResponsavelTecnico(id, nome, conselho, formacao, siglaFormacao, siglaFormacaoId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteResponsavelTecnico(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RESPONSAVELTECNICO_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateResponsavelTecnico(ResponsavelTecnico entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RESPONSAVELTECNICO_SQL)) {
            statement.setString(1, entidade.getNome());
            statement.setString(2, entidade.getConselho());
            statement.setString(3, entidade.getFormacao());
            statement.setString(4, entidade.getSiglaFormacao());
            statement.setInt(5, entidade.getSiglaFormacaoId());
            statement.setInt(6, entidade.getId());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}