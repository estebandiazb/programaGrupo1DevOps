package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarMonedaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.GuardarMonedaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.GuardarValorMonedaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerMonedaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerMonedasRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerValorMonedaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.service.MonedaBancoService;
import cl.bancochile.plataformacomercial.lib.controllimites.api.sgt.domains.ApiSgtRequest;
import cl.bancochile.plataformacomercial.lib.controllimites.api.sgt.domains.SgtMoneda;
import cl.bancochile.plataformacomercial.lib.controllimites.api.sgt.services.ApiSgtService;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.BigDecimalUtil;
import cl.bancochile.plataformacomercial.lib.controllimites.monedas.enums.MonedaEnum;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_CODBCO_MONEDA;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_CODIGO_MONEDA;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_DESCRI_MONEDA;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_EMPTY_MONEDAS;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_ID_MONEDA;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_NOMBRE_MONEDA;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_NO_VALOR_DOLAR;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_PERFIL_USER;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_SIMBOL_MONEDA;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_VALOR_MONEDA;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_VALOR_OBSERVADO;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.TallerAssertUtil.assertTrue;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.BigDecimalUtil.safeDivideBigDecimal;

@Service
public class MonedaBancoServiceImpl implements MonedaBancoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonedaBancoServiceImpl.class);

    @Autowired
    private ObtenerMonedasRepository obtenerMonedasRepository;

    @Autowired
    private ApiSgtService apiSgtService;

    @Autowired
    private ObtenerValorMonedaRepository obtenerValorMonedaRepository;

    @Autowired
    private GuardarMonedaRepository guardarMonedaRepository;

    @Autowired
    private EliminarMonedaRepository eliminarMonedaRepository;

    @Autowired
    private ObtenerMonedaRepository obtenerMonedaRepository;

    @Autowired
    private GuardarValorMonedaRepository guardarValorMonedaRepository;

    @Override
    public List<MonedaBanco> obtencionMonedas()
            throws PlataformaBaseException {
        List<MonedaBanco> monedas = obtenerMonedasRepository.ejecutar();
        for (MonedaBanco moneda : monedas) {
            moneda.setValor(obtenerValorMonedaRepository.ejecutar(moneda.getId()));
        }
        return monedas;
    }

    @Override
    public List<MonedaBanco> obtencionMonedasSgt() throws PlataformaBaseException {
        List<SgtMoneda> sgtMonedas = apiSgtService.getTablaMoneda();
        List<MonedaBanco> monedasBco = new ArrayList<>();
        for (SgtMoneda moneda : sgtMonedas) {
            monedasBco.add(new MonedaBanco.Builder()
                    .codigo(moneda.getCodigo())
                    .codigoBanco(Integer.parseInt(moneda.getCodigoBanco()))
                    .descripcion(moneda.getNombre())
                    .nombre(moneda.getNombre())
                    .simbolo(moneda.getSimbolo())
                    .build());
        }
        return monedasBco;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = 30, rollbackFor = PlataformaBaseException.class)
    public List<MonedaBanco> guardarMonedas(List<MonedaBanco> monedas, PerfilUser perfilUser)
            throws PlataformaBaseException {

        assertTrue(MSG_ERROR_EMPTY_MONEDAS, monedas != null && !monedas.isEmpty());
        assertTrue(MSG_ERROR_PERFIL_USER, perfilUser != null);

        LOGGER.info("Actualizando monedas: {}", perfilUser.getUsuario());
        for (MonedaBanco moneda : monedas) {
            assertTrue(MSG_ERROR_CODIGO_MONEDA, !StringUtils.isEmpty(moneda.getCodigo()));
            assertTrue(MSG_ERROR_DESCRI_MONEDA, !StringUtils.isEmpty(moneda.getDescripcion()));
            assertTrue(MSG_ERROR_NOMBRE_MONEDA, !StringUtils.isEmpty(moneda.getNombre()));
            assertTrue(MSG_ERROR_SIMBOL_MONEDA, !StringUtils.isEmpty(moneda.getSimbolo()));
            assertTrue(MSG_ERROR_CODBCO_MONEDA, moneda.getCodigoBanco() > 0);

            moneda.setUsuarioCreacion(perfilUser.getUsuario());
            moneda.setUsuarioModificacion(perfilUser.getUsuario());
            moneda.setEstado(EstadoTipoLimiteEnum.ACTIVO);

            guardarMonedaRepository.ejecutar(moneda);
        }
        return monedas;
    }

    @Override
    public void eliminacionMoneda(long idMoneda, PerfilUser perfilUser)
            throws PlataformaBaseException {

        assertTrue(MSG_ERROR_PERFIL_USER, perfilUser != null);
        assertTrue(MSG_ERROR_ID_MONEDA, idMoneda > 0);

        LOGGER.info("Eliminado moneda: {}, {}", idMoneda, perfilUser.getUsuario());

        eliminarMonedaRepository.ejecutar(idMoneda, perfilUser.getUsuario());
    }

    @Override
    public ValorMonedaBanco guardarValorMoneda(ValorMonedaBanco valorMonedaBanco, PerfilUser perfilUser)
            throws PlataformaBaseException {

        assertTrue(MSG_ERROR_PERFIL_USER, perfilUser != null);
        assertTrue(MSG_ERROR_VALOR_MONEDA, valorMonedaBanco != null);
        assertTrue(MSG_ERROR_ID_MONEDA, valorMonedaBanco.getIdMoneda() > 0);
        assertTrue(MSG_ERROR_VALOR_OBSERVADO, !BigDecimalUtil.isZero(valorMonedaBanco.getValorObservado()));

        MonedaBanco monedaBanco = obtenerMonedaRepository.ejecutar(valorMonedaBanco.getIdMoneda());
        if (!MonedaEnum.UF.getCodigo().equalsIgnoreCase(monedaBanco.getCodigo()) &&
                !MonedaEnum.DOLAR.getCodigo().equalsIgnoreCase(monedaBanco.getCodigo())) {

            ValorMonedaBanco valorDolar = obtenerValorMonedaRepository.ejecutar(MonedaEnum.DOLAR.getCodigo());

            assertTrue(MSG_ERROR_NO_VALOR_DOLAR, !BigDecimalUtil.isZero(valorDolar.getValorObservado()));
            valorMonedaBanco.setParidadReuters(
                    safeDivideBigDecimal(valorMonedaBanco.getValorObservado(), valorDolar.getValorObservado())
            );
            valorMonedaBanco.setParidadBancoCentral(valorMonedaBanco.getParidadReuters());
        }

        valorMonedaBanco.setUsuarioCreacion(perfilUser.getUsuario());
        valorMonedaBanco.setUsuarioModificacion(perfilUser.getUsuario());
        valorMonedaBanco.setOrigenData("M");

        guardarValorMonedaRepository.ejecutar(valorMonedaBanco);

        return valorMonedaBanco;
    }
}
