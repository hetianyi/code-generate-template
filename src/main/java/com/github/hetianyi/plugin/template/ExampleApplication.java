package com.github.hetianyi.plugin.template;

import com.github.hetianyi.boot.ready.config.swagger.AutoConfigureSwagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * code-generator-plugin的示例模板
 *
 * @author Jason He
 */
@SpringBootApplication
@AutoConfigureSwagger
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
