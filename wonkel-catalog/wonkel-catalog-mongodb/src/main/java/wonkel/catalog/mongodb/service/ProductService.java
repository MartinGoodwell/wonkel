package wonkel.catalog.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wonkel.catalog.model.Product;
import wonkel.catalog.mongodb.repo.ProductRepository;

@Service
public class ProductService {

  private ProductRepository productRepo;
  
  public Product getProduct(Long productId) {
    return productRepo.findOne(productId);
  }
  
  public List<Product> getProducts(String category) {
    return productRepo.findByGenres(category);
  }
  
  public List<Product> getProductsOfActor(String actor) {
    return productRepo.findByActors(actor);
  }
  
  public void saveProduct(Product product) {
    productRepo.save(product);
  }
  
  public void saveProducts(Iterable<Product> products) {
    productRepo.save(products);
  }

  @Autowired
  public void setProductRepo(ProductRepository productRepo) {
    this.productRepo = productRepo;
  }
  
}
