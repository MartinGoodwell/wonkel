package wonkel.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Lists all assets of a category (might be products and subcategories)
 * @author MartinGoodwell
 */
@RestController
public class CategoryListController {

  @RequestMapping(method=RequestMethod.GET, value="/list", produces="application/json")
  public String list() {
    return "{}";
  }
}
