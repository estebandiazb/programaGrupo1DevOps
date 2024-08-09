package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizarVariableTipoLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_UPDATE_VARIABLE_TIPO_LIMITE")
public class ActualizarVariableTipoLimiteRepositoryImpl extends SimpleSPGenericDao
        implements ActualizarVariableTipoLimiteRepository {

    @Override
    public void ejecutar(VariableLimite variableLimite) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_VARIABLE_TIPO_LIMITE", variableLimite.getId())
                    .addValue("IN_ID_M_VARIABLE_ATRIBUTO", variableLimite.getIdVariableAtributo())
                    .addValue("IN_TOOLTIP", variableLimite.getTooltip())
                    .addValue("IN_VALOR", variableLimite.getValor()));
        } catch (SimpleDaoException ex) {
            String mensajeError = "error al crear item variable.";
            throw new PlataformaBaseException("rollBack crear item variable", ex, mensajeError);
        }
    }

}
