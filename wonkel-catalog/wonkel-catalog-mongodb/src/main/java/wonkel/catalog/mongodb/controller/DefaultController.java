package wonkel.catalog.mongodb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

  @RequestMapping(method=RequestMethod.GET, value="/", produces="application/json")
  public String root() {
    return "{}";
  }
}
