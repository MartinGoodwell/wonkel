package wonkel.catalog.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wonkel.catalog.client.WonkelProductPostClient;
import wonkel.catalog.model.Product;
import wonkel.catalog.mongodb.service.ProductService;

@RestController
public class ProductPostController implements WonkelProductPostClient {

  private ProductService productService;
  
  @Override
  @RequestMapping(method=RequestMethod.POST, value="/product", consumes="application/json", produces="application/json")
  public void saveProduct(@RequestBody Product input) {
    productService.saveProduct(input);
  }
  
  @Override
  @RequestMapping(method=RequestMethod.POST, value="/products", consumes="application/json", produces="application/json")
  public void saveProducts(@RequestBody Iterable<Product> input) {
    productService.saveProducts(input);
  }
  
  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }
}
