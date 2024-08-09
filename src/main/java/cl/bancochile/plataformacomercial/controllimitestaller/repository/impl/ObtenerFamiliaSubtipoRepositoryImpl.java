package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.VariableRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CallSp(nombre = "SP_GET_FAMILIA_SUBTIPO", resultSet = "OUT_FAMILIAS"
        , tipoSalida = Variable.class, mapper = VariableRowMapper.class)
public class ObtenerFamiliaSubtipoRepositoryImpl extends SimpleSPResultSetDao<List<Variable>>
        implements ObtenerFamiliaSubtipoRepository {

    @Override
    public List<Variable> ejecutar() throws PlataformaBaseException {
        try {
            return ejecutar(new MapSqlParameterSource());
        }catch (SimpleDaoException ex) {
            String errorMessage = "No se pudo obtener los subtipos.";
            throw new PlataformaBaseException(errorMessage, ex, "310001");
        }
    }
}
