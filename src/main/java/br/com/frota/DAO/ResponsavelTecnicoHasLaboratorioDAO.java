package br.com.frota.DAO;

import br.com.frota.model.ResponsavelTecnicoHasLaboratorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsavelTecnicoHasLaboratorioDAO extends ConexaoDB{

    private static final String INSERT_RESPONSAVELTECNICOHASLABORATORIO_SQL = "INSERT INTO responsavel_tecnico_has_laboratorio (responsavel_tecnico_id, laboratorio_id) VALUES (?, ?);";
    private static final String SELECT_RESPONSAVELTECNICOHASLABORATORIO_BY_ID = "SELECT id, responsavel_tecnico_id, laboratorio_id FROM responsavel_tecnico_has_laboratorio WHERE id = ?";
    private static final String SELECT_ALL_RESPONSAVELTECNICOHASLABORATORIO = "SELECT * FROM responsavel_tecnico_has_laboratorio;";
    private static final String DELETE_RESPONSAVELTECNICOHASLABORATORIO_SQL = "DELETE FROM responsavel_tecnico_has_laboratorio WHERE id = ?;";
    private static final String UPDATE_RESPONSAVELTECNICOHASLABORATORIO_SQL = "UPDATE responsavel_tecnico_has_laboratorio SET responsavel_tecnico_id = ?, laboratorio_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM responsavel_tecnico_has_laboratorio;";

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

    public ResponsavelTecnicoHasLaboratorio insert(ResponsavelTecnicoHasLaboratorio entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESPONSAVELTECNICOHASLABORATORIO_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, entidade.getResponsavelTecnicoId());
            preparedStatement.setInt(2, entidade.getLaboratorioId());

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

    public ResponsavelTecnicoHasLaboratorio findById(Integer id) {
        ResponsavelTecnicoHasLaboratorio entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESPONSAVELTECNICOHASLABORATORIO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer responsavelTecnicoId = rs.getInt("responsavel_tecnico_id");
                Integer laboratorioId = rs.getInt("laboratorioId");
                entidade = new ResponsavelTecnicoHasLaboratorio(id, responsavelTecnicoId, laboratorioId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ResponsavelTecnicoHasLaboratorio> selectAllResponsaveisTecnicosHasLaboratorios() {
        List<ResponsavelTecnicoHasLaboratorio> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESPONSAVELTECNICOHASLABORATORIO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer responsavelTecnicoId = rs.getInt("responsavel_tecnico_id");
                Integer laboratorioId = rs.getInt("laboratorioId");
                entidades.add(new ResponsavelTecnicoHasLaboratorio(id, responsavelTecnicoId, laboratorioId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteResponsavelTecnicoHasLaboratorio(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RESPONSAVELTECNICOHASLABORATORIO_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateResponsaveltecnicohaslaboratorio(ResponsavelTecnicoHasLaboratorio entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RESPONSAVELTECNICOHASLABORATORIO_SQL)) {
            statement.setInt(1, entidade.getResponsavelTecnicoId());
            statement.setInt(2, entidade.getLaboratorioId());
            statement.setInt(3, entidade.getId());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
