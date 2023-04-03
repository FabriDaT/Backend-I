package config;

import java.io.IOException;

import org.apache.log4j.lf5.util.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import jakarta.annotation.Nullable;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/static/**")
          .addResourceLocations("classpath:/static/")
          .setCachePeriod(31556926)
          .resourceChain(true)
          .addResolver(new PathResourceResolver() {
              protected @Nullable MediaType getMediaType(Resource resource) throws IOException{
                  if( resource!=null) {
                      String filename = resource.getName();
                      if(filename.endsWith(".css")) {
                          return MediaType.valueOf("text/css");
                      } else if(filename.endsWith(".js")) {
                          return MediaType.valueOf("application/javascript");
                      } else if(filename.endsWith(".html")) {
                          return MediaType.valueOf("text/html");
                      }
                  }
                  return MediaType.APPLICATION_OCTET_STREAM;
              }
          });
    }
 
}


