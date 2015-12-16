package wonkel.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wonkel.catalog.model.Product;
import wonkel.catalog.service.ProductService;


@RestController
public class ProductViewController {

  private ProductService productService;
  
  /**
   * Returns details about a single product
   * @author MartinGoodwell
   *
   */
  @RequestMapping(method=RequestMethod.GET, value="/product/{id}", produces="application/json")
  public Product product(@RequestParam("id") long id) {
    return productService.getProduct(id);
  }
  
  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }
}
