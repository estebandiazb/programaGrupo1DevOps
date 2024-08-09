package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ReasignarLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ModificarFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerTipoLimitePorIdFamiliaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ReasignarFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.service.FamiliaLimiteService;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.repository.ObtenerFamiliaLimiteRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_ID_FAMLIM;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_NOMBRE_FAMLIM;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_NO_FAMLIM;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_PERFIL_USER;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.TallerAssertUtil.assertTrue;
import static cl.bancochile.plataformacomercial.lib.controllimites.taller.util.TallerMantenedoresUtil.ordenarFamiliasLimites;

@Service
public class FamiliaLimiteServiceImpl implements FamiliaLimiteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FamiliaLimiteServiceImpl.class);

    @Autowired
    private CrearFamiliaLimiteRepository crearFamiliaLimiteRepository;
    @Autowired
    private ModificarFamiliaLimiteRepository modificarFamiliaLimiteRepository;
    @Autowired
    private ObtenerFamiliaLimiteRepository obtenerFamiliasLimitesRepository;
    @Autowired
    private ObtenerTipoLimitePorIdFamiliaRepository obtenerTipoLimitePorIdFamiliaRepository;
    @Autowired
    private EliminarFamiliaLimiteRepository eliminarFamiliaLimiteRepository;
    @Autowired
    private ReasignarFamiliaLimiteRepository reasignarFamiliaLimiteRepository;

    @Override
    public FamiliaLimite crear(FamiliaLimite familiaLimite, PerfilUser perfilUser) throws PlataformaBaseException {
        LOGGER.info("Creando familia de limite...");

        assertTrue(MSG_ERROR_PERFIL_USER, perfilUser != null);
        assertTrue(MSG_ERROR_NO_FAMLIM, familiaLimite != null);
        assertTrue(MSG_ERROR_NOMBRE_FAMLIM, !StringUtils.isEmpty(familiaLimite.getNombre()));

        familiaLimite.setUsuarioCreacion(perfilUser.getUsuario());

        crearFamiliaLimiteRepository.ejecutar(familiaLimite);

        return familiaLimite;
    }

    public FamiliaLimite guardar(FamiliaLimite familiaLimite, PerfilUser perfilUser) throws PlataformaBaseException {
        LOGGER.info("Modificando familia de limite...");

        assertTrue(MSG_ERROR_PERFIL_USER, perfilUser != null);
        assertTrue(MSG_ERROR_NO_FAMLIM, familiaLimite != null);
        assertTrue(MSG_ERROR_NOMBRE_FAMLIM, !StringUtils.isEmpty(familiaLimite.getNombre()));

        familiaLimite.setUsuarioModificacion(perfilUser.getUsuario());

        modificarFamiliaLimiteRepository.ejecutar(familiaLimite);

        return familiaLimite;
    }

    @Override
    public void eliminar(Long idFamilia, PerfilUser perfilUser) throws PlataformaBaseException {
        LOGGER.info("Modificando familia de limite...");

        assertTrue(MSG_ERROR_PERFIL_USER, perfilUser != null);
        assertTrue(MSG_ERROR_ID_FAMLIM, idFamilia != null && idFamilia > 0);

        eliminarFamiliaLimiteRepository.ejecutar(idFamilia, perfilUser.getUsuario());
    }

    @Override
    public void reasignar(ReasignarLimiteRequest reasignarLimite, PerfilUser perfilUser)
            throws PlataformaBaseException {
        LOGGER.info("Cambiando tipo de limite de familia...");
        reasignarFamiliaLimiteRepository.ejecutar(reasignarLimite);
    }

    @Override
    public List<FamiliaLimite> obtenerFamiliaLimite(Long idFamilia)
            throws PlataformaBaseException {
        return ordenarFamiliasLimites(obtenerFamiliasLimitesRepository.ejecutar(idFamilia));
    }

    @Override
    public FamiliaLimite obtenerFamiliaLimitePorId(Long idFamilia)
            throws PlataformaBaseException {

        FamiliaLimite familia = new FamiliaLimite();

        List<FamiliaLimite> familiaLimites = obtenerFamiliasLimitesRepository.ejecutar(idFamilia);
        if (!familiaLimites.isEmpty()){
            familia = familiaLimites.get(0);
        }

        List<TipoLimiteVersion> tipoLimites = obtenerTipoLimitePorIdFamiliaRepository.ejecutar(idFamilia);

        familia.setTipoLimite(tipoLimites);

        return familia;
    }

}
