package egen.WeatherMVCProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/api/*").apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		Contact contact=new Contact("admin", "https://egen.io", "dev@egen.io");
		ApiInfo info=new ApiInfo("Spring Weather MVC", "Weather app using spring MVC", "1.0.0", "T&C", contact, "MIT", "https://opensource.org/licenses/MIT");
		return info;
	}
	
}
