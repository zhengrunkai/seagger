package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author : 郑润楷
 * @Date : 2021-01-05 10:04
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket createDocket(){
        List<Parameter> par=new ArrayList<>();
        ParameterBuilder accessTokenBuilder=new ParameterBuilder();
        ParameterBuilder refreshTokenBuilder=new ParameterBuilder();
        accessTokenBuilder.name("authorization").description("程序员自测的时候动态传输AccessToken 入口")
                .modelRef(new ModelRef("String")).parameterType("header").required(false);
        refreshTokenBuilder.name("refreshToken").description("程序员自测的时候动态传输RefreshToken 入口")
                .modelRef(new ModelRef("String")).parameterType("header").required(false);
        par.add(accessTokenBuilder.build());
        par.add(refreshTokenBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(par)
                .enable(enable);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("进入平台")
                .description("我的描述")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
