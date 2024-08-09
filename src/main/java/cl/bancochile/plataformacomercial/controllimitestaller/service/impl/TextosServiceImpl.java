package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;


import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.BitacoraMotivoNoRatingObject;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.BitacoraMotivoNoRatingResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.BitacoraMotivoNoRatingEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizarMotivoNoRatingRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarMotivoNoRatingRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarMotivoNoRatingRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerMotivosNoRatingRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.service.TextosService;
import cl.bancochile.plataformacomercial.lib.controllimites.common.domain.Bitacora;
import cl.bancochile.plataformacomercial.lib.controllimites.common.repository.CrearRegistroBitacoraCommonRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.repository.ObtenerRegistroBitacoraCommonRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.JSonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TextosServiceImpl implements TextosService {

    @Autowired
    private ObtenerMotivosNoRatingRepository obtenerMotivosNoRatingRepository;
    @Autowired
    private EliminarMotivoNoRatingRepository eliminarMotivoNoRatingRepository;
    @Autowired
    private AgregarMotivoNoRatingRepository agregarMotivoNoRatingRepository;
    @Autowired
    private ActualizarMotivoNoRatingRepository actualizarMotivoNoRatingRepository;
    @Autowired
    private CrearRegistroBitacoraCommonRepository crearRegistroBitacoraCommonRepository;
    @Autowired
    private ObtenerRegistroBitacoraCommonRepository obtenerRegistroBitacoraCommonRepository;

    @Override
    public List<MotivoNoRating> obtenerMotivosNoRating() throws PlataformaBaseException {
        return obtenerMotivosNoRatingRepository.ejecutar();
    }

    @Override
    public void agregarMotivosNoRating(MotivoNoRating motivoNoRating, PerfilUser usuario)
            throws PlataformaBaseException {
        agregarMotivoNoRatingRepository.ejecutar(motivoNoRating, usuario);
    }

    @Override
    public void eliminar(Long idMotivoNoRating) throws PlataformaBaseException {
        eliminarMotivoNoRatingRepository.ejecutar(idMotivoNoRating);
    }

    @Override
    public void actualizarOrden(List<MotivoNoRating> motivosNoRating) throws PlataformaBaseException {
        for (MotivoNoRating motivoNoRating : motivosNoRating) {
            actualizarMotivoNoRatingRepository.ejecutar(motivoNoRating);
        }
    }
    @Override
    public void actualizarMotivo(MotivoNoRating motivoNoRating, PerfilUser usuario) throws PlataformaBaseException {
        long idMotivoNoRating = actualizarMotivoNoRatingRepository.ejecutar(
                motivoNoRating,
                usuario.getNombre(),
                usuario.getUsuario()
        );

        // Registro en bitacora
        crearRegistroBitacoraCommonRepository.crearRegistroBitacora(new Bitacora.Builder()
                .idKey(idMotivoNoRating)
                .accion(BitacoraMotivoNoRatingEnum.EDITAR.getAccion())
                .funcionalidad(BitacoraMotivoNoRatingEnum.EDITAR.getFuncionalidad())
                .usuario(usuario.getUsuario())
                .nombreUsuario(usuario.getNombre())
                .jsonData(JSonUtil.convertObjectToJson(new BitacoraMotivoNoRatingObject.Builder()
                        .orden(motivoNoRating.getOrden())
                        .descripcion(motivoNoRating.getDescripcion())
                        .build()))
                .build());
    }

    @Override
    public List<Bitacora> obtenerMotivoNoRatingBitacora(Long idMotivoNoRating) throws PlataformaBaseException {
        List<Bitacora> motivosNoRating = obtenerRegistroBitacoraCommonRepository
                .obtenerRegistroBitacora(new Bitacora.Builder()
                        .idKey(idMotivoNoRating)
                        .funcionalidad(BitacoraMotivoNoRatingEnum.EDITAR.getFuncionalidad())
                        .build());

        // Asignacion tipo dato
        return motivosNoRating.stream().map(motivo -> {
                 BitacoraMotivoNoRatingResponse bitacora = new BitacoraMotivoNoRatingResponse();
                 bitacora.setFuncionalidad(motivo.getFuncionalidad());
                 bitacora.setUsuario(motivo.getUsuario());
                 bitacora.setFecha(motivo.getFecha());
                 bitacora.setAccion(motivo.getAccion());
                 bitacora.setNombreUsuario(motivo.getNombreUsuario());
                 // Asignacion json a object data
                 if (motivo.getJsonData() != null) {
                     bitacora.setData(
                             JSonUtil.convertJsonToObject(motivo.getJsonData(), BitacoraMotivoNoRatingObject.class));
                 }
                 return bitacora;
            }).collect(Collectors.toList());
    }
}
