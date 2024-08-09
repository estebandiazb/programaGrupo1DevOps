package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TipoLimiteVersionRowMapperTest {

    @Test
    public void testRowMapper() throws Exception {
        RowMapper<TipoLimiteVersion> mapper = new TipoLimiteVersionRowMapper();
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("ID")).thenReturn(1L);
        when(rs.getLong("M_TIPO_LIMITE2_ID")).thenReturn(1L);
        when(rs.getString("NOMBRE")).thenReturn("nombre");
        when(rs.getString("DESCRIPCION")).thenReturn("descripcion");
        when(rs.getInt("VERSION")).thenReturn(1);
        when(rs.getString("USUARIO_CREACION")).thenReturn("usuario");
        when(rs.getString("USUARIO_ACTUALIZACION")).thenReturn("usuario");
        when(rs.getString("FECHA_ACTUALIZACION")).thenReturn("01/01/9999");
        when(rs.getString("FECHA_CREACION")).thenReturn("01/01/9999");
        when(rs.getInt("ESTADO")).thenReturn(1);

        Assert.notNull(mapper.mapRow(rs, 1));
    }
}
