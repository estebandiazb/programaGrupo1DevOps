package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.JSonUtil;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TramoCajaDerivados;
import com.google.common.base.Strings;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemVariableRowMapper implements RowMapper<ItemVariable> {

    private static final String VARIABLE_TRAMOS = "CTR127";

    @Override
    public ItemVariable mapRow(ResultSet resultSet, int i) throws SQLException {
        boolean itemGuardado = resultSet.getInt("ASIGNADO") == 1;
        return new ItemVariable.Builder()
                .id(resultSet.getLong("ID"))
                .valor(getValorVariable(resultSet, itemGuardado))
                .idVariable(resultSet.getLong("ID_VARIABLE"))
                .seleccionado(resultSet.getInt("SELECCIONADO") == 1)
                .asignado(itemGuardado)
                .build();
    }

    private Object getValorVariable(ResultSet resultSet, boolean itemGuardado) throws SQLException {
        String codigoVariable = resultSet.getString("COD_VARIABLE");
        String valor = resultSet.getString("VALOR");
        if(!Strings.isNullOrEmpty(valor) && VARIABLE_TRAMOS.equals(codigoVariable)) {
            if (itemGuardado){
                valor = resultSet.getString("VALOR_GUARDADO");
            }
            return JSonUtil.convertJsonToObject(valor, TramoCajaDerivados.class);
        } else {
            return valor;
        }
    }
}
