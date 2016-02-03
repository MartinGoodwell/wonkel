package wonkel.catalog.mockdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CatalogServiceMock {

  public static void main(String[] args) {
    SpringApplication.run(CatalogServiceMock.class, args);
  }
}
