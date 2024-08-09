package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarAtributoTipoLimiteVersionRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;

@Repository
@CallSp(nombre = "SP_INS_ATRIBUTO_TL_VERSION")
public class AgregarAtributoTipoLimiteVersionRepositoryImpl extends SimpleSPGenericDao
        implements AgregarAtributoTipoLimiteVersionRepository {
    @Override
    public long ejecutar(Long idTipoLimiteVersion, Atributo atributo) throws PlataformaBaseException {
        try {

            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_ATRIBUTO", atributo.getId())
                    .addValue("IN_ID_TIPO_LIMITE_VERSION", idTipoLimiteVersion)
                    .addValue("IN_ID_CATEGORIA", getIdCategoriaSeleccionada(atributo.getCategorias()))
                    .addValue("IN_COMENTARIO", atributo.getComentario())
            );

            return mapNumberToLong(resultSet, "OUT_ID_ATRIBUTO_TIPO_LIMITE");

        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_CREAR_TIPO_LIMITE_VERSION, ex);
        }
    }

    private Integer getIdCategoriaSeleccionada(List<CategoriaSeleccionable> categorias) {
        CategoriaSeleccionable categoria = (CategoriaSeleccionable) CollectionUtils.find(categorias, new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                CategoriaSeleccionable categoriaSeleccionable = (CategoriaSeleccionable) object;
                return categoriaSeleccionable.isSeleccionado();
            }
        });
        return categoria == null? null: categoria.getCategoria().getId();
    }
}
