package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerCategoriasAtributosTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.CategoriaSeleccionableMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CallSp(nombre = "SP_GET_CATEGORIAS_ATRIBUTOS_TL",
        resultSet = "OUT_CATEGORIAS",
        mapper = CategoriaSeleccionableMapper.class
)
public class ObtenerCategoriasAtributosTipoLimiteRepositoryImpl
        extends SimpleSPResultSetDao<List<CategoriaSeleccionable>>
        implements ObtenerCategoriasAtributosTipoLimiteRepository {
    @Override
    public List<CategoriaSeleccionable> ejecutar(Long idTipoLimite) throws PlataformaBaseException {
        try {
            return ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_TIPO_LIMITE", idTipoLimite)
            );
        }catch (SimpleDaoException ex){
            throw new TallerException(MsgErrorEnum.MSG_ERROR_GET_CATEGORIAS_ATRIBUTOS_TL, ex);
        }
    }
}
