package com.example.swagger.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        String description =
        		  "서비스간에 연동되는 API 서버가 어떤 규격으로 동작하는지 공유하거나 API 테스트를 위해서\n "
        		+ "문서작업 혹은 이를 테스트 할 수 있는 테스트용 페이지가 필요한데,\n "
        		+ "Swagger는 API가 가지고 있는 규격(SPEC)을 자동화해서 정리하고 테스트도 간편하게 할 수 있는 기능들을 제공합니다.\n "
        		+ "또 운영 혹은 고도화 등 진행되면서 규격이 변경 될 수가 있고 이에 문서 작업등을 새로 해야 하는데\n  "
        		+ "Swagger를 사용하면 이러한 과정이 자동화 되기 때문에 유지보수 및 작업 효율성을 높일 수 있습니다!\n ";
        return new ApiInfoBuilder()
                .title("API 문서 자동화 오픈소스 프레임워크 \n Swagger확인을 위한 데모 프로젝트")
                .description(description)
                .version("1.0")
                .build();
    }

}
