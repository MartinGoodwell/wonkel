package wonkel.catalog.mockdb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wonkel.catalog.mockdb.service.CategoryService;
import wonkel.catalog.model.Category;

@RestController
@RequestMapping(method = RequestMethod.GET, produces = "application/json")
public class CategoryTreeController {

  private Logger logger = LoggerFactory.getLogger(CategoryTreeController.class);

  private CategoryService categoryService;

  /**
   * returns a list of available categories. It's called tree because categories
   * could be hierarchical in theory. So far, it's flat.
   * 
   * @return list of available categories
   */
  @RequestMapping(value = "/tree")
  public Category[] tree() {
    logger.info("called tree()");
    return categoryService.getCategories();
  }

  @Autowired
  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }
}
