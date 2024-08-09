package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.ParametrosMacEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaRatingVigenteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerRatingVigenteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.service.ParametrosMacService;
import cl.bancochile.plataformacomercial.lib.controllimites.common.domain.Bitacora;
import cl.bancochile.plataformacomercial.lib.controllimites.common.repository.CrearRegistroBitacoraCommonRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.JSonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametrosMacServiceImpl implements ParametrosMacService {

    @Autowired
    private ObtenerRatingVigenteRepository obtenerRatingVigenteRepository;
    @Autowired
    private ActualizaRatingVigenteRepository actualizaRatingVigenteRepository;
    @Autowired
    private CrearRegistroBitacoraCommonRepository crearRegistroBitacoraCommonRepository;

    @Override
    public ParametroMac obtenerParametrosMac()
            throws PlataformaBaseException {

        return  new ParametroMac.Builder()
                .id(ParametrosMacEnum.DIAS_RATING.getId())
                .parametro(ParametrosMacEnum.DIAS_RATING.getParametro())
                .descripcion(ParametrosMacEnum.DIAS_RATING.getDescripcion())
                .build();
    }

    @Override
    public List<ParametroMac> obtenerRatingVigente(String parametro)
            throws PlataformaBaseException {
        return obtenerRatingVigenteRepository.ejecutar(parametro);
    }

    @Override
    public void actualizaRatingVigente(ParametroMac parametroMac, PerfilUser perfilUser)
            throws PlataformaBaseException {

        actualizaRatingVigenteRepository.ejecutar(parametroMac);

        // Registro en bitacora
        crearRegistroBitacoraCommonRepository.crearRegistroBitacora(new Bitacora.Builder()
                .idKey(ParametrosMacEnum.DIAS_RATING.getId())
                .accion(ParametrosMacEnum.DIAS_RATING.getAccion())
                .funcionalidad(ParametrosMacEnum.DIAS_RATING.getFuncionalidad())
                .usuario(perfilUser.getUsuario())
                .nombreUsuario(perfilUser.getNombre())
                .jsonData(JSonUtil.convertObjectToJson(new ParametroMac.Builder()
                        .valor(parametroMac.getValor())
                        .build()
                        ))
                .build());
    }

}
