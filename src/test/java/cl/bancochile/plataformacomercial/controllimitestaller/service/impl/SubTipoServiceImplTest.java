package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.VariableFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaEstadoFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EditarItemVariableRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarItemVariableRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerFamiliaSubtipoPorIdRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerItemVariablePorIdRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.internal.util.Assert;

import java.util.ArrayList;

import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.VariableFixture.getSubtipos;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubTipoServiceImplTest {

    @InjectMocks
    private SubTipoServiceImpl service;

    @Mock
    private CrearFamiliaSubtipoRepository crearFamiliaSubtipoRepository;
    @Mock
    private ObtenerFamiliaSubtipoPorIdRepository obtenerFamiliaSubtipoPorIdRepository;
    @Mock
    private ActualizaEstadoFamiliaSubtipoRepository actualizaEstadoFamiliaSubtipoRepository;
    @Mock
    private CrearSubtipoRepository crearSubtipoRepository;
    @Mock
    private EliminarItemVariableRepository eliminarItemVariableRepository;
    @Mock
    private EditarItemVariableRepository editarItemVariableRepository;
    @Mock
    private ObtenerFamiliaSubtipoRepository obtenerFamiliaSubtipoRepository;
    @Mock
    private ObtenerItemVariablePorIdRepository obtenerItemVariablePorIdRepository;
    @Mock
    private EliminarFamiliaSubtipoRepository eliminarFamiliaSubtipoRepository;

    @Test
    public void crearFamiliaSubtipo() throws PlataformaBaseException {
        when(crearFamiliaSubtipoRepository.ejecutar(anyString()))
                .thenReturn(1L);
        Assert.notNull(service.crearFamiliaSubtipo("Familia Subtipo"));
    }

    @Test
    public void guardarSubtipo() throws PlataformaBaseException {
        when(obtenerFamiliaSubtipoPorIdRepository.ejecutar(anyLong()))
                .thenReturn(VariableFixture.getFamiliaSubtipo("Familia Subtipo"))
                .thenReturn(VariableFixture.getFamiliaSubtipo("Familia Guardar Agregar", getSubtipos()))
                .thenReturn(VariableFixture.getFamiliaSubtipo("Familia Guardar Eliminar", getSubtipos("subtipo 1", "subtipo 2", "subtipo 3")))
                .thenReturn(VariableFixture.getFamiliaSubtipo("Familia Guardar Editar", getSubtipos("subtipo 1", "subtipo 2")));

        doNothing().when(actualizaEstadoFamiliaSubtipoRepository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class));
        when(crearFamiliaSubtipoRepository.ejecutar(anyString()))
                .thenReturn(1L);
        doNothing().when(crearSubtipoRepository).ejecutar(any(ItemVariable.class), anyLong());
        doNothing().when(eliminarItemVariableRepository).ejecutar(anyLong());
        doNothing().when(editarItemVariableRepository).ejecutar(any(ItemVariable.class));

        service.guardarSubtipo(VariableFixture.getFamiliaSubtipo("Familia Subtipo"));
        service.guardarSubtipo(VariableFixture.getFamiliaSubtipo("Familia Guardar Agregar", getSubtipos((Long)null, "subtipo 1")));
        service.guardarSubtipo(VariableFixture.getFamiliaSubtipo("Familia Guardar Eliminar", getSubtipos("subtipo 1", "subtipo 2")));
        service.guardarSubtipo(VariableFixture.getFamiliaSubtipo("Familia Guardar Editar", getSubtipos("subtipo 1", "subtipo 2 editado")));
        service.guardarSubtipo(VariableFixture.getFamiliaSubtipo("Familia Subtipo Actualizada"));

    }

    @Test
    public void obtenerFamiliasSubtipo() throws PlataformaBaseException {
        when(obtenerFamiliaSubtipoRepository.ejecutar())
                .thenReturn(new ArrayList<Variable>());
        Assert.notNull(service.obtenerFamiliasSubtipo());
    }

    @Test
    public void obtenerItemPorId() throws PlataformaBaseException {
        when(obtenerItemVariablePorIdRepository.ejecutar(anyLong()))
                .thenReturn(new ArrayList<ItemVariable>());
        Assert.notNull(service.obtenerItemPorId(1l));
    }

    @Test
    public void eliminaFamiliaSubtipo() throws PlataformaBaseException {
        doNothing().when(eliminarFamiliaSubtipoRepository).ejecutar(anyLong());
        service.eliminaFamiliaSubtipo(1l);
    }
}
