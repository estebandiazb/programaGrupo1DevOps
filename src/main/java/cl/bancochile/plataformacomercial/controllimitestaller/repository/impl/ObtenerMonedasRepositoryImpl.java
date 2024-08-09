package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerMonedasRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.MonedaBancoMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CallSp(nombre = "SP_GET_MONEDAS_BCO", resultSet = "OUT_CURSOR", mapper = MonedaBancoMapper.class)
public class ObtenerMonedasRepositoryImpl extends SimpleSPResultSetDao<List<MonedaBanco>>
        implements ObtenerMonedasRepository {

    @Override
    public List<MonedaBanco> ejecutar() {
        return ejecutar(new MapSqlParameterSource());
    }
}
