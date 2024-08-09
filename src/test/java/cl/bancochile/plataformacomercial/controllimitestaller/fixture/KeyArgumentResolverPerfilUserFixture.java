package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class KeyArgumentResolverPerfilUserFixture implements HandlerMethodArgumentResolver {


    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(PerfilUser.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return this.getPerfilUser();
    }

    private Object getPerfilUser() {
        return PerfilUserFixture.getPerfilUser();
    }
}
