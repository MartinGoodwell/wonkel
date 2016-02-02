package wonkel.catalog.mongodb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
//@EnableHystrix
@Configuration
public class CatalogApplication {

  @Value("${spring.data.mongodb.host}")
  private String mongoHost;
  
  public static void main(String[] args) {
    SpringApplication.run(CatalogApplication.class, args);
  }

  public @Bean MongoDbFactory mongoDbFactory() throws Exception {
    return new SimpleMongoDbFactory(new MongoClient(), "wonkel-catalog");
  }

}