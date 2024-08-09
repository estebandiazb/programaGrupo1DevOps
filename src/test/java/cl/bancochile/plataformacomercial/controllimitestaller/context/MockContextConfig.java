package cl.bancochile.plataformacomercial.controllimitestaller.context;

import cl.bancochile.bchdao.SimpleDaoConfiguration;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

@Configuration
@ImportResource("classpath:spring/simple-sp-dao.xml")
@ComponentScan(basePackages = {
        "cl.bancochile.plataformacomercial.controllimitestaller.repository"
})
public class MockContextConfig {

    @Bean
    public SimpleDaoConfiguration defaultSimpleDaoConfiguration() {
        SimpleDaoConfiguration config = new SimpleDaoConfiguration();
        config.setPrefixOutParam("OUT_");
        config.setDataSource(Mockito.mock(DataSource.class));
        return config;
    }

}
