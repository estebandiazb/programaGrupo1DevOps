package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearSubtipoRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_CREAR_SUBTIPO")
public class CrearSubtipoRepositoryImpl extends SimpleSPGenericDao implements CrearSubtipoRepository {

    @Override
    public void ejecutar(ItemVariable subtipo, long idFamiliaSubtipo) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_NOMBRE", subtipo.getValor())
                    .addValue("IN_ID_FAMILIA_SUBTIPO", idFamiliaSubtipo));
        } catch (SimpleDaoException ex) {
            String mensajeError = "error al crear subtipo.";
            throw new PlataformaBaseException("rollBack crear subtipo ", ex, mensajeError);
        }
    }

}
