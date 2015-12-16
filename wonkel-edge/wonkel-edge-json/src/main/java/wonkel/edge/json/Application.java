package wonkel.edge.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("wonkel.catalog.client")
public class Application {

  
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    
    
  }
  
}
