package wonkel.catalog.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import wonkel.catalog.model.Product;

@FeignClient("catalog-service")
public interface WonkelProductClient {

  @RequestMapping(method=RequestMethod.GET, value="/product/{id}")
  Product product(@RequestParam("id") Long id);
  
  @RequestMapping(method=RequestMethod.GET, value="/{categoryId}/products")
  List<Product> products(@RequestParam("categoryId") Long categoryId);
}
