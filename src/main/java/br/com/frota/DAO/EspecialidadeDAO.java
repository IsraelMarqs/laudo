package br.com.frota.DAO;

import br.com.frota.model.Especialidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO extends ConexaoDB{

    private static final String INSERT_ESPECIALIADADE_SQL = "INSERT INTO especialidade (descricao, observacao) VALUES (?, ?);";
    private static final String SELECT_ESPECIALIDADE_BY_ID = "SELECT id, descricao, observacao FROM especialidade WHERE id = ?";
    private static final String SELECT_ALL_ESPECIALIDADE = "SELECT * FROM especialiade;";
    private static final String DELETE_ESPECIALIDADE_SQL = "DELETE FROM especialiade WHERE id = ?;";
    private static final String UPDATE_ESPECIALIDADE_SQL = "UPDATE especialidade SET descricao = ?, observacao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especialidade;";

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

    public Especialidade insert(Especialidade entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESPECIALIADADE_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setString(2, entidade.getObservacao());

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

    public Especialidade findById(Integer id) {
        Especialidade entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESPECIALIDADE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                String observacao = rs.getString("observacao");
                entidade = new Especialidade(id, descricao, observacao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Especialidade> selectAllEspecialidades() {
        List<Especialidade> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESPECIALIDADE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String observacao = rs.getString("observacao");
                entidades.add(new Especialidade(id, descricao, observacao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecialidade(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESPECIALIDADE_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEspecialidade(Especialidade entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESPECIALIDADE_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setString(2, entidade.getObservacao());
            statement.setInt(3, entidade.getId());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}