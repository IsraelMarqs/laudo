package br.com.frota.DAO;

import br.com.frota.model.MaterialExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialExameDAO extends ConexaoDB{

    private static final String INSERT_MATERIALEXAME_SQL = "INSERT INTO material_exame (material, observacao) VALUES (?, ?);";
    private static final String SELECT_MATERIALEXAME_BY_ID = "SELECT id, material, observacao FROM material_exame WHERE id = ?";
    private static final String SELECT_ALL_MATERIALEXAME = "SELECT * FROM material_exame;";
    private static final String DELETE_MATERIALEXAME_SQL = "DELETE FROM material_exame WHERE id = ?;";
    private static final String UPDATE_MATERIALEXAME_SQL = "UPDATE material_exame SET material = ?, observacao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM material_exame;";

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

    public MaterialExame insert(MaterialExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_MATERIALEXAME_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {

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

    public MaterialExame findById(Integer id) {
        MaterialExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MATERIALEXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String material = rs.getString("material");
                String observacao = rs.getString("observacao");
                entidade = new MaterialExame(id, material, observacao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<MaterialExame> selectAllMateriaisExames() {
        List<MaterialExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MATERIALEXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String material = rs.getString("material");
                String observacao = rs.getString("observacao");
                entidades.add(new MaterialExame(id, material, observacao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMaterialExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_MATERIALEXAME_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMaterialExame(MaterialExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_MATERIALEXAME_SQL)) {
            statement.setString(1, entidade.getMaterial());
            statement.setString(2, entidade.getObservacao());
            statement.setInt(3, entidade.getId());
            return statement.executeUpdate() > 0;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
