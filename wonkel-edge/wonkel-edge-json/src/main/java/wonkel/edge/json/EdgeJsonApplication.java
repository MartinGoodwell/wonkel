package wonkel.edge.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("wonkel.catalog.client")
public class EdgeJsonApplication {

  public static void main(String[] args) {
    SpringApplication.run(EdgeJsonApplication.class, args);
  }

}
