package wonkel.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductViewController {

  @RequestMapping(method=RequestMethod.GET, value="/product", produces="application/json")
  public String product() {
    return "{}";
  }
}
