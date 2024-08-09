package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.repository.SimpleSPResultSetDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.predicates.IdEstadoTipoLimiteEnumGetterPredicate;
import cl.bancochile.plataformacomercial.controllimitestaller.predicates.IdFiltroGetterPredicate;
import cl.bancochile.plataformacomercial.controllimitestaller.predicates.NombreFiltroGetterPredicate;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerTipoLimitesRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.TipoLimiteMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.ListUtils.listToString;

@Repository
@CallSp(nombre = "SP_GET_TIPO_LIMITES_TALLER",
        resultSet = "OUT_CURSOR",
        mapper = TipoLimiteMapper.class
)
public class ObtenerTipoLimitesRepositoryImpl extends SimpleSPResultSetDao<List<TipoLimite>>
        implements ObtenerTipoLimitesRepository {
    @Override
    public List<TipoLimite> ejecutar(ConsultarTipoLimitesRequest request) throws PlataformaBaseException {
        return ejecutar(new MapSqlParameterSource()
                .addValue("IN_PALABRAS", request.getPalabrasClaves())
                .addValue("IN_FAMILIAS", listToString(request.getFamilias(), new IdFiltroGetterPredicate()))
                .addValue("IN_NOMBRES", listToString(request.getNombres(), new NombreFiltroGetterPredicate()))
                .addValue("IN_ESTADOS", listToString(request.getEstados(), new IdEstadoTipoLimiteEnumGetterPredicate()))
                .addValue("IN_ATRIBUTOS", listToString(request.getAtributos(), new IdFiltroGetterPredicate()))
                .addValue("IN_SUBTIPOS", listToString(request.getSubtipos(), new IdFiltroGetterPredicate()))
                .addValue("IN_CODIGO", request.getCodigo())
        );
    }
}
