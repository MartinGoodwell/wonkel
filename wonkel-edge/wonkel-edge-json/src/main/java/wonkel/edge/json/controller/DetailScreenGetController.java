package wonkel.edge.json.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wonkel.catalog.model.Category;
import wonkel.catalog.model.Product;
import wonkel.edge.json.command.HystrixCategoryCommand;
import wonkel.edge.json.command.HystrixProductDetailCommand;
import wonkel.edge.json.model.DetailScreenModel;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DetailScreenGetController {

  private HystrixProductDetailCommand prodClient;
  private HystrixCategoryCommand catClient;
  
  @RequestMapping(value="/product/{productId}", produces="application/json")
  public DetailScreenModel loadDetailScreen(@PathVariable("productId") Long productId) {
    Product product = prodClient.execute(productId);
    List<Category> categories = catClient.execute();
    
    return new DetailScreenModel(product, categories);
  }
  
  @Autowired
  public void setProdClient(HystrixProductDetailCommand prodClient) {
    this.prodClient = prodClient;
  }
  
  @Autowired
  public void setCatClient(HystrixCategoryCommand catClient) {
    this.catClient = catClient;
  }
}
