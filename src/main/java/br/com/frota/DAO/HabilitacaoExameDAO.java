package br.com.frota.DAO;

import br.com.frota.model.HabilitacaoExame;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilitacaoExameDAO extends ConexaoDB {

    private static final String INSERT_HABILITACAOEXAME_SQL = "INSERT INTO habilitacao_exame (observacao, custo, laboratorio_id, tipo_exame_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_HABILITACAOEXAME_BY_ID = "SELECT id, observacao, custo, laboratorio_id, tipo_exame_id FROM habilitacao_exame WHERE id = ?";
    private static final String SELECT_ALL_HABILITACAOEXAME = "SELECT * FROM habilitacao_exame;";
    private static final String DELETE_HABILITACAOEXAME_SQL = "DELETE FROM habilitacao_exame WHERE id = ?;";
    private static final String UPDATE_HABILITACAOEXAME_SQL = "UPDATE habilitacao_exame SET observacao = ?, custo = ?, laboratorio_id = ?, tipo_exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM habilitacao_exame;";

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

    public HabilitacaoExame insert(HabilitacaoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_HABILITACAOEXAME_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setInt(2, entidade.getCusto());
            preparedStatement.setInt(3, entidade.getLaboratorioId());
            preparedStatement.setInt(4, entidade.getTipoExameId());

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

    public HabilitacaoExame findById(Integer id) {
        HabilitacaoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_HABILITACAOEXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Integer custo = rs.getInt("custo");
                Integer laboratorioId = rs.getInt("laboratorio_id");
                Integer tipoExameId = rs.getInt("tipo_exame_id");
                entidade = new HabilitacaoExame(id, observacao, custo, laboratorioId, tipoExameId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<HabilitacaoExame> selectAllHabilitacoesExames() {
        List<HabilitacaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_HABILITACAOEXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Integer custo = rs.getInt("custo");
                Integer laboratorioId = rs.getInt("laboratorio_id");
                Integer tipoExameId = rs.getInt("tipo_exame_id");
                entidades.add(new HabilitacaoExame(id, observacao, custo, laboratorioId, tipoExameId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteHabilitacaoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_HABILITACAOEXAME_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateHabilitacaoExame(HabilitacaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_HABILITACAOEXAME_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setInt(2, entidade.getCusto());
            statement.setInt(3, entidade.getLaboratorioId());
            statement.setInt(4, entidade.getTipoExameId());
            statement.setInt(5, entidade.getId());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
