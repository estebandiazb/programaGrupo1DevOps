package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoConfiguration;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerConfiguracionTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.ItemVariableLimiteRowMapper;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.VariableLimiteRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@CallSp(nombre = "SP_GET_CONFIG_TIPO_LIMITE")
public class ObtenerConfiguracionTipoLimiteRepositoryImpl extends SimpleSPGenericDao
        implements ObtenerConfiguracionTipoLimiteRepository {

    @Override
    public List<VariableLimite> ejecutar(Long idTipoLimite) throws PlataformaBaseException {
        try {
            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_TIPO_LIMITE_VERSION", idTipoLimite)
            );
            return mapCustom(resultSet);
        }catch (SimpleDaoException ex){
            throw new TallerException(MsgErrorEnum.MSG_ERROR_GET_ATRIBUTOS_TL, ex);
        }
    }

    @SuppressWarnings("unchecked")
    private List<VariableLimite> mapCustom(Map<String, Object> resultSet){
        List<VariableLimite> variablesLimite = (List<VariableLimite>) resultSet.get("OUT_VARIABLES");
        List<ItemVariableLimite> itemVariablesLimite = (List<ItemVariableLimite>) resultSet.get("OUT_VARIABLES_ITEM");

        if (variablesLimite != null ){
            for (VariableLimite variable: variablesLimite){
                // Asignacion de items por variable
                variable.setItems(itemVariablesLimite.stream()
                        .filter(itemVariableLimite -> variable.getId() == itemVariableLimite.getIdVariableLimite())
                        .collect(Collectors.toCollection(ArrayList::new)));
            }
        }

        return variablesLimite;
    }

    @Autowired
    @Override
    public void setSimpleDaoConfiguration(
            @Qualifier("defaultSimpleDaoConfiguration") SimpleDaoConfiguration simpleDaoConfiguration) {
        try {
            super.setSimpleDaoConfiguration(simpleDaoConfiguration);
            super.getSimpleJdbcCall().returningResultSet("OUT_VARIABLES"
                    , VariableLimiteRowMapper.class.newInstance());
            super.getSimpleJdbcCall().returningResultSet("OUT_VARIABLES_ITEM"
                    , ItemVariableLimiteRowMapper.class.newInstance());
        } catch (Exception e) { // NOSONAR
            throw new IllegalArgumentException("SimpleDaoConfiguration no valida");
        }
    }
}
