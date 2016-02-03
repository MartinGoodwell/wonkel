package wonkel.catalog.mockdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryListController {

  /**
   * Lists all assets of a category (might be products and subcategories)
   * @author MartinGoodwell
   * @return empty list
   */
  @RequestMapping(method=RequestMethod.GET, value="/list", produces="application/json")
  public String list() {
    return "{}";
  }
}
