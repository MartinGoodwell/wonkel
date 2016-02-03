package wonkel.catalog.client;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wonkel.catalog.model.Product;

@Component
@FeignClient("catalog-service")
public interface WonkelProductGetClient {

  @RequestMapping(method=RequestMethod.GET, value="/product/{id}")
  Product product(@PathVariable("id") Long id);
  
  @RequestMapping(method=RequestMethod.GET, value="/cat/{category}/products")
  Collection<Product> products(@PathVariable("category") String category);

  @RequestMapping(method=RequestMethod.GET, value="/actor/{actor}/products")
  Collection<Product> productsOfActor(@PathVariable("actor") String actor);
}
