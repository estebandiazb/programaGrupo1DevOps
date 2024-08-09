package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;

import java.util.List;

public interface ObtenerMonedasRepository {

    List<MonedaBanco> ejecutar();

}
