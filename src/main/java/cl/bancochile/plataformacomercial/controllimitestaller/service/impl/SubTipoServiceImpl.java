package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;
import cl.bancochile.plataformacomercial.controllimitestaller.predicates.CrearFamiliaSubtipoPredicate;
import cl.bancochile.plataformacomercial.controllimitestaller.predicates.EditarFamiliaSubtipoPredicate;
import cl.bancochile.plataformacomercial.controllimitestaller.predicates.EliminarFamiliaSubtipoPredicate;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaEstadoFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EditarItemVariableRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarItemVariableRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerFamiliaSubtipoPorIdRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerItemVariablePorIdRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.service.SubTipoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum.HISTORICO;

@Service
public class SubTipoServiceImpl implements SubTipoService {

    @Autowired
    private CrearFamiliaSubtipoRepository crearFamiliaSubtipoRepository;
    @Autowired
    private ObtenerFamiliaSubtipoPorIdRepository obtenerFamiliaSubtipoPorIdRepository;
    @Autowired
    private CrearSubtipoRepository crearSubtipoRepository;
    @Autowired
    private ActualizaEstadoFamiliaSubtipoRepository actualizaEstadoFamiliaSubtipoRepository;
    @Autowired
    private EliminarItemVariableRepository eliminarItemVariableRepository;
    @Autowired
    private EditarItemVariableRepository editarItemVariableRepository;
    @Autowired
    private ObtenerFamiliaSubtipoRepository obtenerFamiliaSubtipoRepository;
    @Autowired
    private ObtenerItemVariablePorIdRepository obtenerItemVariablePorIdRepository;
    @Autowired
    private EliminarFamiliaSubtipoRepository eliminarFamiliaSubtipoRepository;

    @Override
    public Variable crearFamiliaSubtipo(String nombreFamiliaSubtipo) throws PlataformaBaseException {
        long idFamiliaSubtipo = crearFamiliaSubtipoRepository.ejecutar(nombreFamiliaSubtipo);
        return new Variable.Builder()
                .id(idFamiliaSubtipo)
                .build();
    }

    @Override
    public void guardarSubtipo(Variable familiaSubtipo) throws PlataformaBaseException {
        // Obtener datos guardados en la familia de Subtipo
        Variable familiaSubtipoSaved =
                obtenerFamiliaSubtipoPorIdRepository.ejecutar(familiaSubtipo.getId());

        /*
            Modificaciones Familia:
            En caso de existir diferencias de nombre se actualiza estado historico a la familia actual,
            se crea nueva version de familia y se asocian todos los subtipos.
         */
        if (!familiaSubtipo.getNombre().equals(familiaSubtipoSaved.getNombre())) {
            actualizaEstadoFamiliaSubtipoRepository.ejecutar(familiaSubtipo.getId(), HISTORICO);
            long idFamiliaSubtipo = crearFamiliaSubtipoRepository.ejecutar(familiaSubtipo.getNombre());
            for (ItemVariable subtipo : familiaSubtipo.getItems()) {
                crearSubtipoRepository.ejecutar(subtipo, idFamiliaSubtipo);
            }
            return;
        }

        /*
            Modificaciones Subtipos:
            Se generan filtros entre los subtipos actuales y los guardados anteriormente, se crean, editan o eliminan.
         */
        List<ItemVariable> subtiposACrear = new ArrayList<>();
        List<ItemVariable> subtiposAEditar = new ArrayList<>();
        List<ItemVariable> subtiposAEditarPredicate = new ArrayList<>();
        List<ItemVariable> subtiposAEliminar = new ArrayList<>();
        List<ItemVariable> subtiposAEliminarPredicate = new ArrayList<>();

        CollectionUtils.addAll(subtiposACrear, familiaSubtipo.getItems().toArray());
        CollectionUtils.addAll(subtiposAEditar, familiaSubtipo.getItems().toArray());
        CollectionUtils.addAll(subtiposAEditarPredicate, familiaSubtipoSaved.getItems().toArray());
        CollectionUtils.addAll(subtiposAEliminar, familiaSubtipoSaved.getItems().toArray());
        CollectionUtils.addAll(subtiposAEliminarPredicate, familiaSubtipo.getItems().toArray());

        CollectionUtils.filter(subtiposACrear, new CrearFamiliaSubtipoPredicate());
        CollectionUtils.filter(subtiposAEditar, new EditarFamiliaSubtipoPredicate(subtiposAEditarPredicate));
        CollectionUtils.filter(subtiposAEliminar, new EliminarFamiliaSubtipoPredicate(subtiposAEliminarPredicate));

        crearSubtipos(subtiposACrear, familiaSubtipo.getId());
        editarSubtipos(subtiposAEditar);
        eliminarSubtipos(subtiposAEliminar);
    }

    private void crearSubtipos(List<ItemVariable> subtipos, long idFamiliaSubitpo) throws PlataformaBaseException {
        for (ItemVariable subtipo : subtipos) {
            crearSubtipoRepository.ejecutar(subtipo, idFamiliaSubitpo);
        }
    }

    private void editarSubtipos(List<ItemVariable> subtipos) throws PlataformaBaseException {
        for (ItemVariable subtipo : subtipos) {
            editarItemVariableRepository.ejecutar(subtipo);
        }
    }

    private void eliminarSubtipos(List<ItemVariable> subtipos) throws PlataformaBaseException {
        for (ItemVariable subtipo : subtipos) {
            eliminarItemVariableRepository.ejecutar(subtipo.getId());
        }
    }

    @Override
    public List<Variable> obtenerFamiliasSubtipo()
            throws PlataformaBaseException {
        return obtenerFamiliaSubtipoRepository.ejecutar();
    }

    @Override
    public List<ItemVariable> obtenerItemPorId(Long idVariable)
            throws PlataformaBaseException {
        return obtenerItemVariablePorIdRepository.ejecutar(idVariable);
    }

    @Override
    public void eliminaFamiliaSubtipo(Long idFamilia)
            throws PlataformaBaseException {
        eliminarFamiliaSubtipoRepository.ejecutar(idFamilia);
    }
}
