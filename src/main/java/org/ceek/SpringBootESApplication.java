package org.ceek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@PropertySource(value = {"classpath:config/esconstants.properties"}, encoding = "utf-8")
public class SpringBootESApplication  extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(SpringBootESApplication.class);

        // 初始化缓存监听
//		application.addListeners(new InitMediaCacheListener());

        //用来解决springboot整合elasticsearch的部分报错
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
        application.run(args);
        // SpringApplication.run(SculptorApplication.class, args);
    }
    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
