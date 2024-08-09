package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerItemVariablePorIdRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.ItemVariableFamiliaRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CallSp(nombre = "SP_GET_ITEM_VARIABLE", resultSet = "OUT_ITEM"
        , tipoSalida = ItemVariable.class, mapper = ItemVariableFamiliaRowMapper.class)
public class ObtenerItemVariablePorIdRepositoryImpl extends SimpleSPResultSetDao<List<ItemVariable>>
        implements ObtenerItemVariablePorIdRepository {

    @Override
    public List<ItemVariable> ejecutar(Long idVariable) throws PlataformaBaseException {
        try {
            return ejecutar(sqlParameterSource(idVariable));
        }catch (SimpleDaoException ex) {
            String errorMessage = "No se pudo obtener los subtipos.";
            throw new PlataformaBaseException(errorMessage, ex, "310002");
        }
    }

    private static SqlParameterSource sqlParameterSource(Long idVariable) {
        return new MapSqlParameterSource().addValue("IN_VARIABLE2_ID", idVariable);
    }
}
