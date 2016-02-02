package wonkel.catalog.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wonkel.catalog.model.Product;

@Component
@FeignClient("catalog-service")
public interface WonkelProductPostClient {

  @RequestMapping(method=RequestMethod.POST, value="/product", consumes="application/json", produces="application/json")
  void saveProduct(@RequestBody Product input);

  @RequestMapping(method=RequestMethod.POST, value="/products", consumes="application/json", produces="application/json")
  void saveProducts(@RequestBody Iterable<Product> input);
}
