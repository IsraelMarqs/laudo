package br.com.frota.DAO;

import br.com.frota.model.ValorReferenciaComposicaoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ValorReferenciaComposicaoExameDAO extends ConexaoDB{

    private static final String INSERT_VALORREFERENCIACOMPOSICAOEXAME_SQL = "INSERT INTO valor_referencia_composicao_exame (valor_Minimo, valor_Maximo, limitador_Minimo, limitador_Maximo, unidade_Medida_Id) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_VALORREFERENCIACOMPOSICAOEXAME_BY_ID = "SELECT id, valor_Minimo, valor_Maximo, limitador_Minimo, limitador_Maximo, unidade_Medida_Id FROM valor_referencia_composicao_exame WHERE id = ?";
    private static final String SELECT_ALL_VALORREFERENCIACOMPOSICAOEXAME = "SELECT * FROM valor_referencia_composicao_exame;";
    private static final String DELETE_VALORREFERENCIACOMPOSICAOEXAME_SQL = "DELETE FROM valor_referencia_composicao_exame WHERE id = ?;";
    private static final String UPDATE_VALORREFERENCIACOMPOSICAOEXAME_SQL = "UPDATE valor_referencia_composicao_exame SET valor_Minimo = ?, valor_Maximo = ?, limitador_Minimo = ?, limitador_Maximo = ?, unidade_Medida_Id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM valor_referencia_composicao_exame;";

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

    public ValorReferenciaComposicaoExame insert(ValorReferenciaComposicaoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_VALORREFERENCIACOMPOSICAOEXAME_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getValorMinimo());
            preparedStatement.setString(2, entidade.getValorMaximo());
            preparedStatement.setString(3, entidade.getLimitadorMinimo());
            preparedStatement.setString(4, entidade.getLimitadorMaximo());
            preparedStatement.setInt(5, entidade.getUnidadeMedidaId());

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

    public ValorReferenciaComposicaoExame findById(Integer id) {
        ValorReferenciaComposicaoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_VALORREFERENCIACOMPOSICAOEXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String valorMinimo = rs.getString("valor_minimo");
                String valorMaximo = rs.getString("valor_maximo");
                String limitadorMinimo = rs.getString("limitador_minimo");
                String limitadorMaximo = rs.getString("limitador_maximo");
                Integer unidadeMedidaId = rs.getInt("unidade_medida_id");
                entidade = new ValorReferenciaComposicaoExame(id, valorMinimo, valorMaximo, limitadorMinimo, limitadorMaximo, unidadeMedidaId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ValorReferenciaComposicaoExame> selectAllValoresReferenciasComposicoesExame() {
        List<ValorReferenciaComposicaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_VALORREFERENCIACOMPOSICAOEXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String valorMinimo = rs.getString("valor_minimo");
                String valorMaximo = rs.getString("valor_maximo");
                String limitadorMinimo = rs.getString("limitador_minimo");
                String limitadorMaximo = rs.getString("limitador_maximo");
                Integer unidadeMedidaId = rs.getInt("unidade_medida_id");
                entidades.add(new ValorReferenciaComposicaoExame(id, valorMinimo, valorMaximo, limitadorMinimo, limitadorMaximo, unidadeMedidaId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteValorReferenciaComposicaoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_VALORREFERENCIACOMPOSICAOEXAME_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateValorReferenciaComposicaoExame(ValorReferenciaComposicaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_VALORREFERENCIACOMPOSICAOEXAME_SQL)) {
            statement.setString(1, entidade.getValorMinimo());
            statement.setString(2, entidade.getValorMaximo());
            statement.setString(3, entidade.getLimitadorMinimo());
            statement.setString(4, entidade.getLimitadorMaximo());
            statement.setInt(5, entidade.getUnidadeMedidaId());
            statement.setInt(6, entidade.getId());
            boolean bool = statement.executeUpdate() > 0;
            statement.getConnection().close();
            return bool;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
