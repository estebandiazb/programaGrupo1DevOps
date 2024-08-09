package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerAtributosFiltroRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.FiltroMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CallSp(nombre = "SP_GET_ATRIBUTOS_FILTRO",
        resultSet = "OUT_CURSOR",
        mapper = FiltroMapper.class
)
public class ObtenerAtributosFiltroRepositoryImpl extends SimpleSPResultSetDao<List<Filtro>>
        implements ObtenerAtributosFiltroRepository {
    @Override
    public List<Filtro> ejecutar() throws PlataformaBaseException {
        return ejecutar(new MapSqlParameterSource());
    }
}
