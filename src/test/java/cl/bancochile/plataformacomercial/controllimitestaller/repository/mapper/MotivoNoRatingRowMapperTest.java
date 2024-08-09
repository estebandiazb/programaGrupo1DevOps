package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MotivoNoRatingRowMapperTest {

    @InjectMocks
    private MotivoNoRatingRowMapper mapper;

    @Test
    public void mapRow() throws SQLException {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getLong("ID")).thenReturn(1L);
        when(resultSet.getInt("ORDEN")).thenReturn(1);
        when(resultSet.getString("DESCRIPCION")).thenReturn("Descripcion");
        when(resultSet.getString("FECHA_CREACION")).thenReturn("12/02/2024");
        when(resultSet.getString("FECHA_ACTUALIZACION")).thenReturn("12/02/2024");
        when(resultSet.getString("USUARIO_CREADOR")).thenReturn("usuario");
        Assert.notNull(mapper.mapRow(resultSet, 0));
    }
}
