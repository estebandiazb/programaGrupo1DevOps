package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EditarCategoriaTipoLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_UPD_CATEGORIA_TIPO_LIMITE")
public class EditarCategoriaTipoLimiteRepositoryImpl extends SimpleSPGenericDao
        implements EditarCategoriaTipoLimiteRepository {

    @Override
    public void ejecutar(Long idTipoLimite, Long idAtributo, CategoriaSeleccionable categoria, String comentario)
            throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_TIPO_LIMITE_VERSION", idTipoLimite)
                    .addValue("IN_ID_ATRIBUTO", idAtributo)
                    .addValue("IN_ID_CATEGORIA", categoria == null ? null : categoria.getCategoria().getId())
                    .addValue("IN_COMENTARIO", comentario)
            );
        }catch (SimpleDaoException ex){
            throw new TallerException(MsgErrorEnum.MSG_ERROR_GET_ATRIBUTOS_TL, ex);
        }
    }
}
