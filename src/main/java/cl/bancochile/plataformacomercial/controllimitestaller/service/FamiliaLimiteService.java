package cl.bancochile.plataformacomercial.controllimitestaller.service;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ReasignarLimiteRequest;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;

import java.util.List;

public interface FamiliaLimiteService {

    FamiliaLimite crear(FamiliaLimite familiaLimite, PerfilUser perfilUser)
            throws PlataformaBaseException;

    List<FamiliaLimite> obtenerFamiliaLimite(Long idFamilia) throws PlataformaBaseException;

    FamiliaLimite obtenerFamiliaLimitePorId(Long idFamilia) throws PlataformaBaseException;

    FamiliaLimite guardar(FamiliaLimite familiaLimite, PerfilUser perfilUser)
            throws PlataformaBaseException;

    void eliminar(Long idFamilia, PerfilUser perfilUser)
            throws PlataformaBaseException;

    void reasignar(ReasignarLimiteRequest reasignarLimite, PerfilUser perfilUser)
            throws PlataformaBaseException;
}
