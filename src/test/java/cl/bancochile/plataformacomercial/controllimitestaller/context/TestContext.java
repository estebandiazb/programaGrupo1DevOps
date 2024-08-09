package cl.bancochile.plataformacomercial.controllimitestaller.context;

import cl.bancochile.plataformacomercial.controllimitestaller.fixture.KeyArgumentResolverPerfilUserFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.KeyArgumentResolverRutFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.service.SubTipoService;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class TestContext extends WebMvcConfigurerAdapter{

    private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messages";

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    static {
        System.setProperty("log4j.configurationFile", "log4j2_test.xml");
    }

    @Bean
    public KeyArgumentResolverRutFixture resolverKeyArgument() {
        return new KeyArgumentResolverRutFixture();
    }

    @Bean
    public KeyArgumentResolverPerfilUserFixture resolverKeyArgumentPerfilUser() {
        return new KeyArgumentResolverPerfilUserFixture();
    }

    @Bean
    public SubTipoService subTipoService() {
        return Mockito.mock(SubTipoService.class);
    }
}
