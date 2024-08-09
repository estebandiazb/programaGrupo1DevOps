package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerMotivosNoRatingRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.MotivoNoRatingRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CallSp(nombre = "SP_GET_MOTIVOS_NO_RATING", resultSet = "OUT_MOTIVOS", mapper = MotivoNoRatingRowMapper.class)
public class ObtenerMotivosNoRatingRepositoryImpl extends SimpleSPResultSetDao<List<MotivoNoRating>>
        implements ObtenerMotivosNoRatingRepository {

    @Override
    public List<MotivoNoRating> ejecutar() {
        return ejecutar(new MapSqlParameterSource());
    }
}
