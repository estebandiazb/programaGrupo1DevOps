package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import com.google.common.base.Strings;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaSeleccionableMapper implements RowMapper<CategoriaSeleccionable> {

    @Override
    public CategoriaSeleccionable mapRow(ResultSet resultSet, int i) throws SQLException {
        return new CategoriaSeleccionable.Builder()
                .idAtributo(resultSet.getLong("M_ATRIBUTO_ID"))
                .categoria(getCategoria(resultSet.getString("DESCRIPCION_CATEGORIA")))
                .seleccionado(resultSet.getInt("SELECCIONADA") == 1)
                .build();
    }

    private CategoriaAtributoEnum getCategoria(String categoria) {
        return Strings.isNullOrEmpty(categoria)? null: CategoriaAtributoEnum.getByDescripcion(categoria);
    }


}
