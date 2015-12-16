package wonkel.catalog.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wonkel.catalog.model.Category;

@Component
@FeignClient(url = "http://catalog.wonkel:8082/")
public interface WonkelCategoryClient {
  
  @RequestMapping(method=RequestMethod.GET, value="/tree")
  List<Category> categoryTree();
  
}
