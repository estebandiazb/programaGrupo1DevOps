package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import com.google.common.base.Strings;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtributoRowMapper implements RowMapper<Atributo> {

    @Override
    public Atributo mapRow(ResultSet resultSet, int i) throws SQLException {
        List<CategoriaSeleccionable> categorias = new ArrayList<>();
        String categoria = resultSet.getString("CATEGORIA");
        if (!Strings.isNullOrEmpty(categoria)){
            categorias.add(new CategoriaSeleccionable.Builder()
                    .categoria(CategoriaAtributoEnum.getByDescripcion(categoria))
                    .seleccionado(Boolean.TRUE)
                    .build());
        }
        return new Atributo.Builder()
                .id(resultSet.getLong("ID_ATRIBUTO"))
                .codigo(resultSet.getString("COD_ATRIBUTO"))
                .nombre(resultSet.getString("NOMBRE_ATRIBUTO"))
                .comentario(resultSet.getString("DESCRIPCION"))
                .categorias(categorias)
                .obligatorio(resultSet.getInt("OBLIGATORIO") == 1)
                .build();
    }
}
