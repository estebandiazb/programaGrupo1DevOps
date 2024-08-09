package cl.bancochile.plataformacomercial.controllimitestaller.service;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarFiltrosTipoLimitesResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CrearTipoLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;

import java.util.List;

public interface TipoLimiteService {

    ConsultarFiltrosTipoLimitesResponse consultarFiltroTipoLimites(
    ) throws PlataformaBaseException;

    ConsultarTipoLimitesResponse consultarTipoLimites(
            ConsultarTipoLimitesRequest request
    ) throws PlataformaBaseException;

    TipoLimiteFull obtenerConfiguracionNuevoTipoLimite(CrearTipoLimiteRequest request)
            throws PlataformaBaseException;

    TipoLimiteFull obtenerConfiguracionVersionTipoLimite(long idVersionTipoLimite)
            throws PlataformaBaseException;

    List<Atributo> obtenerAtributosTipoLimite(Long idTipoLimiteVersion)
            throws PlataformaBaseException;

    Long guardarConfiguracion(TipoLimiteFull request, String usuario)
            throws PlataformaBaseException;

    TipoLimiteVersion actualizaEstadoTipoLimite(TipoLimiteVersion tipoLimiteVersion)
            throws PlataformaBaseException;
    Long copiaTipoLimite(TipoLimiteFull request, String usuario)
            throws PlataformaBaseException;
    void eliminarTipoLimite(Long idTipoLimite)
        throws PlataformaBaseException;
}
