package wonkel.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

  @RequestMapping(method=RequestMethod.GET, value="/info", produces="application/json")
  public String status() {
    return "{}";
  }
}
