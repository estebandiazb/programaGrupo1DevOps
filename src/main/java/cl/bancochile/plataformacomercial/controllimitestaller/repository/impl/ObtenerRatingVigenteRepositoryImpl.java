package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerRatingVigenteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.AtributoParametroMacMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CallSp(nombre = "SP_GET_PARAMETROS_MAC",
        resultSet = "OUT_PARAMETROS_MAC",
        mapper = AtributoParametroMacMapper.class
)
public class ObtenerRatingVigenteRepositoryImpl extends SimpleSPResultSetDao<List<ParametroMac>>
        implements ObtenerRatingVigenteRepository {
    @Override
    public List<ParametroMac> ejecutar(String parametro) throws PlataformaBaseException {
        try {
            return  ejecutar(new MapSqlParameterSource().addValue("IN_PARAMETRO", parametro));
        }catch (SimpleDaoException ex){
            throw new TallerException(MsgErrorEnum.MSG_ERROR_GET_PARAMETROS_MAC.getMensaje(), ex);
        }
    }
}