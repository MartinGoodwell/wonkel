package wonkel.catalog.mockdb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wonkel.catalog.client.WonkelProductGetClient;
import wonkel.catalog.mockdb.service.ProductService;
import wonkel.catalog.model.Product;

@RestController
public class ProductGetController implements WonkelProductGetClient {

  private ProductService productService;

  /**
   * Everything for querying single or multiple products
   * 
   * @author MartinGoodwell
   *
   */
  @Override
  @RequestMapping(method = RequestMethod.GET, value = "/product/{id}", produces = "application/json")
  public Product product(@PathVariable("id") Long id) {
    return productService.getProduct(Long.valueOf(id));
  }

  @Override
  @RequestMapping(method = RequestMethod.GET, value = "/cat/{category}/products", produces = "application/json")
  public Collection<Product> products(@PathVariable("category") String category) {
    return productService.getProducts(category);
  }

  @Override
  @RequestMapping(method = RequestMethod.GET, value = "/actor/{actor}/products", produces = "application/json")
  public Collection<Product> productsOfActor(@PathVariable("actor") String actor) {
    return productService.getProductsOfActor(actor);
  }

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }
}
