package wonkel.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryTreeController {

  @RequestMapping(method=RequestMethod.GET, value="/tree", produces="application/json")
  public String tree() {
    return "{}";
  }
}
