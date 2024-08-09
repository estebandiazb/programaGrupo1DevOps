package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValidacionResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.PerfilUserFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.ValidacionFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.service.ValidacionService;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import javafx.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValidacionControllerTest {

    @InjectMocks
    private ValidacionController controller;

    @Mock
    private ValidacionService validacionService;

    @Test
    public void validacion() throws Exception {
        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture.getAtributosValidacion("CriterioVencMaxCurse7",
                        false,
                        "",
                        "",
                        Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.BASICO),
                                new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                new Pair("PL104", CategoriaAtributoEnum.BASICO),
                                new Pair("PO123", CategoriaAtributoEnum.BASICO),
                                new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                new Pair("CU117", CategoriaAtributoEnum.BASICO)
                        )))
                .build();

        when(validacionService.validacion(any(TipoLimiteFull.class), any(PerfilUser.class))).thenReturn(new ValidacionResponse());
        assertNotNull(controller.validacion(request, PerfilUserFixture.getPerfilUser()));
    }
}