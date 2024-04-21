package com.vitek.javalabs.swwagger;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vitek.javalabs.swagger.SwaggerConfig;

import springfox.documentation.spring.web.plugins.Docket;

@ExtendWith(MockitoExtension.class)
class SwaggerConfigTest {
    @Test
    void testApi() {
        SwaggerConfig swaggerConfig = new SwaggerConfig();
        swaggerConfig.api();

        Docket docket = swaggerConfig.api();

        assertNotNull(docket);

    }
}
