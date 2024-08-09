package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonedaBancoMapper implements RowMapper<MonedaBanco> {
    @Override
    public MonedaBanco mapRow(ResultSet resultSet, int i) throws SQLException {
        return new MonedaBanco.Builder()
                .id(resultSet.getLong("ID"))
                .codigo(resultSet.getString("CODIGO"))
                .codigoBanco(resultSet.getLong("CODIGO_BANCO"))
                .nombre(resultSet.getString("NOMBRE"))
                .descripcion(resultSet.getString("DESCRIPCION"))
                .simbolo(resultSet.getString("SIMBOLO"))
                .fechaCreacion(resultSet.getString("FECHA_CREACION"))
                .fechaModificacion(resultSet.getString("FECHA_MODIFICACION"))
                .usuarioCreacion(resultSet.getString("USUARIO_CREACION"))
                .usuarioModificacion(resultSet.getString("USUARIO_MODIFICACION"))
                .estado(EstadoTipoLimiteEnum.getById(resultSet.getInt("ESTADO")))
                .valor(null)
                .build();
    }
}
