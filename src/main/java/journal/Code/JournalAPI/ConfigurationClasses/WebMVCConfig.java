package journal.Code.JournalAPI.ConfigurationClasses;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Component
public class WebMVCConfig extends WebMvcConfigurerAdapter {


        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");
        }

        @Bean
        CorsRegistry getCorsRegistry() {
            return new CorsRegistry();
        }

}
