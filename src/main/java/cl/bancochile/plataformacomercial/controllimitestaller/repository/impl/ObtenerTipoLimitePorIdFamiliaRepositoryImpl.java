package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerTipoLimitePorIdFamiliaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.TipoLimiteVersionRowMapper;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CallSp(nombre = "SP_GET_TIPO_LIMITES", resultSet = "OUT_TIPO_LIMITE"
        , tipoSalida = TipoLimiteVersion.class, mapper = TipoLimiteVersionRowMapper.class)
public class ObtenerTipoLimitePorIdFamiliaRepositoryImpl extends SimpleSPResultSetDao<List<TipoLimiteVersion>>
        implements ObtenerTipoLimitePorIdFamiliaRepository {

    @Override
    public List<TipoLimiteVersion> ejecutar(Long idFamilia) throws PlataformaBaseException {
        try {
            return ejecutar(sqlParameterSource(idFamilia));
        }catch (SimpleDaoException ex) {
            String errorMessage = "No se pudo obtener los tipos de limite.";
            throw new PlataformaBaseException(errorMessage, ex, "310002");
        }
    }

    private static SqlParameterSource sqlParameterSource(Long idFamilia) {
        return new MapSqlParameterSource().addValue("IN_FAMILIA_ID", idFamilia);
    }
}