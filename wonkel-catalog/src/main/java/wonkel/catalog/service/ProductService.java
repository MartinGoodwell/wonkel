package wonkel.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wonkel.catalog.model.Product;
import wonkel.catalog.repo.ProductRepository;

@Service
public class ProductService {

  private ProductRepository productRepo;
  
  public Product getProduct(Long productId) {
    return productRepo.findOne(productId);
  }
  
  @Autowired
  public void setProductRepo(ProductRepository productRepo) {
    this.productRepo = productRepo;
  }
}
