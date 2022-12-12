package br.com.frota.DAO;

import br.com.frota.model.ComposicaoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComposicaoExameDAO extends ConexaoDB {

    private static final String INSERT_COMPOSICAOEXAME_SQL = "INSERT INTO composicao_exame (descricao, unidade_medida_id) VALUES (?, ?);";
    private static final String SELECT_COMPOSICAOEXAME_BY_ID = "SELECT id, descricao, unidade_medida_id FROM composicao_exame WHERE id = ?";
    private static final String SELECT_ALL_COMPOSICAOEXAME = "SELECT * FROM composicao_exame;";
    private static final String DELETE_COMPOSICAOEXAME_SQL = "DELETE FROM composicao_exame WHERE id = ?;";
    private static final String UPDATE_COMPOSICAOEXAME_SQL = "UPDATE composicao_exame SET descricao = ?, unidade_medida_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM composicao_exame;";

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

    public ComposicaoExame insert(ComposicaoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_COMPOSICAOEXAME_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getUnidadeMedidaId());

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

    public ComposicaoExame findById(Integer id) {
        ComposicaoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_COMPOSICAOEXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer unidadeMedidaId = rs.getInt("unidade_medida_id");
                entidade = new ComposicaoExame(id, descricao, unidadeMedidaId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ComposicaoExame> selectAllComposicoesExames() {
        List<ComposicaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_COMPOSICAOEXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Integer unidadeMedidaId = rs.getInt("unidade_medida_id");
                entidades.add(new ComposicaoExame(id, descricao, unidadeMedidaId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteComposicaoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_COMPOSICAOEXAME_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateComposicaoExame(ComposicaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_COMPOSICAOEXAME_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getUnidadeMedidaId());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
