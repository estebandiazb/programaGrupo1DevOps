package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.utils.Rut;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class KeyArgumentResolverRutFixture implements HandlerMethodArgumentResolver {


    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Rut.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return this.getRut();
    }

    private Object getRut() {
        Rut rut = new Rut("18677632-1");
        return rut;
    }
}
