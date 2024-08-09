package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ActualizaEstadoLimite2RepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ActualizaEstadoLimite2RepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException{
        TipoLimite tipoLimite = new TipoLimite.Builder()
                .id(1l)
                .estado(EstadoTipoLimiteEnum.ACTIVO)
                .build();
        repository.ejecutar(tipoLimite);
    }

    @Test(expected = Exception.class)
    public void ejecutaNOK() throws PlataformaBaseException{
        TipoLimite tipoLimite = new TipoLimite.Builder()
                .id(0L)
                .estado(EstadoTipoLimiteEnum.HISTORICO)
                .build();
        setupNOK();
        repository.ejecutar(tipoLimite);
    }
}
