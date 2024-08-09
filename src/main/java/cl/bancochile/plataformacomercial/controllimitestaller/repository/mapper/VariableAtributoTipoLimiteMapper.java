package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.JSonUtil;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.TipoValorVariableEnum;
import com.google.common.base.Strings;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class VariableAtributoTipoLimiteMapper implements RowMapper<VariableAtributo> {

    private static final String CODIGO_VARIABLE_GRILLA_PROD = "GLS101";

    @Override
    public VariableAtributo mapRow(ResultSet resultSet, int i) throws SQLException {
        String valor = resultSet.getString("VALOR");
        String codigoVariable = resultSet.getString("CODIGO");
        TipoValorVariableEnum tipoValor = TipoValorVariableEnum.getById(resultSet.getInt("TIPO_DATO"));

        if (!Strings.isNullOrEmpty(valor) && TipoValorVariableEnum.BOOLEAN.getId() == tipoValor.getId()){
            return new VariableAtributo.Builder()
                    .id(resultSet.getLong("ID"))
                    .idAtributo(resultSet.getLong("ID_ATRIBUTO"))
                    .codigo(codigoVariable)
                    .nombre(resultSet.getString("NOMBRE"))
                    .tooltip(resultSet.getString("TOOLTIP"))
                    .valor(Integer.parseInt(valor) == 0 ? Boolean.FALSE : Boolean.TRUE)
                    .tipoValor(tipoValor)
                    .items(null)
                    .build();
        }

        return new VariableAtributo.Builder()
                .id(resultSet.getLong("ID"))
                .idAtributo(resultSet.getLong("ID_ATRIBUTO"))
                .codigo(codigoVariable)
                .nombre(resultSet.getString("NOMBRE"))
                .tooltip(resultSet.getString("TOOLTIP"))
                .valor(getValor(valor, codigoVariable))
                .tipoValor(tipoValor)
                .items(null)
                .build();
    }

    private Object getValor(String valor, String codigoVariable) {
        if(valor != null && (valor.startsWith("[") || CODIGO_VARIABLE_GRILLA_PROD.equals(codigoVariable))){
            return Arrays.asList(JSonUtil.convertJsonToObject(valor, ItemVariable[].class));
        } else {
            return valor;
        }

    }
}
