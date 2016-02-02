package wonkel.catalog.mongodb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @RequestMapping(method=RequestMethod.GET, value="/health", produces="application/json")
  public String health() {
    return "{}";
  }
}
