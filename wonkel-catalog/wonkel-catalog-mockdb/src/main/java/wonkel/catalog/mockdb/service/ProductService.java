package wonkel.catalog.mockdb.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import wonkel.catalog.model.Product;

@Service
public class ProductService {

  private final Map<Long, Product> productMap = new HashMap<>();
  
  public ProductService() {
    productMap.put(1L, new Product(1L, "Title", "Description", "imagePath", new String[]{}, new String[]{}));
  }
  
  public Product getProduct(Long productId) {
    return productMap.get(productId);
  }
  
  public Collection<Product> getProducts(String category) {
    return productMap.values();
  }
  
  public Collection<Product> getProductsOfActor(String actor) {
    return productMap.values();
  }
  
  public void saveProduct(Product product) {
//    productRepo.save(product);
  }
  
  public void saveProducts(Iterable<Product> products) {
//    productRepo.save(products);
  }
  
}
