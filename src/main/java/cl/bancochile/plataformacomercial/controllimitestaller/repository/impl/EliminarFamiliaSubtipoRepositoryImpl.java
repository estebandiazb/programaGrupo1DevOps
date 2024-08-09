package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarFamiliaSubtipoRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_DEL_FAMILIA_SUBTIPO")
public class EliminarFamiliaSubtipoRepositoryImpl extends SimpleSPGenericDao
        implements EliminarFamiliaSubtipoRepository {

    @Override
    public void ejecutar(Long idFamilia)
            throws PlataformaBaseException{
        try{
            ejecutar(sqlParameterSource(idFamilia));
        }catch (SimpleDaoException e){
            String errorMessage = "No se pudo eliminar familia.";
            throw new PlataformaBaseException(errorMessage, e, "310003");
        }
    }

    private static SqlParameterSource sqlParameterSource(Long idFamilia) {
        return new MapSqlParameterSource()
                .addValue("IN_ID_FAMILIA", idFamilia)
                ;
    }

}
