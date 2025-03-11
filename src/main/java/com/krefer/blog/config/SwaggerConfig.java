package com.krefer.blog.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	private List<SecurityContext> securityContexts() {
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}

	private List<SecurityReference> sf() {
		AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
		
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] { scope}));
	}

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apiKey())).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {

//		return new ApiInfo("Blogging Web Application Backend Course ", "This project developed for practice ", "1.0",
//				"Terms of mine", new Contact("pankaj", "visitkinfo.com", "kumawatpankaj719@gmail.com"),
//				"my licence of api ", Collections.emptyList());

		return new ApiInfo("Blogging Web Application Backend", // ✅ Fixed title
				"This project is developed for practice.", // ✅ Fixed typo
				"1.0", "Terms of Service URL",
				new Contact("Pankaj Kumawat", "https://visitkinfo.com", "kumawatpankaj719@gmail.com"), "API License",
				"https://opensource.org/licenses/MIT", // ✅ Added license URL
				Collections.emptyList());

	}
}
