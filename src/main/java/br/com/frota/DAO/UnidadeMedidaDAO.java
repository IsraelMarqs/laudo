package br.com.frota.DAO;

import br.com.frota.model.UnidadeMedida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadeMedidaDAO extends ConexaoDB{

    private static final String INSERT_UNIDADEMEDIDA_SQL = "INSERT INTO unidade_medida (material, observacao) VALUES (?, ?);";
    private static final String SELECT_UNIDADEMEDIDA_BY_ID = "SELECT id, material, observacao FROM unidade_medida WHERE id = ?";
    private static final String SELECT_ALL_UNIDADEMEDIDA = "SELECT * FROM unidade_medida;";
    private static final String DELETE_UNIDADEMEDIDA_SQL = "DELETE FROM unidade_medida WHERE id = ?;";
    private static final String UPDATE_UNIDADEMEDIDA_SQL = "UPDATE unidade_medida SET material = ?, observacao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM unidade_medida;";

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

    public UnidadeMedida insert(UnidadeMedida entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_UNIDADEMEDIDA_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getMaterial());
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

    public UnidadeMedida findById(Integer id) {
        UnidadeMedida entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_UNIDADEMEDIDA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String material = rs.getString("material");
                String observacao = rs.getString("observacao");
                entidade = new UnidadeMedida(id, material, observacao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<UnidadeMedida> selectAllUnidadesMedidas() {
        List<UnidadeMedida> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_UNIDADEMEDIDA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String material = rs.getString("material");
                String observacao = rs.getString("observacao");
                entidades.add(new UnidadeMedida(id, material, observacao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteUnidadeMedida(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_UNIDADEMEDIDA_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUnidadeMedida(UnidadeMedida entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_UNIDADEMEDIDA_SQL)) {
            statement.setString(1, entidade.getMaterial());
            statement.setString(2, entidade.getObservacao());
            statement.setInt(3, entidade.getId());
            boolean bool = statement.executeUpdate() > 0;
            statement.getConnection().close();
            return bool;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
