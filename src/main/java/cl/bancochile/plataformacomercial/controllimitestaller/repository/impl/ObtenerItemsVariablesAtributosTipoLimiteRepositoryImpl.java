package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerItemsVariablesAtributosTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.ItemVariableRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CallSp(nombre = "SP_GET_ITEMS_VARIABLES_TL",
        resultSet = "OUT_ITEMS_VARIABLES",
        mapper = ItemVariableRowMapper.class
)
public class ObtenerItemsVariablesAtributosTipoLimiteRepositoryImpl extends SimpleSPResultSetDao<List<ItemVariable>>
        implements ObtenerItemsVariablesAtributosTipoLimiteRepository {
    @Override
    public List<ItemVariable> ejecutar(Long idTipoLimite) throws PlataformaBaseException {
        try {
            return ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_TIPO_LIMITE", idTipoLimite)
            );
        }catch (SimpleDaoException e){
            throw new TallerException(MsgErrorEnum.MSG_ERROR_GET_ITEMS_VARIABLES_TL, e);
        }
    }
}
