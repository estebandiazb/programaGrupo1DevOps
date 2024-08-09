package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.impl.PerfilUserImpl;
import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.InfoBasicaCliente;
import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.InfoCliente;
import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.Inhabilidad;
import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.Jerarquia;
import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.Producto;

import java.util.List;

/**
 * Created by jaime.morales.castro on 12-Jun-17.
 */
public class PerfilUserFixture {

    public static PerfilUserImpl getPerfilUser(){
        PerfilUserImpl p = new PerfilUserImpl();
        p.setRut("12-2");
        p.setNombre("nombre");
        p.setUsuario("pcalderon");
        p.setCodigo("1");
        p.setCodigoOficina("001");
        p.setGlosaOficina("Oficina");
        p.setCorreo("p@gmail.com");
        p.setTelefono("12345");
        p.setOficinaContable("215454545");
        p.setCiudad("65656");
        p.setDireccion("56565");
        p.setGlosaRegion("656565");
        p.setRutReemplazantes(null);
        p.setCodigoBanca("1");
        p.setBanca("banca");
        p.setCodigoMarca("1");
        p.setMarca("2");
        p.setCodigoRol("6565");
        p.setRol("6565");
        p.setCanal("6565");
        return p;
    }

    public static InfoCliente getInfoCliente(){
        InfoCliente infoCliente = new InfoCliente() {
            @Override
            public String getRutCliente() {
                return "1-9";
            }

            @Override
            public String getNombre() {
                return "nombreCliente";
            }

            @Override
            public String getApellidoPaterno() {
                return "apellidoPaterno";
            }

            @Override
            public String getApellidoMaterno() {
                return null;
            }

            @Override
            public String getOficinaEjecutivo() {
                return null;
            }

            @Override
            public String getCodigoEjecutivo() {
                return null;
            }

            @Override
            public String getNombreEjecutivo() {
                return null;
            }

            @Override
            public String getApellidoPaternoEjecutivo() {
                return null;
            }

            @Override
            public String getApellidoMaternoEjecutivo() {
                return null;
            }

            @Override
            public String getCorreoEjecutivo() {
                return null;
            }

            @Override
            public String getCodigoPaisEjecutivo() {
                return null;
            }

            @Override
            public String getCodigoCiudadEjecutivo() {
                return null;
            }

            @Override
            public String getTelefono() {
                return null;
            }

            @Override
            public String getSegmento() {
                return null;
            }

            @Override
            public String getMarca() {
                return null;
            }

            @Override
            public String getBanca() {
                return null;
            }

            @Override
            public String getClasificacionRiesgo() {
                return null;
            }

            @Override
            public String getActividadEconomica() {
                return null;
            }

            @Override
            public String getCategoria() {
                return null;
            }

            @Override
            public String getCodigoSegmento() {
                return null;
            }

            @Override
            public String getCodigoMarca() {
                return null;
            }

            @Override
            public String getCodigoBanca() {
                return null;
            }

            @Override
            public String getCodigoActividadEconomica() {
                return null;
            }

            @Override
            public String getFechaNacimiento() {
                return null;
            }

            @Override
            public String getFechaFallecimiento() {
                return null;
            }

            @Override
            public String getNombreOficina() {
                return null;
            }

            @Override
            public String getTipoCliente() {
                return null;
            }

            @Override
            public String getSexo() {
                return null;
            }

            @Override
            public String getDireccion() {
                return null;
            }

            @Override
            public String getNumeroDireccion() {
                return null;
            }

            @Override
            public String getComplementoDireccion() {
                return null;
            }

            @Override
            public String getComuna() {
                return null;
            }

            @Override
            public String getCiudad() {
                return null;
            }

            @Override
            public String getRegion() {
                return null;
            }

            @Override
            public String getPais() {
                return null;
            }

            @Override
            public String getTipoDespacho() {
                return null;
            }

            @Override
            public String getCui() {
                return null;
            }

            @Override
            public String getCodigoCategoria() {
                return null;
            }

            @Override
            public String getRowIdDireccion() {
                return null;
            }

            @Override
            public String getCodigoPaisFonoPartCliente() {
                return null;
            }

            @Override
            public String getCodigoCiudadPartCliente() {
                return null;
            }

            @Override
            public String getFonoParticularCliente() {
                return null;
            }

            @Override
            public String getCodigoPaisCelularCliente() {
                return null;
            }

            @Override
            public String getCodigoCiudadCelularCliente() {
                return null;
            }

            @Override
            public String getCelularParticularCliente() {
                return null;
            }

            @Override
            public String getEmailParticularCliente() {
                return null;
            }

            @Override
            public String getCodigoPaisFonoComCliente() {
                return null;
            }

            @Override
            public String getCodigoCiudadFonoComCliente() {
                return null;
            }

            @Override
            public String getFonoComercialCliente() {
                return null;
            }

            @Override
            public String getEmailComercialCliente() {
                return null;
            }

            @Override
            public String getEmailAlternativoEjecutivo() {
                return null;
            }

            @Override
            public String getRutEjecutivo() {
                return null;
            }

            @Override
            public List<Inhabilidad> getInhabilidades() {
                return null;
            }

            @Override
            public String getNacionalidad() {
                return null;
            }

            @Override
            public String getPaisOrigen() {
                return null;
            }

            @Override
            public String getEstadoCivil() {
                return null;
            }

            @Override
            public String getRegimenMatrimonial() {
                return null;
            }

            @Override
            public String getTipoFATCA() {
                return null;
            }

            @Override
            public String getTinNumSeguroSocial() {
                return null;
            }

            @Override
            public String getRutContacto() {
                return null;
            }

            @Override
            public String getNombreContacto() {
                return null;
            }

            @Override
            public String getApellidoPaternoContacto() {
                return null;
            }

            @Override
            public String getApellidoMaternoContacto() {
                return null;
            }

            @Override
            public String getTipoRelacionContato() {
                return null;
            }

            @Override
            public String getRutConyuge() {
                return null;
            }

            @Override
            public String getTipoVivienda() {
                return null;
            }

            @Override
            public String getNroDependencia() {
                return null;
            }

            @Override
            public String getAnoResidencia() {
                return null;
            }

            @Override
            public String getMarcaFuncionario() {
                return null;
            }

            @Override
            public String getNivelEstudios() {
                return null;
            }

            @Override
            public String getProfesion() {
                return null;
            }

            @Override
            public String getRutEmpleador() {
                return null;
            }

            @Override
            public String getNombreEmpleador() {
                return null;
            }

            @Override
            public String getCargo() {
                return null;
            }

            @Override
            public String getTipoContrato() {
                return null;
            }

            @Override
            public String getFechaContrato() {
                return null;
            }

            @Override
            public String getTipoRenta() {
                return null;
            }

            @Override
            public String getTipoPagoPension() {
                return null;
            }

            @Override
            public String getFondoPension() {
                return null;
            }

            @Override
            public String getUsoBancoMonto() {
                return null;
            }

            @Override
            public String getTipoIngrLiquido() {
                return null;
            }

            @Override
            public String getMontoIngreso() {
                return null;
            }

            @Override
            public String getFechaActualizacionIngreso() {
                return null;
            }

            @Override
            public String getMarcaComparteBcaPrivada() {
                return null;
            }

            @Override
            public String getIdioma() {
                return null;
            }

            @Override
            public String getFlagEnviaCorreo() {
                return null;
            }

            @Override
            public String getDesSexo() {
                return null;
            }

            @Override
            public String getDesCui() {
                return null;
            }

            @Override
            public String getComportamiento() {
                return null;
            }

            @Override
            public String getNombreCompleto() {
                return null;
            }

            @Override
            public boolean isExiste() {
                return false;
            }

            @Override
            public String getFechaAntiguedad() {
                return null;
            }

            @Override
            public boolean isRutConfidencial() {
                return false;
            }

            @Override
            public InfoBasicaCliente getInformacionBasica() {
                return null;
            }

            @Override
            public List<Producto> getProductos() {
                return null;
            }

            @Override
            public String getTieneMarcaPep() {
                return null;
            }

            @Override
            public String getSeccion360() {
                return null;
            }

            @Override
            public String getMarcaFallecimiento() {
                return null;
            }

            @Override
            public String getEstadoCliente() {
                return null;
            }

            @Override
            public String getMarcaAccionista() {
                return null;
            }

            @Override
            public String getMarcaRelacionado() {
                return null;
            }

            @Override
            public String getIndicadorRutTemporal() {
                return null;
            }

            @Override
            public String getComportamientoCCH() {
                return null;
            }

            @Override
            public String getMarcaQuiebra() {
                return null;
            }

            @Override
            public String getFechaQuibra() {
                return null;
            }

            @Override
            public String getFechaDeterioro() {
                return null;
            }

            @Override
            public String getMarcaProhibicionCredito() {
                return null;
            }

            @Override
            public String getMarcaInterdicto() {
                return null;
            }

            @Override
            public String getMarcaProhibicionCuentaCorriente() {
                return null;
            }

            @Override
            public String getMarcaPreFATCA() {
                return null;
            }

            @Override
            public String getPlanTarifario() {
                return null;
            }

            @Override
            public String getInstitucionEducacional() {
                return null;
            }

            @Override
            public String getCarrera() {
                return null;
            }

            @Override
            public String getSemestreCursa() {
                return null;
            }

            @Override
            public String getAntiguedadLaboral() {
                return null;
            }

            @Override
            public String getCargoIndependiente() {
                return null;
            }

            @Override
            public String getMarcaIndependiente() {
                return null;
            }

            @Override
            public String getAntiguedadIndependiente() {
                return null;
            }

            @Override
            public Integer getTipoCargo() {
                return null;
            }

            @Override
            public String getBancaEje() {
                return null;
            }

            @Override
            public String getCompletitudEstudios() {
                return null;
            }

            @Override
            public String getFechaAntiguedadCuentaCorriente() {
                return null;
            }

            @Override
            public String getJefeDirectorio() {
                return null;
            }

            @Override
            public Integer getMontoIngresoEstimado() {
                return null;
            }

            @Override
            public List<Jerarquia> getJerarquiasEjecutivo() {
                return null;
            }

            @Override
            public String getMarcaAutenticado() {
                return null;
            }
        };

        return infoCliente;

    }
}
